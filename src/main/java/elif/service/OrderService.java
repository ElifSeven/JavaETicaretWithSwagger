package elif.service;

import elif.dto.OrderCreateDTO;
import elif.dto.OrderQueryDTO;
import elif.dto.OrderResponseDTO;

import java.util.List;
import java.util.Map;

public interface OrderService {

    OrderResponseDTO addOrder(OrderCreateDTO orderCreateDTO);

    List<OrderResponseDTO> findOrdersByQueryDTO(OrderQueryDTO orderQueryDTO);

    OrderResponseDTO findOrderById(Long orderId);

    Map<String, Boolean> deleteOrderById(Long orderId);
}
