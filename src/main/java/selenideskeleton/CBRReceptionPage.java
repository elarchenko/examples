package selenideskeleton;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class CBRReceptionPage extends CBRBasePage {
	
	public SelenideElement getContentButtonByText(String text) {
		return $("div#content").$(By.linkText(text)).shouldBe(Condition.visible);
	}

}
