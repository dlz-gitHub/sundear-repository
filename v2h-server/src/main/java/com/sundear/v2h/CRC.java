package com.sundear.v2h;

/**
 * @ClassName: Snippet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2019年4月8日 下午3:25:16
 * @author dlz
 */
public class CRC {
	public static String getCRC(byte[] bytes) {
		// CRC寄存器全为1
		int CRC = 0x0000ffff;
		// 多项式校验值
		int POLYNOMIAL = 0x0000a001;
		int i, j;
		for (i = 0; i < bytes.length; i++) {
			CRC ^= ((int) bytes[i] & 0x000000ff);
			for (j = 0; j < 8; j++) {
				if ((CRC & 0x00000001) != 0) {
					CRC >>= 1;
					CRC ^= POLYNOMIAL;
				} else {
					CRC >>= 1;
				}
			}
		}
		// 结果转换为16进制
		String result = Integer.toHexString(CRC).toUpperCase();
		if (result.length() != 4) {
			StringBuffer sb = new StringBuffer("0000");
			result = sb.replace(4 - result.length(), 4, result).toString();
		}
		// 交换高低位
		return result.substring(2, 4) + " " + result.substring(0, 2);
	}

	// 传入字符串形式的报文得到校验码
	public static String getCRC(String data) {// 得到字符数组
		data = data.replace(" ", "");
		int len = data.length();
		if (!(len % 2 == 0)) {
			return "0000";
		}
		int num = len / 2;
		byte[] para = new byte[num];
		for (int i = 0; i < num; i++) {
			int value = Integer.valueOf(data.substring(i * 2, 2 * (i + 1)), 16);
			para[i] = (byte) value;
		}
		// 计算校验码
		return getCRC(para);
	}
	public static void main(String[] args) {
		String data = "01 03 02 41 00 07";
		System.out.println(data+" "+getCRC(data));
	}
}
