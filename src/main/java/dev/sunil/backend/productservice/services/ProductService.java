package dev.sunil.backend.productservice.services;

import dev.sunil.backend.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);

    List<Product> getProducts();

    Product createProduct(String title,String description,String category,double price,String image);


    Product updateProduct(Long id, String title,String description,String category,double price,String image);

    Product deleteProduct(Long productId);
}
