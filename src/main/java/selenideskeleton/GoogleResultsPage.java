package selenideskeleton;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class GoogleResultsPage {
	
	@FindBy(css = "div.g")
	ElementsCollection searchResults;
	
	public boolean clickOnLink(String title, String url) {
		for (SelenideElement curResult : searchResults.filter(Condition.visible)) {
			if (title.equals(curResult.$(By.xpath("h3")).text()) &
					url.equals(curResult.$(By.xpath("//cite")).text())) {
				curResult.$(By.xpath("h3/a")).followLink();
				return true;
			}
		}
		System.out.println("Can't find search result with '" + title + "' and url '" +
				url + "' on the fisrt page");
		return false;
	}
	
	public void waitPageLoaded() {
		searchResults.shouldHave(CollectionCondition.sizeGreaterThan(0));
	}
	
}
