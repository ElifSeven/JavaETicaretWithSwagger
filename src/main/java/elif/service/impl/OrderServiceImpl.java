package elif.service.impl;

import elif.dto.OrderCreateDTO;
import elif.dto.OrderResponseDTO;
import elif.dto.ProductResponseDTO;
import elif.entity.Order;
import elif.entity.Product;
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


    @Override
    public OrderResponseDTO addOrder(OrderCreateDTO orderCreateDTO) {

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        Order order = orderCreateDTOtoOrder(orderCreateDTO);
        order = orderRepository.save(order);

        return orderResponseDTOFromOrder(order);

    }

    double cost = 0;

    public Order orderCreateDTOtoOrder(OrderCreateDTO orderCreateDTO) {

        Order orderFromOrderCreateDTO = new Order();

        List<Product> productList = new ArrayList<>();


        orderCreateDTO.getProductList().stream().forEach(n -> {
            try {
                Product newItem = productService.findProductById(n);
                productList.add(newItem);
                cost += (orderCreateDTO.getProductQuantity())*(newItem.getPrice());
            } catch (elif.exception.ResourceNotFoundException e) {
                e.printStackTrace();
            }
        });

        orderFromOrderCreateDTO.setProductList(productList);
        orderFromOrderCreateDTO.setCost(String.valueOf(cost));
        orderFromOrderCreateDTO.setUser(userService.findUserByEmailAdresss(orderCreateDTO.getEmail()));

        return orderFromOrderCreateDTO;
    }


    public OrderResponseDTO orderResponseDTOFromOrder(Order order) {

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderCost(order.getCost());
        orderResponseDTO.setEmail(order.getUser().getEmailAddress());

        List<ProductResponseDTO> productResponseList = new ArrayList<>();

        order.getProductList().stream().forEach(n -> {
            try {
                productResponseList.add(productService.productResponseDTOFromProduct(productService.findProductById(n.getProductId())));
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
