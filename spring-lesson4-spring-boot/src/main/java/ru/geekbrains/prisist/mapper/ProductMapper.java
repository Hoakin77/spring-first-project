package ru.geekbrains.prisist.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.geekbrains.prisist.model.Product;
import ru.geekbrains.prisist.objectDtos.ProductDto;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);
    ProductDto fromProduct(Product product);

    List<Product> toProductList(List<ProductDto> productDto);
    List<ProductDto> fromProductList(List<Product> products);
}
