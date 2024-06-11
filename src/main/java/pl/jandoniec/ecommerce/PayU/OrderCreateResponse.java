package pl.jandoniec.ecommerce.PayU;

public class OrderCreateResponse {
    String redirectUri;
    String orderId;

    public OrderCreateResponse setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }

    public OrderCreateResponse setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public OrderCreateResponse setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    String extOrderId;


    public Object getRedirectUri() {
        return redirectUri;
    }

    public Object getOrderId() {
        return orderId;
    }

    public Object getExtOrderId() {
        return extOrderId;
    }
}