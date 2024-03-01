package dev.sunil.backend.productservice.controllers;

import dev.sunil.backend.productservice.dtos.FakeStoreProduct;
import dev.sunil.backend.productservice.models.Product;
import dev.sunil.backend.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);

    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody FakeStoreProduct request){
       return productService.createProduct(request.getTitle(),request.getDescription(),
                request.getCategory(),request.getPrice(),request.getImage());

    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody FakeStoreProduct request){
        return productService.updateProduct(request.getId(),request.getTitle(),
                request.getDescription(),request.getCategory(),request.getPrice(),request.getImage());

    }
    @DeleteMapping("/products/{id}")
    public Product deleteProductId(@PathVariable("id") Long productId){
       return productService.deleteProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }
}
