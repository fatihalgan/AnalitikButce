public class HDSerialNumberReader {
	public native String getHDSerialNumber();

	static {
		System.loadLibrary("diskinfo");
	}

	public static void main(String[] args) {
		System.out.println("Seri NO: " + new HDSerialNumberReader().getHDSerialNumber());
	}
}
