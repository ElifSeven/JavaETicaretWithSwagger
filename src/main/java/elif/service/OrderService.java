package elif.service;

import elif.dto.OrderCreateDTO;
import elif.dto.OrderResponseDTO;
import elif.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    OrderResponseDTO addOrder(OrderCreateDTO orderCreateDTO);

    List<Order> getAllOrder(Order order);

    Order findOrderById(Long orderId);

    Map<String, Boolean> deleteOrderById(Long orderId);
}
