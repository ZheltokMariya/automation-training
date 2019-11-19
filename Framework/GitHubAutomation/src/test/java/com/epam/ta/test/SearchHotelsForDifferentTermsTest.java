package com.epam.ta.test;

import com.epam.ta.model.SearchQueryMain;
import com.epam.ta.page.HotelsHomePage;
import com.epam.ta.service.SearchQueryMainCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class SearchHotelsForDifferentTermsTest extends CommonConditions {

    @Test
    public void searchHotelWhenDepartureDateBeforeArrivalDate()
    {
        SearchQueryMain testSearchQueryMain = SearchQueryMainCreator.withDepartureDateBeforeArrivalDate();
        String resultArrivalDate = new HotelsHomePage(driver)
                .openPage()
                .searchHotelForMainTerms(testSearchQueryMain)
                .changedDepartureDateTerm();
        assertThat(resultArrivalDate, is(equalTo("18/01/2020")));
    }

    @Test
    public void searchHotelForLongStay()
    {
        SearchQueryMain testSearchQueryMain = SearchQueryMainCreator.forLongStay();
        String textOfButtonToSubmitFormForLongStay = new HotelsHomePage(driver)
                .openPage()
                .searchHotelForLongStay(testSearchQueryMain)
                .obtainFormToSearchHotelForLongStay()
                .thereIsSubmitButton();
        assertThat(textOfButtonToSubmitFormForLongStay, is(equalTo("Отправить")));
    }
}
