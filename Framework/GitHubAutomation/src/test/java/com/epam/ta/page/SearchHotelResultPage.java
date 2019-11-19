package com.epam.ta.page;

import com.epam.ta.model.SearchQueryMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHotelResultPage extends AbstractPage{

    private final String XPATH_FOR_CHOOSE_SEARCH_DEPARTURE_DATE = /*"//input[@id='q-localised-check-in']"*/"//input[@id='q-localised-check-out']";

    private SearchQueryMain hotelTerms;

    private WebElement departureDateInputSearch;

    public SearchHotelResultPage(WebDriver driver, SearchQueryMain hotelTerms){
        super(driver);
        this.hotelTerms = hotelTerms;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SearchHotelResultPage openPage(){
        return this;
    }

    public String changedDepartureDateTerm(){
        departureDateInputSearch = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_CHOOSE_SEARCH_DEPARTURE_DATE)));
        return departureDateInputSearch.getAttribute("value");
    }
}
