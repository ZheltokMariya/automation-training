package page;

public class SearchQueryMain {
    private String place;
    private String arrivalDate;
    private String departureDate;
    private String roomsAdultsNumber;

    public SearchQueryMain(String place, String arrivalDate, String departureDate, String roomsAdultsNumber) {
        this.place = place;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomsAdultsNumber = roomsAdultsNumber;
    }

    public String getPlace() {
        return place;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getRoomsAdultsNumber() {
        return roomsAdultsNumber;
    }
}
