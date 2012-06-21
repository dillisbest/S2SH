package org.dusong.edm.test;

import org.dusong.edm.tool.Md5Utils;

public class md5Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Md5Utils md5 = new Md5Utils();
		System.out.println(md5.getMd5("dill"));
	}

}
