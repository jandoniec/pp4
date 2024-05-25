package pl.jandoniec.ecommerce.catalog.sales.ui;

import pl.jandoniec.ecommerce.catalog.sales.cart.Cart;
import pl.jandoniec.ecommerce.catalog.sales.cart.inMemoryCartStorage;
import pl.jandoniec.ecommerce.catalog.sales.offering.Offer;
import pl.jandoniec.ecommerce.catalog.sales.offering.OfferCalculator;
import pl.jandoniec.ecommerce.catalog.sales.order.ReservationDetails;

public class SalesFacade {
    private inMemoryCartStorage cartStorage;
    private OfferCalculator offerCalculator;

    public SalesFacade(inMemoryCartStorage cartStorage,OfferCalculator offerCalculator){
        this.cartStorage=cartStorage;
        this.offerCalculator=offerCalculator;
    }



    public ReservationDetails acceptOffer(String customerId) {
        return new ReservationDetails();
    }

    public void addToCart(String customerId, String productId) {
        Cart cart=loadCartForCustomer(customerId);
        cart.addProduct(productId);

    }
    public Offer getCurrentOffer(String customerId){
        Cart cart=loadCartForCustomer(customerId);
        return OfferCalculator.calculate(cart.getLines());
    }
    private Cart loadCartForCustomer(String customerId){

        return cartStorage.findByCustomerId(customerId)
                .orElse(Cart.empty());
    }
}