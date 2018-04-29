package selenideskeleton;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CBRBasePage {
	
	@FindBy(css = "span.ico-logo")
	SelenideElement logo;
	
	@FindBy(css = "a[href='/Reception/']")
	SelenideElement receptionLink;
	
	public void waitPageLoaded() {
		logo.shouldBe(Condition.visible);
	}

}
