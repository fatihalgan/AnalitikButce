public class KeyUtility {

	public static java.security.Key generateSecretKey() throws java.security.NoSuchAlgorithmException {
		return javax.crypto.KeyGenerator.getInstance("DESede").generateKey();
	}

	public static String getStringSecretKey(java.security.Key skey) {
		return (new sun.misc.BASE64Encoder().encodeBuffer(skey.getEncoded()));
	}

	public static java.security.Key reconstituteKey(String s) throws java.io.IOException {
		byte[] data = (new sun.misc.BASE64Decoder().decodeBuffer(s));
		return new javax.crypto.spec.SecretKeySpec(data, "DESede");
	}
}