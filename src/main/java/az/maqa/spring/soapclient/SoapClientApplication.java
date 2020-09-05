package az.maqa.spring.soapclient;

import az.maqa.spring.soapclient.client.EmployeeClient;
import az.maqa.spring.soapclient.client.MovieClient;
import az.maqa.spring.soapclient.config.SoapClientConfig;
import az.maqa.spring.soapclient.util.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SoapClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SoapClientApplication.class, args);
        Scanner sc = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        Util util = new Util();
        MovieClient movieClient = context.getBean(MovieClient.class);
        EmployeeClient employeeClient = context.getBean(EmployeeClient.class);

        System.out.println("Soap Client: 1-Movie Client , 2- Employee Client");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("***Movie Client***");
                util.getMovieById(movieClient);
                break;

            case 2:
                System.out.println("***Employee Client***");
                util.getEmployeeById(employeeClient);
                break;

            default:
                System.out.println("Invalid Number");
        }

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SoapClientApplication.class);
    }

}
