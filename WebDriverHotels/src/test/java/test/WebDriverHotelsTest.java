package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HotelsHomePage;
import page.SearchQueryMain;

public class WebDriverHotelsTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void openPageForLongStay(){
        SearchQueryMain hotelTerms = new SearchQueryMain("Rome, Italy", "06/11/2019", "18/03/2021", "1 номер, 1 взрослый");
       String addressOfExpectedPageForLongStay = new HotelsHomePage(driver)
                .openPage()
                .searchHotelForLongStay(hotelTerms)
                .chooseHotelForLongStay();
       Assert.assertTrue(addressOfExpectedPageForLongStay.contains("https://ru.groups.hotels.com"));
    }

    @Test
    public void searchHotelWhenDepartureDateBeforeArrivalDate(){
        SearchQueryMain hotelTerms = new SearchQueryMain("Rome, Italy", "08/11/2019", "07/11/2019", "1 номер, 1 взрослый");
        String resultArrivalDate =  new HotelsHomePage(driver)
                .openPage()
                .searchHotelForMainTerms(hotelTerms)
                .changedArrivalDateTerm();
        Assert.assertEquals(resultArrivalDate, "06/11/2019");
    }

}
