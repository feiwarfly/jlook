package com.zlcd.security;

import com.zlcd.utils.Base64;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DES {

	private static final byte[] DES_KEY = { 20, 11, -114, 82, -32, -89, -128,
			-65 };


	public static String encode(String data) {
		String encryptedData = null;
		try {
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			encryptedData = Base64.encodeBytes(cipher.doFinal(data.getBytes()));

		} catch (Exception e) {
			throw new RuntimeException("Exception", e);
		}
		return encryptedData;
	}

	public static String decode(String cryptData) {
		String decryptedData = null;
		try {
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
			decryptedData = new String(cipher.doFinal(Base64.decode(cryptData)));
		} catch (Exception e) {
			throw new RuntimeException("Exception", e);
		}
		return decryptedData;
	}
}
