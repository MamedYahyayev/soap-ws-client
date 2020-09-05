package az.maqa.spring.soapclient;

import az.maqa.spring.soapclient.client.MovieClient;
import az.maqa.spring.soapclient.config.SoapClientConfig;
import az.maqa.spring.soapclient.wsdl.GetMovieByIdResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SoapClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SoapClientApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        MovieClient client = context.getBean(MovieClient.class);
        GetMovieByIdResponse response = client.getMovieById(new Long(1));
        System.out.println("response: Movie id=" + response.getMovieType().getMovieId() + ", title=" + response.getMovieType().getTitle() + ", category=" + response.getMovieType().getCategory());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SoapClientApplication.class);
    }

}
