package selenideskeleton;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class GoogleSearchPage {
	
	@FindBy(xpath = "//div[@id='lga']/img")
	SelenideElement mainPicture;
	
	@FindBy(xpath = "//input[@name='q']")
	SelenideElement searchFiled;
	
	public void waitPageLoaded() {
		mainPicture.shouldBe(Condition.visible);
		searchFiled.shouldBe(Condition.visible);
	}

}
