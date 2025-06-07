# API SOAP: Sistema de Seguimiento de Paquetes (EnviosExpress S.A.C)

## Descripción del Proyecto

Este proyecto implementa una API de servicios web SOAP para que la empresa "EnviosExpress S.A.C." permita a sus clientes consultar el estado actual y el historial de seguimiento de sus paquetes.

## Características Principales

* Consulte el estado y los detalles de un paquete mediante su número de tracking.
* Devuelve información completa: estado actual, ubicación, fecha estimada de entrega y el historial de todos los eventos del paquete.
* Manejo básico de errores para paquetes no encontrados.

## Tecnologías Utilizadas

* Java con Spring Boot
* Apache CXF (para servicios SOAP)
* PostgreSQL (Base de Datos)
* Spring Data JPA
* Maven

## Despliegue y Ejecución Local

1.  **Requisitos:**
    * JDK 17+.
    * Maven 3.6+.
    * PostgreSQL instalado y corriendo.
    * **Configuración DB:** Crear DB `trackingdb` con usuario `trackuser` y contraseña `p0ssw0rd` (o ajustar `src/main/resources/application.properties`).

2.  **Clonar el Repositorio:**
    ```bash
    git clone [https://github.com/Jorge080577/soapDeber2.git](https://github.com/Jorge080577/soapDeber2.git)
    cd soapDeber2
    ```

3.  **Ejecutar la Aplicación:**
    * Desde la línea de comandos:
        ```bash
        mvn clean install
        mvn spring-boot:run
        ```
    * Desde IntelliJ IDEA: Ejecutar la clase `SoapApplication.java`.

4.  **URLs del Servicio:**
    * **Endpoint:** `http://localhost:8082/services/tracking`
    * **WSDL:** `http://localhost:8082/services/tracking?wsdl`

##  Pruebas con SoapUI

1.  **Cargar WSDL:** Abre SoapUI, crea un nuevo proyecto SOAP y carga el WSDL desde `http://localhost:8082/services/tracking?wsdl`.
2.  **Solicitud de Consulta:**
    * Expanda `TrackingServiceSoapBinding` y `getTrackingStatus`.
    * Abre `Request 1` y modifica el `trackingNumber`. Use uno de los paquetes de prueba (ej., `PKG123456789`).

    ```xml
    <soapenv:Envelope xmlns:soapenv="[http://schemas.xmlsoap.org/soap/envelope/](http://schemas.xmlsoap.org/soap/envelope/)" xmlns:soap="http://soap/">
       <soapenv:Body>
          <soap:getTrackingStatus>
             <trackingNumber>PKG123456789</trackingNumber>
          </soap:getTrackingStatus>
       </soapenv:Body>
    </soapenv:Envelope>
    ```

3.  **Verificar Respuesta:**
    * Envíe la solicitud. La respuesta contendrá el estado, ubicación actual, fecha estimada de entrega y el historial de eventos del paquete.

    ```xml
    <soap:Envelope xmlns:soap="[http://schemas.xmlsoap.org/soap/envelope/](http://schemas.xmlsoap.org/soap/envelope/)">
       <soap:Body>
          <soap:getTrackingStatusResponse>
             <status>En Tránsito</status>
             <currentLocation>Ambato, Ecuador</currentLocation>
             <estimatedDeliveryDate>2025-06-10</estimatedDeliveryDate>
             <history>...</history> <history>...</history>
             </soap:getTrackingStatusResponse>
       </soap:Body>
    </soapenv:Envelope>
    ```
    * **Manejo de Paquete No Encontrado:** Si el `trackingNumber` no existe, el `status` será "Paquete no encontrado".

##  Enlace al Repositorio de GitHub

[https://github.com/Jorge080577/soapDeber2](https://github.com/Jorge080577/soapDeber2)

---

### **Información de los Estudiantes**

* **NRC:** [**23447**]
* **Nombre del Estudiante:** [**Jorge Arroyo - Cherley Caiza**]
