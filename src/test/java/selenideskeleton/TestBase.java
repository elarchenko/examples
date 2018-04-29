package selenideskeleton;

import org.testng.annotations.BeforeSuite;

import com.codeborne.selenide.Configuration;

public class TestBase {
	
	@BeforeSuite()
	public void suiteSetup() {
		Configuration.browser = "phantomjs";
		System.setProperty("phantomjs.binary.path", "./ext/phantomjs.exe");
		Configuration.timeout = 10000;
	}

}
