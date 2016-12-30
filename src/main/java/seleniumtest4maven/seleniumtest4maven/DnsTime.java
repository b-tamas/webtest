package seleniumtest4maven.seleniumtest4maven;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.commons.lang3.time.StopWatch;

public class DnsTime {

	public static void main(String[] args) throws Exception {

		StopWatch watch = new StopWatch();
		DirContext ctx = new InitialDirContext();

		// String url = "www.blblalbalblablalbalbla.com";
		String url = "www.wordpress.com";

		Attributes attr = null;

		watch.start();
		try {
			attr = ctx.getAttributes("dns:/" + url);

		} catch (NamingException ne) {
			System.out.println("naming exception in DNS" + ne.toString());
		}
		watch.stop();

		if (attr.get("a") == null) {
			System.out.println("not IP info in DNS response");
			System.exit(-1);
		}

		String ip = attr.get("a").get().toString();
		System.out.println("Resolved IP: " + ip.toString());
		System.out.println(String.format("%s", watch.toString()));

	}
}
