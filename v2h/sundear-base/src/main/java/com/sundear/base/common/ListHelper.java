package com.sundear.base.common;

import java.util.List;

public class ListHelper {

    public static String ListToString(List<String> strArray) {
        StringBuffer toList = new StringBuffer();
        if(strArray==null||strArray.size()==0){
        	return "";
        }
        int length = strArray.size();
        if (strArray != null && length < 2) {
            toList.append(strArray.get(0));
        } else {
            for (int i = 0; i < length; i++) {
                toList.append(strArray.get(i));
                if (i != (length - 1)) {
                    toList.append(",");
                }

            }
        }
        return toList.toString();
    }
    public static String ListToStringBySeparator(List<String> strArray,String separator) {
        StringBuffer toList = new StringBuffer();
        if(strArray==null||strArray.size()==0){
        	return "";
        }
        int length = strArray.size();
        if (strArray != null && length < 2) {
            toList.append(strArray.get(0));
        } else {
            for (int i = 0; i < length; i++) {
                toList.append(strArray.get(i));
                if (i != (length - 1)) {
                    toList.append(separator);
                }

            }
        }
        return toList.toString();
    }

}
