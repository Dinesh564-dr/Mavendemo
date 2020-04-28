package Day12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Readconfigfile {
	public void readproperties() {
		try {

			Properties pro = new Properties();
			pro.load(new FileInputStream(new File(System.getProperty("user.dir") + "/config/config.properties")));
			String browser = pro.getProperty("Browser");
			String prod = pro.getProperty("proEnv");
			System.out.println("from config file        " + browser);
			System.out.println("from config file        " + prod);

		} catch (FileNotFoundException e) {
			System.out.println("file not found" + e.getMessage());
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("could not read properties file" + e.getMessage());
			Assert.assertTrue(false);
		}

	}
}
