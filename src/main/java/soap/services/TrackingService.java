package soap.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import soap.model.Package;
import java.util.Optional;

@WebService(targetNamespace = "http://soap/")
public interface TrackingService {

    @WebMethod
    Optional<Package> findPackageByTrackingNumber(@WebParam(name = "trackingNumber") String trackingNumber);

    @WebMethod
    Package savePackage(@WebParam(name = "pkg") Package pkg);

    @WebMethod
    void deletePackage(@WebParam(name = "trackingNumber") String trackingNumber);
}


