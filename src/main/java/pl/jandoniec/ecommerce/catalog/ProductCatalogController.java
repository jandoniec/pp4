package pl.jandoniec.ecommerce.catalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ProductCatalogController{

    ProductCatalog catalog;
    public ProductCatalogController(ProductCatalog catalog){
        this.catalog=catalog;
    }
    @GetMapping("/api/products")
    List<Product> getAllProducts(){
        return new ArrayList<>();
    }
    @GetMapping("/api/published-products")
    List<Product> getPublishedProducts(){
        return  new ArrayList<>();
    }

}
