package ru.geekbrains.prisist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.prisist.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findOrdersByUserId(Long userId);

    @Query(value = "SELECT o FROM Order o WHERE o.id = :orderId")
    Order findOrderByOrderId (Long orderId);
}
