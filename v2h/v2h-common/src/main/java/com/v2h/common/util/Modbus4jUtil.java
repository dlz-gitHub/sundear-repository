package com.v2h.common.util;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;

/**  
* @ClassName: Modbus4jUtil  
* @Description: TODO(使用modbus tcp的工具类)
* @date 2019年3月20日 下午1:53:05 
* @author dlz   
*/
public class Modbus4jUtil {
	//设置地址和端口
	private static String url = "localhost";
	private static Integer port = 502;
	//声明modbus工厂
	public static ModbusFactory modbusFactory;
	static {
		if (modbusFactory == null) {
			modbusFactory = new ModbusFactory();
		}
	}
	/**
	 * 
	* @Title: getMaster  
	* @Description: TODO(获取master)  
	* @author dlz
	 */
	public static ModbusMaster getMaster() throws ModbusInitException {
		IpParameters params = new IpParameters();
		//设置获取地址和端口
		params.setHost(url);
		params.setPort(port);
		//创建不同的协议形式
		// modbusFactory.createRtuMaster(wapper); //RTU 协议
		// modbusFactory.createUdpMaster(params);//UDP 协议
		// modbusFactory.createAsciiMaster(wrapper);//ASCII 协议
		ModbusMaster master = modbusFactory.createTcpMaster(params, false);// TCP 协议
		master.init();
		return master;
	}
	/**
	 * 
	* @Title: readCoilStatus  
	* @Description: TODO(读取[01 Coil Status 0x]读线圈寄存器)  
	* @author dlz
	 */
	public static Boolean readCoilStatus(int slaveId, int offset)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 01 Coil Status(读线圈寄存器)
		BaseLocator<Boolean> loc = BaseLocator.coilStatus(slaveId, offset);
		Boolean value = getMaster().getValue(loc);
		return value;
	}
	/**
	 * 
	* @Title: readInputStatus  
	* @Description: TODO(读取[02 Input Status 1x] 读状态寄存器)  
	* @author dlz
	 */
	public static Boolean readInputStatus(int slaveId, int offset)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 02 Input Status( 读状态寄存器)
		BaseLocator<Boolean> loc = BaseLocator.inputStatus(slaveId, offset);
		Boolean value = getMaster().getValue(loc);
		return value;
	}
	/**
	 * 
	* @Title: readHoldingRegister  
	* @Description: TODO(读取[03 Holding Register类型 2x]读保持寄存器)  
	* @author dlz
	 */
	public static Number readHoldingRegister(int slaveId, int offset, int dataType)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 03 Holding Register类型数据读取(读保持寄存器)
		BaseLocator<Number> loc = BaseLocator.holdingRegister(slaveId, offset, dataType);
		Number value = getMaster().getValue(loc);
		return value;
	}
	/**
	 * 
	* @Title: readInputRegisters  
	* @Description: TODO(读取[04 Input Registers 3x]类型读输入寄存器 )  
	* @author dlz
	 */
	public static Number readInputRegisters(int slaveId, int offset, int dataType)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 04 Input Registers类型数据读取(读输入寄存器 )
		BaseLocator<Number> loc = BaseLocator.inputRegister(slaveId, offset, dataType);
		Number value = getMaster().getValue(loc);
		return value;
	}
	/**
	 * 
	* @Title: batchRead  
	* @Description: TODO(批量读取使用方法)  
	* @author dlz
	 */
	public static void batchRead() throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		BatchRead<Integer> batch = new BatchRead<Integer>();
 
		batch.addLocator(0, BaseLocator.holdingRegister(1, 1, DataType.FOUR_BYTE_FLOAT));
		batch.addLocator(1, BaseLocator.inputStatus(1, 0));
		ModbusMaster master = getMaster();
		batch.setContiguousRequests(false);
		//BatchResults<Integer> results = master.send(batch);
		//输出结果
		//System.out.println(results.getValue(0));
		//System.out.println(results.getValue(1));
	}

	//测试类
	/*public static void main(String[] args) {
		try {
			// 01测试
			Boolean v011 = readCoilStatus(1, 0);
			Boolean v012 = readCoilStatus(1, 1);
			Boolean v013 = readCoilStatus(1, 6);
			System.out.println("v011:" + v011);
			System.out.println("v012:" + v012);
			System.out.println("v013:" + v013);
			// 02测试
			Boolean v021 = readInputStatus(1, 0);
			Boolean v022 = readInputStatus(1, 1);
			Boolean v023 = readInputStatus(1, 2);
			System.out.println("v021:" + v021);
			System.out.println("v022:" + v022);
			System.out.println("v023:" + v023);
 
			// 03测试
			Number v031 = readHoldingRegister(1, 1, DataType.FOUR_BYTE_FLOAT);// 注意,float
			Number v032 = readHoldingRegister(1, 3, DataType.FOUR_BYTE_FLOAT);// 同上
			System.out.println("v031:" + v031);
			System.out.println("v032:" + v032);
 
			// 04测试
			Number v041 = readInputRegisters(1, 1, DataType.FOUR_BYTE_FLOAT);//
			Number v042 = readInputRegisters(1, 3, DataType.FOUR_BYTE_FLOAT);//
			System.out.println("v041:" + v041);
			System.out.println("v042:" + v042);
			// 批量读取
			batchRead();
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
