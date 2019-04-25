package com.sundear.v2h.service;

/**  
* @ClassName: ContainerService  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2019年4月4日 下午5:19:07 
* @author dlz   
*/
public interface ContainerService {
	//解析逆变器的报文
	public void analysisInverter(String messager,int inverterNumber);
	
	public void analysisEM(String messager);
	
	public void analysisSS(String messager);
	
	public void analysisBMS(String messager,int bmsNumber);
	
	public void analysisPCS(String messager);
	
	public void analysisPCSDetail(String messager,int pcsDetailNumber);
	
	public void analysisPGL(String messager);
}
