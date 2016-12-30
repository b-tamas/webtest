package WebSiteTester;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Host {

	public static final int PORT_HTTP = 80;

	public static final int PORT_FTP_DATA = 20;
	public static final int PORT_FTP_CONTROL = 21;
	public static final int PORT_SSH = 22;
	public static final int PORT_UDP = 23;

	public static final int PORT_SMTP = 25;
	public static final int PORT_DNS = 53;
	public static final int PORT_TFTP = 69;
	public static final int PORT_POP3 = 110;

	public static final int PORT_SQL = 156;
	public static final int PORT_SNMP = 161;
	public static final int PORT_SNMPTRAP = 162;

	private int pingTimeout;
	private String ip;

	public Host(String ip) {
		super();
		this.ip = ip;
		this.pingTimeout = 5000;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPingTimeout() {
		return this.pingTimeout;
	}

	public void setPingTimeout(int pingTimeout) {
		pingTimeout = this.pingTimeout;
	}

	public boolean isLocalPortInUse(int portNumber) {
		try {
			// ServerSocket try to open a LOCAL port
			new ServerSocket(portNumber).close();
			// local port can be opened, it's available
			return false;
		} catch (IOException e) {
			// local port cannot be opened, it's in use
			return true;
		}
	}

	public boolean isRemotePortInUse(int portNumber) {
		try {
			// Socket try to open a REMOTE port
			new Socket(this.ip, portNumber).close();
			// remote port can be opened, this is a listening port on remote
			// machine
			// this port is in use on the remote machine !
			return true;
		} catch (Exception e) {
			// remote port is closed, nothing is running on
			return false;
		}
	}

	public boolean isReachable() {
		try {

			return InetAddress.getByName(this.ip).isReachable(this.pingTimeout);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
