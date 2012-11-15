/**
 * 
 */
package com.mschmidt.starter.encryption;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * @author mschmidt18@gmail.com
 * 
 */
public class ApplicationEncryptor {

	private StandardPBEStringEncryptor encryptor;
	private final String password = "changeit";

	public ApplicationEncryptor() {
		encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm("PBEWithMD5AndDES");
		encryptor.setPassword(password);
	}

	public StandardPBEStringEncryptor getEncryptor() {
		return encryptor;
	}

	public static void main(String[] args) {
		if (args != null && args.length > 1 && args[0].equals("encrypt")) {
			ApplicationEncryptor ae = new ApplicationEncryptor();
			String encrypted = ae.encrypt(args[1]);
			System.out.println("ENC(" + encrypted + ")");
		} else {
			System.out.println("Usage: encrypt value");
		}
	}

	private static void usage() {
		System.out.println("Usage: encrypt value");
	}

	/**
	 * Encrypt a value
	 * 
	 * @param unencryptedValue
	 * @return
	 */
	public String encrypt(String unencryptedValue) {
		String encryptedValue = encryptor.encrypt(unencryptedValue);
		return encryptedValue;
	}

	/**
	 * Decrypt an encrypted value
	 * 
	 * @param encryptedValue
	 * @return
	 */
	public String decrypt(String encryptedValue) {
		String unencryptedValue = encryptor.decrypt(encryptedValue);
		return unencryptedValue;
	}

}