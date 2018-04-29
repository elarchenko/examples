package selenideskeleton;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class CBRMainPage extends CBRBasePage {
	
	@FindBy(xpath = "//div[@class='banners_list']//a")
	ElementsCollection banners;
	
	public void waitPageLoaded() {
		super.waitPageLoaded();
		for (SelenideElement curBanner : banners) {
			curBanner.$(By.xpath("//img")).shouldBe(Condition.visible);
			curBanner.$(By.xpath("//img")).isImage();
		}
		
	}

}
