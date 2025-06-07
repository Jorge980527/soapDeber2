package soap.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    private String trackingNumber;

    private String sender;
    private String recipient;
    private String currentStatus;

    @OneToMany(mappedBy = "pkg", cascade = CascadeType.ALL)
    private List<TrackingEvent> events;

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<TrackingEvent> getEvents() {
        return events;
    }

    public void setEvents(List<TrackingEvent> events) {
        this.events = events;
    }
}


