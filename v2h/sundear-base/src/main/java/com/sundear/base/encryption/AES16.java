package com.sundear.base.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;

public class AES16 {
	/**
	 * @method AES加密方法
	 * @param keyBytes 加密密钥(即是通过前端传来的code在后端产生的sessionKey)已经经过base64解密          
	 * @param iv 加密算法  已经经过base64解密           
	 * @param content 要加密的内容 已经经过base64解密           
	 * @return 加完秘的內容
	 */
	public static byte[] Encrypt(byte[] content, byte[] keyBytes, byte[] ivBytes) {
		// 初始化 加密
		try {//由于java不支持AES/CBC/PKCS7Padding加密算法需要转成AES/CBC/PKCS5Padding
			Security.addProvider(new BouncyCastleProvider());  
			SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
			// AES/CBC/PKCS5Padding为默认AES的加密算法
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
			IvParameterSpec iv = new IvParameterSpec(ivBytes);
			cipher.init(Cipher.ENCRYPT_MODE, key ,iv);
			byte[] result = cipher.doFinal(content);
			System.out.println("result="+result);
			return result;
		} catch (Exception e) {
			System.out.println("exception:" + e.toString());
			return null;
		}		
	}

	/**
	 * @method AES解密方法
	 * @param keyBytes 加密密钥(即是通过前端传来的code在后端产生的sessionKey)已经经过base64解密          
	 * @param iv 加密算法  已经经过base64解密           
	 * @param content 要解密的内容 已经经过base64解密 
	 * @return 解密后的內容
	 */
	public static byte[] Decrypt(byte[] content, byte[] keyBytes, byte[] ivBytes) {

		try {//由于java不支持AES/CBC/PKCS7Padding加密算法需要转成AES/CBC/PKCS5Padding
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); 
			SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
			IvParameterSpec iv = new IvParameterSpec(ivBytes);			
			cipher.init(Cipher.DECRYPT_MODE, key, iv);
			byte[] result = cipher.doFinal(content);
			System.out.println("result="+result);
			return result;
		} catch (Exception e) {
			System.out.println("exception:" + e.toString());
			return null;
		}		
	}

	/**
	 * 字符串装换成base64
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return Base64.decodeBase64(key.getBytes());
	}

	/**
	 * 二进制装换成base64
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return new String(Base64.encodeBase64(key));
	}

	/**
	 * @param byte1
	 * @return String
	 */
	public static String byteToString(byte[] byte1) {
		return new String(byte1);
	}

	/**
	 * 随机生成秘钥
	 */
	public static String getKey() {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			kg.init(128);
			//要生成多少位，只需要修改这里即可128, 192或256
			SecretKey sk = kg.generateKey();
			byte[] b = sk.getEncoded();
			String s = byteToHexString(b);
		  //System.out.println(s);
			System.out.println("key的长度" + s.length());
			String key =null;
			if (s.length()>16) {//将密钥截取为16位
				key = s.substring(0, 16);
				System.out.println(key);
			}else if(s.length()==16){
				key = s;
			}else{
				System.out.println("密钥长度不符合规定");
				return "error";
			}
			return s;
		  //System.out.println("二进制密钥的长度为" + s.length() * 4);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("没有此算法。");
			return null;
		}		
	}

	/**
	 * 使用指定的字符串生成秘钥
	 */
	public static String getKeyByMobile(String mobile) {
		
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			// kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
			// SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
			kg.init(128, new SecureRandom(mobile.getBytes()));
			SecretKey sk = kg.generateKey();
			byte[] b = sk.getEncoded();
			String s = byteToHexString(b);
			System.out.println("key的长度" + s.length());
			String key =null;
			if (s.length()>16) {//将密钥截取为16位
				key = s.substring(0, 16);
				System.out.println(key);
			}else if(s.length()==16){
				key = s;
			}else{
				System.out.println("密钥长度不符合规定");
				return "error";
			}
			return s;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("没有此算法。");
			return null;
		}
	}
	/**
	 * byte数组转化为16进制字符串
	 * @param bytes
	 * @return
	 */
	public static String byteToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String strHex = Integer.toHexString(bytes[i]);
			if (strHex.length() > 3) {
				sb.append(strHex.substring(6));
			} else {
				if (strHex.length() < 2) {
					sb.append("0" + strHex);
				} else {
					sb.append(strHex);
				}
			}
		}
		return sb.toString();
	}
	
}
