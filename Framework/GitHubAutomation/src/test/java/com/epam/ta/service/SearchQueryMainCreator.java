package com.epam.ta.service;

import com.epam.ta.model.SearchQueryMain;

public class SearchQueryMainCreator {

    public static final String TESTDATA_SEARCH_QUERY_MAIN_PLACE = "testdata.searchQueryMain.place";
    public static final String TESTDATA_SEARCH_QUERY_MAIN_ROOMS_NUMBER = "testdata.searchQueryMain.roomsNumber";
    public static final String TESTDATA_SEARCH_QUERY_MAIN_ARRIVAL_DATE = "testdata.searchQueryMain.arrivalDate";
    public static final String TESTDATA_SEARCH_QUERY_MAIN_DEPARTURE_DATE = "testdata.searchQueryMain.departureDate";
    public static final String TESTDATA_SEARCH_QUERY_MAIN_DEPARTURE_DATE_BEFORE_ARRIVAL_DATE = "testdata.searchQueryMain.departureDateBeforeArrivalDate";
    public static final String TESTDATA_SEARCH_QUERY_MAIN_DEPARTURE_DATE_FOR_LONG_STAY = "testdata.searchQueryMain.departureDateForLongStay";

    public static SearchQueryMain withCredentialsFromProperty(){
        return new SearchQueryMain(TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_DEPARTURE_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_ROOMS_NUMBER)));
    }

    public static SearchQueryMain withDepartureDateBeforeArrivalDate(){
        return new SearchQueryMain(TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_DEPARTURE_DATE_BEFORE_ARRIVAL_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_ROOMS_NUMBER)));
    }

    public static SearchQueryMain forLongStay(){
        return new SearchQueryMain(TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_DEPARTURE_DATE_FOR_LONG_STAY),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCH_QUERY_MAIN_ROOMS_NUMBER)));
    }
}
