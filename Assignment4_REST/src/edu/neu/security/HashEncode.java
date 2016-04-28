package edu.neu.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashEncode {

	public enum ALGO{
		MD5("MD5");
		
		public String algo;
		
		private ALGO(String algo) {
			this.algo = algo;
		}
		
		@Override
		public String toString() {
			return algo;
		}
	}
	
	private HashEncode(){
		
	}
	
	public static String generateHash(String msg, ALGO algo){
		String hash = null;
		
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(algo.toString());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hashedBytes = digest.digest(msg.getBytes());
		
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < hashedBytes.length; i++) 
		{
			stringBuffer.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16).substring(1));
		}

			hash = stringBuffer.toString();
		return hash;
	}
}
