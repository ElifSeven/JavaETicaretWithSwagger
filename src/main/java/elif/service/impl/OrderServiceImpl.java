package elif.service.impl;

import elif.dto.OrderCreateDTO;
import elif.dto.OrderProductResponseDTO;
import elif.dto.OrderResponseDTO;
import elif.entity.Order;
import elif.entity.OrderProductQuantity;
import elif.entity.Product;
import elif.repository.OrderProductQuantityRepository;
import elif.repository.OrderRepository;
import elif.service.OrderService;
import elif.service.ProductService;
import elif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderProductQuantityRepository orderProductQuantityRepository;


    @Override
    public OrderResponseDTO addOrder(OrderCreateDTO orderCreateDTO) {

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        Order order = orderCreateDTOtoOrder(orderCreateDTO);
        order = orderRepository.save(order);

        return orderResponseDTOFromOrder(order);

    }

    double cost = 0;

    public Order orderCreateDTOtoOrder(OrderCreateDTO orderCreateDTO) {

        cost = 0;

        Order orderFromOrderCreateDTO = new Order();

        orderFromOrderCreateDTO.setUser(userService.findUserByEmailAdresss(orderCreateDTO.getEmail()));

        orderFromOrderCreateDTO = orderRepository.save(orderFromOrderCreateDTO);


        Order finalOrderFromOrderCreateDTO = orderFromOrderCreateDTO;///hataya bak!
        orderCreateDTO.getProductWithQuantityList().entrySet().forEach(n -> {
            try {
                OrderProductQuantity orderProductQuantity = new OrderProductQuantity();
                orderProductQuantity.setOrderId(finalOrderFromOrderCreateDTO);
                Product productItem = productService.findProductById(n.getKey());
                orderProductQuantity.setProductId(productItem);
                orderProductQuantity.setProductQuantity(n.getValue());
                cost += (n.getValue()) * (productItem.getPrice());
                orderProductQuantityRepository.save(orderProductQuantity);

            } catch (elif.exception.ResourceNotFoundException e) {
                e.printStackTrace();
            }
        });

        finalOrderFromOrderCreateDTO.setCost(String.valueOf(cost));

        return orderRepository.save(finalOrderFromOrderCreateDTO);
    }


    public OrderResponseDTO orderResponseDTOFromOrder(Order order) {

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderCost(order.getCost());
        orderResponseDTO.setEmail(order.getUser().getEmailAddress());


        List<OrderProductResponseDTO> orderProductResponseList = new ArrayList<>();

        order.getOrderProductQuantityList().stream().forEach(n -> {
            try {

                OrderProductResponseDTO orderProductResponseDTO = productService.orderProductResponseDTOFromOrderProdcutQuantity(n);
                orderProductResponseList.add(orderProductResponseDTO);

            } catch (elif.exception.ResourceNotFoundException e) {
                e.printStackTrace();
            }
        });

        orderResponseDTO.setProductCreateDTOList(productResponseList);

        return orderResponseDTO;
    }


    @Override
    public List<Order> getAllOrder(Order order) {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(Long orderId) {

        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public Map<String, Boolean> deleteOrderById(Long orderId) {

        Order orderOptional = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException());
        orderRepository.deleteById(orderId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
