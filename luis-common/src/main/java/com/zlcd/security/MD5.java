package com.zlcd.security;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class MD5 {
	public static String md5(String str) {
		Charset charset = Charset.forName("utf-8");

		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		byte[] md5Bytes = md5.digest(str.getBytes(charset));
		BigInteger b = new BigInteger(1, md5Bytes);
		return b.toString(16);
	}

	public static String md5(byte[] bytes) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		byte[] md5Bytes = md5.digest(bytes);
		BigInteger b = new BigInteger(1, md5Bytes);
		return b.toString(16);
	}
}
