package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHotelResultPage{
    private final int WAIT_TIMEOUT_SECOND = 20;
    private final String XPATH_FOR_CHOOSE_SEARCH_ARRIVAL_DATE = "//input[@id='q-localised-check-in']";

    private WebDriver driver;
    private SearchQueryMain hotelTerms;

    private WebElement arrivalDateInputSearch;


    public SearchHotelResultPage(WebDriver driver, SearchQueryMain hotelTerms){
        this.driver = driver;
        this.hotelTerms = hotelTerms;
        PageFactory.initElements(driver, this);
    }

    public String changedArrivalDateTerm(){
        arrivalDateInputSearch = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_CHOOSE_SEARCH_ARRIVAL_DATE)));
        String newArrivalDate = arrivalDateInputSearch.getAttribute("value");
        return newArrivalDate;
    }
}
