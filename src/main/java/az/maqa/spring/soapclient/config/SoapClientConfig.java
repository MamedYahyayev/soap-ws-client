package az.maqa.spring.soapclient.config;

import az.maqa.spring.soapclient.client.MovieClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("az.maqa.spring.soapclient.wsdl");
        return marshaller;
    }

    @Bean
    public MovieClient movieClient(Jaxb2Marshaller marshaller) {
        MovieClient client = new MovieClient();
        client.setDefaultUri("http://localhost:8088/ws/soap-ws.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
