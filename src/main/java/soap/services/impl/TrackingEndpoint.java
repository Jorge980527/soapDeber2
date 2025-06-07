package soap.services.impl;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soap.dto.TrackingStatusRequestDTO;
import soap.dto.TrackingStatusResponseDTO;
import soap.model.Package;
import soap.services.TrackingService;

@Component
@WebService(serviceName = "TrackingService", targetNamespace = "http://soap/")
public class TrackingEndpoint {

    @Autowired
    private TrackingService trackingService;

    @WebMethod
    public TrackingStatusResponseDTO getTrackingStatus(@WebParam(name = "request") TrackingStatusRequestDTO request) {
        // Aquí haces la lógica para buscar el paquete y mapear a ResponseDTO
        Package pkg = trackingService.findPackageByTrackingNumber(request.getTrackingNumber())
                .orElse(null);
        TrackingStatusResponseDTO response = new TrackingStatusResponseDTO();
        if (pkg != null) {
            // Mapear campos de Package a ResponseDTO (hazlo aquí o en un método aparte)
            response.setTrackingNumber(pkg.getTrackingNumber());
            response.setStatus(pkg.getCurrentStatus());
            // agrega más campos según necesites
        } else {
            response.setStatus("No encontrado");
        }
        return response;
    }

    // Otros métodos si es necesario
}

