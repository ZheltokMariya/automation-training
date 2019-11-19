package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.ta.model.SearchQueryMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsHomePage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private static final String HOMEPAGE_URL = "https://ru.hotels.com/";

    private final static String XPATH_FOR_SEARCH_BUTTON = "//button[@class='cta cta-strong']";
    private final static String XPATH_FOR_PLACE_INPUT = "//input[@id='qf-0q-destination']";
    private final static String XPATH_FOR_ROOMS_SELECT = "//select[@id='qf-0q-rooms']";
    private final static String XPATH_FOR_DEPARTURE_DATE_INPUT= "//input[@id='qf-0q-localised-check-out']";
    private final static String XPATH_FOR_ARRIVAL_DATE_INPUT = "//input[@id='qf-0q-localised-check-in']";
    private final static String XPATH_FOR_LONG_STAY_LINK = "//div[@class='form-error']/span/a";
    private final static String XPATH_FOR_HEADLINE = "//h1[@class='cont-hd-alt widget-query-heading']";

    @FindBy(xpath = XPATH_FOR_PLACE_INPUT)
    private WebElement placeInput;

    @FindBy(xpath = XPATH_FOR_ARRIVAL_DATE_INPUT)
    private WebElement arrivalDateInput;

    @FindBy(xpath = XPATH_FOR_DEPARTURE_DATE_INPUT)
    private WebElement departureDateInput;

    @FindBy(xpath = XPATH_FOR_ROOMS_SELECT)
    private WebElement roomsSelect;

    @FindBy(xpath = XPATH_FOR_SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = XPATH_FOR_LONG_STAY_LINK)
    private WebElement longStayLink;

    @FindBy(xpath = XPATH_FOR_HEADLINE)
    private WebElement headline;

    public HotelsHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HotelsHomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Home Page opened");
        return this;
    }

    public SearchHotelResultPage searchHotelForMainTerms(SearchQueryMain hotelTerms){
        defineMainTermsForSearchHotel(hotelTerms);
        logger.info("Search hotel result page opened");
        return new SearchHotelResultPage(driver, hotelTerms);
    }

    public HotelsHomePage searchHotelForLongStay(SearchQueryMain hotelTerms){
        defineMainTermsForSearchHotel(hotelTerms);
        return this;
    }

    public FormToSearchHotelsForLongStayPage obtainFormToSearchHotelForLongStay(){
        longStayLink = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_LONG_STAY_LINK)));
        longStayLink.click();
        logger.info("Page with form for search hotels for long stay opend");
        return new FormToSearchHotelsForLongStayPage(driver);
    }

    public void defineMainTermsForSearchHotel(SearchQueryMain hotelTerms){
        placeInput.sendKeys(hotelTerms.getPlace());
        headline.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_ARRIVAL_DATE_INPUT)));
        arrivalDateInput.clear();
        arrivalDateInput.sendKeys(hotelTerms.getArrivalDate());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_DEPARTURE_DATE_INPUT)));
        departureDateInput.clear();
        departureDateInput.sendKeys(hotelTerms.getDepartureDate());
        headline.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ROOMS_SELECT)));
        roomsSelect.sendKeys(String.valueOf(hotelTerms.getRoomsNumber()));
        headline.click();
        searchButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_SEARCH_BUTTON)));
        searchButton.click();
    }
}
