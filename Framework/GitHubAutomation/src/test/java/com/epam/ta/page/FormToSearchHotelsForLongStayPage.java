package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormToSearchHotelsForLongStayPage extends AbstractPage {

    private final String XPATH_FOR_SUBMIT_BUTTON = "//button[@class='Submit']";

    private WebElement submitButton;

    public FormToSearchHotelsForLongStayPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public FormToSearchHotelsForLongStayPage openPage(){
        return this;
    }

    public String thereIsSubmitButton(){
        submitButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_SUBMIT_BUTTON)));
        return submitButton.getText();
    }
}
