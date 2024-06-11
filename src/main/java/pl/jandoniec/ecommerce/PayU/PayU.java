package pl.jandoniec.ecommerce.PayU;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;



public class PayU {
    PayUCredentials credentials;
    public PayU(RestTemplate http,PayUCredentials credentials) {
        this.http = http;
        this.credentials=credentials;

    }





    RestTemplate http;


    public OrderCreateResponse handle(OrderCreateRequest request) {
        var url=String.format("%s/api/v2_1/orders",credentials.getBaseUrl());
        var headers=new HttpHeaders();

        headers.add("Content-Type","application/json");
        headers.add("Authorization", String.format("Bearer %s",getToken()));



        HttpEntity<OrderCreateRequest> headerAwareRequest=new HttpEntity<>(request,headers);
        ResponseEntity<OrderCreateResponse> response=http.postForEntity(url,headerAwareRequest,OrderCreateResponse.class);
        return response.getBody();
    }

    private Object getToken() {
        String body=String.format(
                "grant_type=client_credentials&client_id=%s&client_secret=%s",
                credentials.getClientId(),
                credentials.getClientSecret()

        );
        var url=String.format("%s/pl/standard/user/oauth/authorize",credentials.getBaseUrl());
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> request =new HttpEntity<>(body,headers);
        ResponseEntity<AuthorizationResponse> response=http.postForEntity(url,request,AuthorizationResponse.class);
        return response.getBody().getAccessToken();


    }
}