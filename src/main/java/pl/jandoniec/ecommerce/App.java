package pl.jandoniec.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jandoniec.ecommerce.catalog.HasMapProductStorage;
import pl.jandoniec.ecommerce.catalog.ProductCatalog;
import pl.jandoniec.ecommerce.catalog.sales.ui.SalesFacade;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("here we go!!!!");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {


        var catalog = new ProductCatalog(new HasMapProductStorage());
        catalog.addProduct("Lego set 8083", "Nice one");
        catalog.addProduct("Cobi blocks", "Nice one");
        return catalog;
    }
    @Bean
    SalesFacade createSales(){
        return new SalesFacade();
    }
}