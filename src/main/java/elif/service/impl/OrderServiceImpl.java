package elif.service.impl;

import elif.dto.OrderCreateDTO;
import elif.dto.OrderResponseDTO;
import elif.entity.Order;
import elif.entity.Product;
import elif.entity.User;
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
        User user = userService.findUserById(orderCreateDTO.getUserId());

        Order order = orderCreateDTOtoOrder(orderCreateDTO);
        order = orderRepository.save(order);

        List<Product> productList = new ArrayList<>();

        // orderCreateDTO.getProductIdList().stream().forEach(n->productList.add(productService.findProductById());


       /* orderCreateDTO.getProductIdList().stream().forEach(n -> {
            try {
                productList.add(productService.findProductById(n));
            } catch (elif.exception.ResourceNotFoundException e) {
                e.printStackTrace();
            }
        });*/

       /* UserResponseDTO userResponseDTO = new UserResponseDTO();
        user.setEmailAddress(userResponseDTO.getEmail());
        //orderResponseDTO.setUser(user);
        orderResponseDTO.setOrderCost(orderCreateDTO.getOrderCost());
        orderResponseDTO.setProductCreateDTOList(orderCreateDTO.getProductIdList());
        return orderRepository.save(order);*/

        return orderResponseDTOFromOrder(order);
    }

    public Order orderCreateDTOtoOrder(OrderCreateDTO orderCreateDTO) {

        Order orderFromOrderCreateDTO = new Order();
        orderFromOrderCreateDTO.setCost(orderCreateDTO.getOrderCost());
        orderFromOrderCreateDTO.setProductList(orderCreateDTO.getProductIdList());
        orderFromOrderCreateDTO.setUser(userService.findUserById(orderCreateDTO.getUserId()));

        return orderFromOrderCreateDTO;
    }


    public OrderResponseDTO orderResponseDTOFromOrder(Order order) {

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderCost(order.getCost());
        orderResponseDTO.setEmail(order.getUser().getEmailAddress());
        orderResponseDTO.setProductCreateDTOList(order.getProductList());

        return orderResponseDTO;
    }


    @Override
    public List<Order> getAllOrder(Order order) {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrdeById(Long orderId) {

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
