package soap.config;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soap.services.impl.TrackingEndpoint;

@Configuration
public class CxfConfig {

    private final Bus bus;
    private final TrackingEndpoint trackingSoapEndpoint;

    public CxfConfig(Bus bus, TrackingEndpoint trackingSoapEndpoint) {
        this.bus = bus;
        this.trackingSoapEndpoint = trackingSoapEndpoint;
    }

    @Bean(name = "cxfTrackingEndpoint")
    public Endpoint cxfTrackingEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, trackingSoapEndpoint);
        endpoint.publish("/tracking");
        return endpoint;
    }
}


