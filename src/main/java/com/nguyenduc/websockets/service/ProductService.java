package com.nguyenduc.websockets.service;

import com.nguyenduc.websockets.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static List<Product> products = new ArrayList<>();

    private static Long countP = 1L;

    public Iterable<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Long id) {
        int index = -1;
        for (Product p: products) {
            if (p.getId().equals(id)) {
                index = products.indexOf(p);
            }
        }
        if (index == -1) {
            throw new RuntimeException("Not found");
        }
       return Optional.ofNullable(products.get(index));
    }

    public Product save(Product product) {
        product.setId(countP);
        products.add(product);
        countP++;
        return product;
    }

    public void remove(Long id) {
        int index = -1;
        for (Product p: products) {
            if (p.getId().equals(id)) {
                index = products.indexOf(p);
            }
        }
        if (index == -1) {
            throw new RuntimeException("Not found");
        }
        products.remove(index);
    }
}
