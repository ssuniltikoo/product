package dev.sunil.backend.productservice.services;

import dev.sunil.backend.productservice.dtos.FakeStoreProductDto;
import dev.sunil.backend.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    private final static String BASE_URL = "https://fakestoreapi.com/products";

    public  FakeStoreProductService(RestTemplate restTemplate){
            this.restTemplate=restTemplate;
    }


    @Override
    public Product getSingleProduct(Long productId) {
       FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject(BASE_URL+"/"+productId, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getProducts() {
       FakeStoreProductDto[] response =  restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
       List<Product> listProduct = new ArrayList<>();
       for(FakeStoreProductDto p: response){
           listProduct.add(p.toProduct());
       }
       return  listProduct;
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        FakeStoreProductDto response  =restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDto,FakeStoreProductDto.class);
        if (response==null)
            return new Product();

        return response.toProduct();
    }

    @Override
    public Product updateProduct(Long id, String title, String description, String category, double price, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        restTemplate.put("https://fakestoreapi.com/products/"+id,fakeStoreProductDto,FakeStoreProductDto.class);
        fakeStoreProductDto.setId(id);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product deleteProduct(Long productId) {
         restTemplate.delete("https://fakestoreapi.com/products/"+productId);
        return getSingleProduct(productId);
    }


}
