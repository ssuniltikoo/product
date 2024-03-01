package dev.sunil.backend.productservice.dtos;

import dev.sunil.backend.productservice.models.Category;
import dev.sunil.backend.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProduct {
        private Long id;
        private String title;
        private String description;
        private double price;
        private String image;
        private String category;
}
