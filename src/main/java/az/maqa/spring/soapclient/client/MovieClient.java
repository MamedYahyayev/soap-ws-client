package az.maqa.spring.soapclient.client;

import az.maqa.spring.soapclient.wsdl.GetMovieByIdRequest;
import az.maqa.spring.soapclient.wsdl.GetMovieByIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MovieClient extends WebServiceGatewaySupport {


    private static final Logger log = LoggerFactory.getLogger(MovieClient.class);

    public GetMovieByIdResponse getMovieById(Long id) {
        GetMovieByIdRequest request = new GetMovieByIdRequest();
        request.setMovieId(id);

        log.info("Requesting Movie By id= " + id);
        return (GetMovieByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);

    }

}
