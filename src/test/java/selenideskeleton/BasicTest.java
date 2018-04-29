package selenideskeleton;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.annotations.Report;

import utils.Mail;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

@Report
public class BasicTest extends TestBase {
	
	@Test()
	public void exampleTest() {
		GoogleSearchPage mainPage = open("https://www.google.ru", GoogleSearchPage.class);
		mainPage.waitPageLoaded();
		mainPage.searchFiled.setValue("Цетральный банк РФ");
		mainPage.searchFiled.pressEnter();
		GoogleResultsPage resultsPage = Selenide.page(GoogleResultsPage.class);
		resultsPage.waitPageLoaded();
		String cbrUrl = "https://www.cbr.ru/";
		resultsPage.clickOnLink("Центральный банк Российской Федерации", cbrUrl);
		CBRMainPage cbrMain = Selenide.page(CBRMainPage.class);
		cbrMain.waitPageLoaded();
		Assert.assertEquals(url(), cbrUrl);
		cbrMain.receptionLink.click();
		CBRReceptionPage reception = Selenide.page(CBRReceptionPage.class);
		reception.waitPageLoaded();
		reception.getContentButtonByText("Написать благодарность").click();
		CBRMessageRegisterPage messagePage = Selenide.page(CBRMessageRegisterPage.class);
		messagePage.waitPageLoaded();
		messagePage.messageArea.sendKeys("текст благодарности");
		messagePage.agreementCheckbox.setSelected(true);
		String screenshotPath = "./target/surefire-reports/exampleTest";
		screenshot(screenshotPath);
		Mail.send("targetAddress", "fromAddress", "password", "smtp_host", "Message title", 
				System.getProperty("user.dir") + "\\build\\reports\\tests\\target\\surefire-reports\\exampleTest.png");
	}

}
