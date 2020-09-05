package az.maqa.spring.soapclient.util;

import az.maqa.spring.soapclient.client.EmployeeClient;
import az.maqa.spring.soapclient.client.MovieClient;
import az.maqa.spring.soapclient.wsdl.GetEmployeeByIdResponse;
import az.maqa.spring.soapclient.wsdl.GetMovieByIdResponse;

public class Util {

    public void getMovieById(MovieClient movieClient) {
        GetMovieByIdResponse response = movieClient.getMovieById(new Long(1));
        System.out.println("response: Movie id=" + response.getMovieType().getMovieId() + ", " +
                "title=" + response.getMovieType().getTitle() + ", category=" + response.getMovieType().getCategory());
    }


    public void getEmployeeById(EmployeeClient employeeClient) {
        GetEmployeeByIdResponse response = employeeClient.getEmployeeById(2L);
        System.out.println("response: Employee Id: " + response.getEmployeeType().getId() + ","
                + " name: " + response.getEmployeeType().getName()
                + ", surname:" + response.getEmployeeType().getSurname()
                + ", age: " + response.getEmployeeType().getAge()
                + ", experience: " + response.getEmployeeType().getExperience()
                + ", job: " + response.getEmployeeType().getJob());

    }
}
