package pl.jandoniec.ecommerce.catalog.sales;


import org.springframework.web.bind.annotation.*;
import pl.jandoniec.ecommerce.catalog.sales.offering.Offer;
import pl.jandoniec.ecommerce.catalog.sales.reservation.AcceptOfferRequest;
import pl.jandoniec.ecommerce.catalog.sales.reservation.ReservationDetails;

@RestController
public class SalesController {

    SalesFacade sales;
    public SalesController(SalesFacade sales){
        this.sales = sales;
    }

    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        var customerId = getCurrentCustomerId();
        return sales.getCurrentOffer(customerId);
    }
    @PostMapping("/api/accept-offer")
    ReservationDetails acceptOffer(@RequestBody AcceptOfferRequest acceptOfferRequest){
        var customerId = getCurrentCustomerId();
        return sales.acceptOffer(customerId,acceptOfferRequest);
    }
    @PostMapping("/api/add-to-cart/{productId}")
    void addToCart(@PathVariable(name="productId") String productId){
        var customerId=getCurrentCustomerId();
        sales.addProduct(customerId,productId);
    }

    private String getCurrentCustomerId(){
        return "Juan Grande";
    }


}