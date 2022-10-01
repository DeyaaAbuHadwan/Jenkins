import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParameterJenkinsTest {

	@Test
	public void test() throws IOException {
		FileReader readFile = new FileReader("src\\test\\resources\\props.properties");
		Properties prop = new Properties();
		prop.load(readFile);
		String userName = prop.getProperty("username");
		String pw = prop.getProperty("pw");
		Assert.assertEquals(userName, "rasha");
	}

}
