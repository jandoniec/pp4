package pl.jandoniec.ecommerce.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListProductStorage implements ProductStorage {

    private ArrayList<Product> products;

    public ArrayListProductStorage() {
        products = new ArrayList<>();
    }
    @Override
    public List<Product> allProducts(){
        return Collections
                .unmodifiableList(products);
    }


    @Override
    public void add(Product newProduct) {
        products.add(newProduct);
    }

@Override
public Product getProductBy(String id) {
    return products.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .get();
}
    }