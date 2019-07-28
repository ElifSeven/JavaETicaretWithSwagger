package elif.service;

import elif.dto.OrderCreateDTO;
import elif.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Order addOrder(OrderCreateDTO orderCreateDTO);

    List<Order> getAllOrder(Order order);

    Order findOrdeById(Long orderId);

    Map<String, Boolean> deleteOrderById(Long orderId);
}