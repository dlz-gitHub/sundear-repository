package com.sundear.v2h;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sundear.v2h.service.CabinService;
import com.sundear.v2h.service.CarportService;
import com.sundear.v2h.service.ContainerService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

@Component
@PropertySource("classpath:socket.properties")
public class SocketServer extends Thread {
	private static final Logger LOG = LoggerFactory.getLogger(SocketServer.class);
	@Autowired
	private ContainerService containerService;
	
	@Autowired
	private CabinService cabinService;
	
	@Autowired
	private CarportService carportService;

	@Value("${server.port}")
	private String port;
	
	private boolean started;
	private ServerSocket serverSocket;
	private Socket socket = null;
	// 逆变器编号
	static int inverterNumber = 1;
	// bms编号
	static int bmsNumber = 1;
	//pcs编号
	static int pcsDetailNumber = 1;
	//carport编号
	static int carportNumber = 1;
	
	public void start() {
		start(null);
	}

	public void start(Integer port) {

		try {
			serverSocket = new ServerSocket(port == null ? Integer.parseInt(this.port) : port);
			started = true;
		} catch (IOException e) {
			// System.out.println("端口出现异常");
			LOG.info("port 端口出现异常");
			System.exit(0);
		}

		while (started) {
			try {
				// System.out.println("开始监听");
				socket = serverSocket.accept();
				socket.setKeepAlive(true);
				// socket.setSoTimeout(500000);

				// System.out.println("创建子线程");
				// 创建内部集装箱线程
				SendMessgerContainerThread send = new SendMessgerContainerThread();
				send.start();
				// 读取数据
				InputStream in = socket.getInputStream();
				byte[] buff = new byte[2048];
				int len = -1;
				
				while ((len = in.read(buff)) != -1) {
					String messager = byteToHexString(buff);
					// System.out.println("收到返回消息："+messager);
					//处理后面的0
					messager = messager.substring(0,100);
					LOG.info("返回消息--return message-->" + messager);					
					if (messager.contains("01 03 18") && messager.startsWith("01 03 18")) {// 解析逆变器
						if (inverterNumber <= 3) {
							// 这里怎么处理逆变器的编号
							containerService.analysisInverter(messager, inverterNumber);
							inverterNumber++;
						} else if(inverterNumber > 3){
							inverterNumber = 1;
							// 新一轮数据开始
							containerService.analysisInverter(messager, inverterNumber);
							inverterNumber++;
						}
					} else if (messager.contains("01 03 06") && messager.startsWith("01 03 06")) {// 解析环境检测仪
						containerService.analysisEM(messager);
					} else if (messager.contains("01 03 08") && messager.startsWith("01 03 08")) {// 解析系统环境状态
						containerService.analysisSS(messager);
					} else if (messager.contains("01 03 0A") && messager.startsWith("01 03 0A")) {// 解析BMS
						if (bmsNumber <= 2) {
							containerService.analysisBMS(messager, bmsNumber);
							bmsNumber++;
						} else if(bmsNumber > 2){
							bmsNumber = 1;
							containerService.analysisBMS(messager, bmsNumber);
							bmsNumber++;
						}
					} else if (messager.contains("01 03 16") && messager.startsWith("01 03 16")) {// 解析PCS
						containerService.analysisPCS(messager);
					} else if (messager.contains("01 03 0E") && messager.startsWith("01 03 0E")) {// 解析PCS详情
						if (pcsDetailNumber <= 3) {
							// 这里怎么处理逆变器的编号
							containerService.analysisPCSDetail(messager, pcsDetailNumber);
							pcsDetailNumber++;
						} else if(pcsDetailNumber > 3){
							pcsDetailNumber = 1;
							// 新一轮数据开始
							containerService.analysisPCSDetail(messager, pcsDetailNumber);
							pcsDetailNumber++;
						}
					} else if (messager.contains("01 03 14") && messager.startsWith("01 03 14")) {// 解析PGL
						containerService.analysisPGL(messager);
					}else if(messager.contains("01 03 34") && messager.startsWith("01 03 34")) {//解析小木屋
						cabinService.analysisCabin(messager);
					}else if(messager.contains("01 03 4A") && messager.startsWith("01 03 4A")) {//解析车棚
						if (carportNumber <= 2) {
							carportService.analysisCarport(messager,carportNumber);
							carportNumber++;
						} else if(carportNumber > 2){
							carportNumber = 1;
							carportService.analysisCarport(messager,carportNumber);
							carportNumber++;
						}
					}else if(messager.startsWith("01 03 8")) {
						LOG.info("出现错误返回功能码"+messager);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Component
	class SendMessgerContainerThread extends Thread {

		@Scheduled(fixedDelay = 300000)
		//@Scheduled(fixedDelay = 100000)
		public void run() {
			super.run();
			// System.out.println("发送消息");
			OutputStream out = null;
			try {
				if (socket != null) {
					// 发送数据报文
					out = socket.getOutputStream();
					//集装箱逆变器
					out.write(hexStrToBinaryStr("01 03 00 02 00 0C E4 0F"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					out.write(hexStrToBinaryStr("01 03 00 22 00 0C E5 C5"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					out.write(hexStrToBinaryStr("01 03 00 42 00 0C E5 DB"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					
					//集装箱环境检测
					out.write(hexStrToBinaryStr("01 03 00 60 00 03 05 D5"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					
					//集装箱系统信息
					out.write(hexStrToBinaryStr("01 03 00 70 00 04 45 D2"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					
					//集装箱bms
					out.write(hexStrToBinaryStr("01 03 01 F4 00 05 C5 C7"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					out.write(hexStrToBinaryStr("01 03 02 08 00 05 05 B3"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					
					//集装箱pcs
					out.write(hexStrToBinaryStr("01 03 02 27 00 0B B5 BE"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					
					//集装箱pcs详情
					out.write(hexStrToBinaryStr("01 03 02 33 00 07 F5 BF"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					out.write(hexStrToBinaryStr("01 03 02 39 00 07 D5 BD"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					out.write(hexStrToBinaryStr("01 03 02 41 00 07 55 A4"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					
					//集装箱电网负载
					out.write(hexStrToBinaryStr("01 03 02 4E 00 0A A4 62"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					
					//发送小木屋的报文
					out.write(hexStrToBinaryStr("01 03 02 58 00 1A 44 6A"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
					
					//发送移动车棚报文
					out.write(hexStrToBinaryStr("01 03 02 76 00 25 64 73"));
					out.flush();// 清空缓存区的内容
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	// 16进制字符串转换成字节数组
	public byte[] hexStrToBinaryStr(String hexString) {

		if (hexString.isEmpty()) {
			return null;
		}

		hexString = hexString.replaceAll(" ", "");

		int len = hexString.length();
		int index = 0;

		byte[] bytes = new byte[len / 2];

		while (index < len) {

			String sub = hexString.substring(index, index + 2);

			bytes[index / 2] = (byte) Integer.parseInt(sub, 16);

			index += 2;
		}

		return bytes;
	}

	// 字节数组转换成16进制字符串
	/*private String BinaryToHexString(byte[] bytes) {
		String hexStr = "0123456789ABCDEF";
		String result = "";
		String hex = "";
		for (byte b : bytes) {
			hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
			hex += String.valueOf(hexStr.charAt(b & 0x0F));
			result += hex + " ";
		}
		return result;
	}
*/
	public static String byteToHexString(byte[] b) {
		String stmp = "";
		StringBuilder sb = new StringBuilder("");
		for (byte c : b) {
			stmp = Integer.toHexString((c & 0xFF));// 与预算，去掉byte转int带来的补位
			sb.append((stmp.length() == 1) ? "0" + stmp : stmp);// 是一位的话填充零
			sb.append(" ");// 每位数据用空格分隔
		}
		return sb.toString().toUpperCase().trim();// 变换大写，并去除首尾空格
	}
}