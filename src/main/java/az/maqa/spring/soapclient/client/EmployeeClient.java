package az.maqa.spring.soapclient.client;

import az.maqa.spring.soapclient.wsdl.GetEmployeeByIdRequest;
import az.maqa.spring.soapclient.wsdl.GetEmployeeByIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class EmployeeClient extends WebServiceGatewaySupport {


    private static final Logger log = LoggerFactory.getLogger(EmployeeClient.class);

    public GetEmployeeByIdResponse getEmployeeById(Long id) {
        GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
        request.setId(id);

        log.info("Requesting Movie By id= " + id);
        return (GetEmployeeByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

}
