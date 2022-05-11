package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.prisist.model.Product;
import ru.geekbrains.prisist.repository.ProductRepository;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
//        return ProductRepository.getInstance().findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
//        return ProductRepository.getInstance().findById(id);
    }

    @Override
    public void saveOrUpdate(Product product) {
        productRepository.save(product);
//        ProductRepository.getInstance().saveOrUpdate(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
//        ProductRepository.getInstance().deleteById(id);
    }

}