package com.sundear.base.common;

import java.io.File;

public class FileHelper {

	/**
	 * @功能 检查文件类型是否允许上传
	 * @param 原始文件名
	 * @param 允许上传文件的后缀名
	 * @return true=可以上传，false=不能上传
	 */
	public static boolean isAllowFileType(String fileName, String s) {
		if (s == null || s.equals("") || s.indexOf(getFileType(fileName)) <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * @功能 获取文件后缀
	 * @param 原始文件名
	 * @return 返回带".XXX"形式的大写后缀名
	 */
	public static String getFileType(String fileName) {
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
		return fileType.toUpperCase();
	}

	/**
	 * @功能 获取文件大小字符串
	 * @param 原始文件大小
	 * @return 返回带2位小数及单位的文件大小字符串
	 */
	public static String fileSizeToString(long fileSize) {
		if (fileSize >= new Long(1024) * 1024 * 1024 * 1024) {
			return String.format("%.2fT", (float) fileSize / 1024 / 1024 / 1024 / 1024);
		} else if (fileSize >= new Long(1024) * 1024 * 1024) {
			return String.format("%.2fG", (float) fileSize / 1024 / 1024 / 1024);
		} else if (fileSize >= 1024 * 1024) {
			return String.format("%.2fM", (float) fileSize / 1024 / 1024);
		} else if (fileSize >= 1024) {
			return String.format("%.2fK", (float) fileSize / 1024);
		} else {
			return String.format("%d字节", (int) fileSize);
		}
	}

	/**
	 * @param <T>
	 * @功能 获取文件类型值
	 * @param 原始文件名
	 * @return 返回遍历文件类型获得的值
	 */
	public static <T> int getFileTypeValue(String fileName, Class<T> enumT) {
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
		String[] a = { "XERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
		for (int i = 0; i < 10; i++) {
			fileType = fileType.replace(String.format("%d", i), a[i]);
		}
		try {
			return Integer.parseInt(EnumHelper.getEnumValueByName(fileType, enumT).toString());
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 删除空目录
	 * 
	 * @param dir
	 *            将要删除的目录路径
	 */
	public static void doDeleteEmptyDir(String dir) {
		boolean success = (new File(dir)).delete();
		if (success) {
			System.out.println("Successfully deleted empty directory: " + dir);
		} else {
			System.out.println("Failed to delete empty directory: " + dir);
		}
	}

	/**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
	public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
