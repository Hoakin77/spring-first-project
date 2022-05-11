package ru.geekbrains.prisist.objectDtos;

import lombok.Data;
import ru.geekbrains.prisist.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class CartDto {
    private Map<Product, Integer> cartMap = new HashMap<>();
    private BigDecimal totalSum;
}
