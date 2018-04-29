package selenideskeleton;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CBRMessageRegisterPage extends CBRBasePage {
	
	@FindBy(xpath = "//textarea[@id='MessageBody']")
	SelenideElement messageArea;
	
	@FindBy(xpath = "//input[@id='_agreementFlag']")
	SelenideElement agreementCheckbox;
	
	public void waitPageLoaded() {
		super.waitPageLoaded();
		messageArea.shouldBe(Condition.visible);
		agreementCheckbox.shouldBe(Condition.visible);
	}

}
