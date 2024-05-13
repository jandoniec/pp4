package pl.jandoniec.ecommerce.catalog;

import java.util.HashMap;
import java.util.List;

public class HasMapProductStorage implements ProductStorage {
    HashMap<String,Product> products;
    public HasMapProductStorage(){
        products=new HashMap<>();
    }

    @Override
    public List<Product> allProducts() {
        return products.values().stream().toList();
    }

    @Override
    public void add(Product product) {
        products.put(product.getId(),product);

    }

    @Override
    public Product getProductBy(String id) {
        return products.get(id);
    }
}