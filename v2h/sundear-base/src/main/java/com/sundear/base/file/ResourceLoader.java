package com.sundear.base.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class ResourceLoader {
	public static String getProperty(String filePath,String key) throws IOException {
        Properties pps = new Properties();
        //InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(filePath);
        String path = getPathForWebinf();
        InputStream in = new FileInputStream(path+filePath);
        pps.load(in);
        in.close();
        return pps.getProperty(key);
    }
    // 读取Properties的全部信息
    public static Map<String,String> getAllProperties() throws IOException {
        Properties pps = new Properties();
        String path = getPathForWebinf();
        InputStream in = new FileInputStream(path);
        pps.load(in);
        in.close();
        Enumeration<?> en = pps.propertyNames();
        Map<String,String> map = new HashMap<String,String>();
        while (en.hasMoreElements()) {
            String strKey =  en.nextElement().toString();
            map.put(strKey,pps.getProperty(strKey));
        }
        return map;
    }
    public static Object setProperty(String filePath,String propertyName,String propertyValue) throws URISyntaxException, IOException {
        Properties p=new Properties();
        String path = getPathForWebinf();
        //InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(filePath);
        InputStream in = new FileInputStream(path+filePath);
        p.load(in);//
        in.close();
        Object o = p.setProperty(propertyName,propertyValue);//设置属性值，如属性不存在新建
        OutputStream out=new FileOutputStream(path+filePath);
        p.store(out,"modify");//设置属性头，如不想设置，请把后面一个用""替换掉
        out.flush();//清空缓存，写入磁盘
        out.close();//关闭输出流
        //ConfigInfo.initOrRefresh();//刷新缓存
        return o;
    }
    public static void setProperties(String filePath,Set<Entry<String, Object>> data) throws IOException, URISyntaxException{
        Properties p=new Properties();
        String path = getPathForWebinf();
        InputStream in = new FileInputStream(path+filePath);
        //InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(filePath);
        p.load(in);//
        in.close();

        for ( Entry<String,Object> entry : data) { //先遍历整个 people 对象  
            p.setProperty( entry.getKey(),entry.getValue().toString());//设置属性值，如属性不存在新建
        }  
        OutputStream out=new FileOutputStream(path+filePath);
        //new File(ConfigUtil.class.getClassLoader().getResource(ConfigInfo.PROPERTIES_DEFAULT).toURI()));//输出流
        p.store(out,"modify");//设置属性头，如不想设置，请把后面一个用""替换掉
        out.flush();//清空缓存，写入磁盘
        out.close();//关闭输出流
        //ConfigInfo.initOrRefresh();//刷新缓存
    }
    //获取WEB-INF路径
    public static String getPathForWebinf(){
        String path = ResourceLoader.class.getResource("/").getPath();//得到工程名WEB-INF/classes/路径
        if(path.indexOf(":")>=0){
        	path=path.substring(1, path.indexOf("classes"));//从路径字符串中取出工程路径
        }else{
        	path=path.substring(0, path.indexOf("classes"));//从路径字符串中取出工程路径
        }
        try {
			return URLDecoder.decode(path,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
    }
}
