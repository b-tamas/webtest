package Tests;

import WebSiteTester.Host;

public class TestDriver {

	public static void main(String[] args) {

		Host host = new Host("192.168.1.1");

		System.out.println("Reachable: " + host.isReachable());
		System.out.println("Port80: " + host.isRemotePortInUse(Host.PORT_HTTP));

	}

}
