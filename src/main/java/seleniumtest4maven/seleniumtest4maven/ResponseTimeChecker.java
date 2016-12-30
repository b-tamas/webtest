package seleniumtest4maven.seleniumtest4maven;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.lang3.time.StopWatch;

public class ResponseTimeChecker {

	public static void main(String[] args) throws Exception {

		Integer DBG = null;

		StopWatch watch = new StopWatch();

		watch.start();
		URL oracle = new URL("https://tamasbakai.wordpress.com/");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				oracle.openStream()));

		if (null != DBG) {
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
		}

		watch.stop();
		in.close();

		// System.out.println(String.format("%s %s %d: %s", method.getName(),
		// method.getURI(), method.getStatusCode(), watch.toString()));
		System.out.println(String.format("%s", watch.toString()));

	}
}
