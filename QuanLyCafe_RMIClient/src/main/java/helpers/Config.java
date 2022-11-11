package helpers;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Config {
	
	public static String getAddress() {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			System.out.println(ip.toString());
			return ip.toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}
