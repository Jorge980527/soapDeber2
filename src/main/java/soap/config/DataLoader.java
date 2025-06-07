package soap.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import soap.model.Package;
import soap.model.TrackingEvent;
import soap.repository.PackageRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader {

    private final PackageRepository packageRepository;

    public DataLoader(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @PostConstruct
    public void loadData() {
        Package pkg = new Package();
        pkg.setTrackingNumber("123456");
        pkg.setSender("Luis");
        pkg.setRecipient("Andrea");
        pkg.setCurrentStatus("En tránsito");

        TrackingEvent event1 = new TrackingEvent();
        event1.setLocation("Quito");
        event1.setStatus("Recibido");
        event1.setTimestamp(LocalDateTime.now().minusDays(1));
        event1.setPkg(pkg);

        TrackingEvent event2 = new TrackingEvent();
        event2.setLocation("Ambato");
        event2.setStatus("En camino");
        event2.setTimestamp(LocalDateTime.now());
        event2.setPkg(pkg);

        pkg.setEvents(List.of(event1, event2));
        packageRepository.save(pkg);
    }
}
