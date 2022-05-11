package ru.geekbrains.prisist.mapper;

import org.springframework.stereotype.Component;
import ru.geekbrains.prisist.model.Product;
import ru.geekbrains.prisist.objectDtos.ProductDto;

@Component
public class ProductConverter {
    public ProductDto fromProduct(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public Product toProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
