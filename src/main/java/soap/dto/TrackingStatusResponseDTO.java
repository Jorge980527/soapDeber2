package soap.dto;

import java.time.LocalDateTime;

public class TrackingStatusResponseDTO {

    private String trackingNumber;
    private String status;
    private String location;
    private LocalDateTime timestamp;

    public TrackingStatusResponseDTO() {}

    public TrackingStatusResponseDTO(String trackingNumber, String status, String location, LocalDateTime timestamp) {
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.location = location;
        this.timestamp = timestamp;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

