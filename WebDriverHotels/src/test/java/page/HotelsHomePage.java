package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsHomePage {
    private final int WAIT_TIMEOUT_SECOND = 30;

    private static final String HOMEPAGE_URL = "https://ru.hotels.com/";
    private final static String XPATH_FOR_SEARCH_BUTTON = "//button[@class='cta cta-strong']";
    private final static String XPATH_FOR_ROOMS_ADULTS_SELECT = "//select[@id='qf-0q-compact-occupancy']";
    private final static String XPATH_FOR_DEPARTURE_DATE_INPUT= "//input[@id='qf-0q-localised-check-out']";
    private final static String XPATH_FOR_ARRIVAL_DATE_INPUT = "//input[@id='qf-0q-localised-check-in']";
    private final static String XPATH_FOR_LONG_STAY_LINK = "//div[@class='form-error']/span/a";
    private final static String XPATH_FOR_HEADLINE = "//h1[@class='cont-hd-alt widget-query-heading']";

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='qf-0q-destination']")
    private WebElement placeInput;

    @FindBy(xpath = XPATH_FOR_ARRIVAL_DATE_INPUT)
    private WebElement arrivalDateInput;

    @FindBy(xpath = XPATH_FOR_DEPARTURE_DATE_INPUT)
    private WebElement departureDateInput;

    @FindBy(xpath = XPATH_FOR_ROOMS_ADULTS_SELECT)
    private WebElement roomsAdultsSelect;

    @FindBy(xpath = XPATH_FOR_SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = XPATH_FOR_LONG_STAY_LINK)
    private WebElement longStayLink;

    @FindBy(xpath = XPATH_FOR_HEADLINE)
    private WebElement headline;

    public HotelsHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HotelsHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchHotelResultPage searchHotelForMainTerms(SearchQueryMain hotelTerms){
        defineMainTermsForSearchHotel(hotelTerms);
        return new SearchHotelResultPage(driver, hotelTerms);
    }

    public HotelsHomePage searchHotelForLongStay(SearchQueryMain hotelTerms){
        defineMainTermsForSearchHotel(hotelTerms);
        return new HotelsHomePage(driver);
    }

    public String chooseHotelForLongStay(){
        longStayLink = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_LONG_STAY_LINK)));
        longStayLink.click();
        return driver.getCurrentUrl();
    }

    public void defineMainTermsForSearchHotel(SearchQueryMain hotelTerms){
        placeInput.sendKeys(hotelTerms.getPlace());
        headline.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_ARRIVAL_DATE_INPUT)));
        arrivalDateInput.clear();
        arrivalDateInput.sendKeys(hotelTerms.getArrivalDate());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_DEPARTURE_DATE_INPUT)));
        departureDateInput.clear();
        departureDateInput.sendKeys(hotelTerms.getDepartureDate());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ROOMS_ADULTS_SELECT)));
        roomsAdultsSelect.sendKeys(hotelTerms.getRoomsAdultsNumber());
        searchButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_SEARCH_BUTTON)));
        searchButton.click();
    }
}
