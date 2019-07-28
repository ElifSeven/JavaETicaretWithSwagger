package elif.controller;


import elif.dto.OrderCreateDTO;
import elif.dto.OrderResponseDTO;
import elif.entity.Order;
import elif.repository.OrderRepository;
import elif.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/elif")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;


    @ApiOperation(value = "Add Order")
    @PostMapping("/order")
    public OrderResponseDTO addOrder(@RequestBody OrderCreateDTO orderCreateDTO) {

        return orderService.addOrder(orderCreateDTO);
    }

    @ApiOperation(value = "View all order")
    @GetMapping("/order")
    public List<Order> getAllOrder(Order order) {

        return orderService.getAllOrder(order);
    }

    @ApiOperation(value = "View order by id")
    @GetMapping(name = "/order/{orderId}")
    public Order findOrderById(Long orderId) throws ResourceNotFoundException {

        return orderService.findOrdeById(orderId);
    }

    @ApiOperation(value = "Delete order by id")
    @DeleteMapping(name = "/order/{orderId}")
    public Map<String, Boolean> deleteOrderById(Long orderId) throws ResourceNotFoundException {

        return orderService.deleteOrderById(orderId);
    }

}
