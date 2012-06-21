package org.dusong.edm.tool;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Md5Utils {

	private final Log logger = LogFactory.getLog(getClass());
	public String getMd5(String value){
		StringBuffer sb = new StringBuffer(32);  
        
	    try {  
	        MessageDigest md    = MessageDigest.getInstance("MD5");  
	        byte[] array        = md.digest(value.getBytes("utf-8"));  
	              
	        for (int i = 0; i < array.length; i++) {  
	            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));  
	        }  
	    } catch (Exception e) {  
	        logger.error("Can not encode the string '" + value + "' to MD5!", e);  
	        return null;  
	    }
		return sb.toString();
	}
}
