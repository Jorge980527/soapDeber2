package soap.services.impl;

import jakarta.jws.WebService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soap.model.Package;
import soap.repository.PackageRepository;
import soap.services.TrackingService;
import java.util.Optional;

@Service
@Transactional
@WebService(
        endpointInterface = "soap.services.TrackingService",
        targetNamespace = "http://soap/"
)
public class TrackingServiceImpl implements TrackingService {

    private final PackageRepository packageRepository;

    public TrackingServiceImpl(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public Optional<Package> findPackageByTrackingNumber(String trackingNumber) {
        return packageRepository.findById(trackingNumber);
    }

    @Override
    public Package savePackage(Package pkg) {
        return packageRepository.save(pkg);
    }

    @Override
    public void deletePackage(String trackingNumber) {
        packageRepository.deleteById(trackingNumber);
    }
}




