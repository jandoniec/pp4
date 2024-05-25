package pl.jandoniec.ecommerce.catalog.sales.cart;

public class CartLine {
    private  String productId;
    private Integer qty;

    public CartLine(String productId, Integer qty){
        this.productId=productId;
        this.qty=qty;

    }

    public String getProductId() {
        return productId;

    }

    public Integer getQty() {
        return qty;
    }
}