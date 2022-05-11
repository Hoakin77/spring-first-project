package ru.geekbrains.prisist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.prisist.model.Order;



public interface  CartEntryRepository  extends JpaRepository<Order, Long> {
      // List<CartEntry> findAllByOrderIdAndOrderByProductNameDesc(Long userId, Long orderId);
}
