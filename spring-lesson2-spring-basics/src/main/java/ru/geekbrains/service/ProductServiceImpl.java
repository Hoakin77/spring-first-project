package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.presist.Product;
import ru.geekbrains.presist.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService{


    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Product product) {
        productRepository.saveOrUpdate(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
