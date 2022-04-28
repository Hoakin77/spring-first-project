package ru.geekbrains.persistence.repositories;



import ru.geekbrains.persistence.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    List<Product> findAllSortedByName();

    Product findById(Long id);

    void deleteById(Long id);

    void saveOrUpdate(Product product);
}
