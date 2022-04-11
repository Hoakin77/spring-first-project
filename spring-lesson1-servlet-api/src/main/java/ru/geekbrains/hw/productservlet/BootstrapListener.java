package ru.geekbrains.hw.productservlet;

import ru.geekbrains.hw.Product;
import ru.geekbrains.hw.ProductRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.insert(new Product("Apple"));
        productRepository.insert(new Product("Samsung"));
        productRepository.insert(new Product("Xiaomi"));
        productRepository.insert(new Product("Huawei"));
        productRepository.insert(new Product("Sony"));
        productRepository.insert(new Product("Nokia"));

        sce.getServletContext().setAttribute("productRepository", productRepository);
    }
}
