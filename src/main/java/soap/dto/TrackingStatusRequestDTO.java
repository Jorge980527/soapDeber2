package soap.dto;

public class TrackingStatusRequestDTO {

    private String trackingNumber;

    public TrackingStatusRequestDTO() {}

    public TrackingStatusRequestDTO(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}

