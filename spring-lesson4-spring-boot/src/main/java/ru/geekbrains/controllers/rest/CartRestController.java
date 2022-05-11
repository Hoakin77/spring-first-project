package ru.geekbrains.controllers.rest;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.prisist.Cart;
import ru.geekbrains.prisist.model.Product;
import ru.geekbrains.service.CartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartRestController {
    private CartService cartService;
    private Cart cart;

    @GetMapping
    public ResponseEntity<?> cartList (Page page) {
        List<Product> cartProductsList = cartService.getCartListSorted(cart);
        if (page.getContent().size() > 0) {
            return ResponseEntity.ok(page.getContent());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/add/{productId}")
    public void addToCart (
            @PathVariable(name = "productId") Long id,
            @RequestParam(required = false, name = "quantity") Integer quantity,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
            cartService.addProductById(cart, id, quantity);
            response.sendRedirect(request.getHeader("referer"));
    }

    @GetMapping("/del/{product_id}")
    public void delFromToCart (
            @PathVariable(name = "product_id") Product product,
            @RequestParam(required = false, name = "q") Integer quantity,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
            cartService.addProduct(cart, product, quantity);
            response.sendRedirect(request.getHeader("referer"));
    }
}
