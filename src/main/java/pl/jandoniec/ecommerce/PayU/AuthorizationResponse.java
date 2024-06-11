package pl.jandoniec.ecommerce.PayU;

public class AuthorizationResponse {
    String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public AuthorizationResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }
    public String getAccessToken(){
        return access_token;
    }
}