package cn.tedu.cloud_note.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class NoteUtil {
	
	/**
	 * md5加密
	 */
	public static String md5(String str){
		String result="";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
	        
	        //加密后的字符串
	        result=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
    }
}
