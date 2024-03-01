package dev.sunil.backend.productservice.dtos;

import dev.sunil.backend.productservice.models.Category;
import dev.sunil.backend.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category category1 = new Category();
        category1.setTitle(category);
        product.setCategory(category1);
        return product;
    }

}
