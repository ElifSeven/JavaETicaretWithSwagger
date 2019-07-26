package elif.service.impl;

import elif.dto.OrderCreateDTO;
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
    public Order addOrder(OrderCreateDTO orderCreateDTO) {

        User user = userService.findUserById(orderCreateDTO.getUserId());
        Order order = new Order();

        List<Product> productList = new ArrayList<>();

        orderCreateDTO.getProductIdList().stream().forEach(n -> {
            try {
                productList.add(productService.findProductById(n));
            } catch (elif.exception.ResourceNotFoundException e) {
                e.printStackTrace();
            }
        });


        order.setUser(user);
        order.setCost(orderCreateDTO.getOrderCost());
        order.setProductList(productList);


        return orderRepository.save(order);
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
