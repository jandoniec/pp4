package pl.jandoniec.ecommerce.catalog.sales.cart;


public class CartItem {
    private  String productId;
    private Integer qty;

    public CartItem(String productId, Integer qty){
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