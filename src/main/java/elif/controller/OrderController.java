package elif.controller;

import elif.dto.OrderCreateDTO;
import elif.dto.OrderQueryDTO;
import elif.dto.OrderResponseDTO;
import elif.repository.OrderRepository;
import elif.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;


    @ApiOperation(value = "Add Order")
    @PostMapping("/add")
    public OrderResponseDTO addOrder(@RequestBody OrderCreateDTO orderCreateDTO) {

        return orderService.addOrder(orderCreateDTO);
    }

    @ApiOperation(value = "View all order")
    @GetMapping("/view")
    public List<OrderResponseDTO> getAllOrder(OrderQueryDTO orderQueryDTO) {

        return orderService.findOrdersByQueryDTO(orderQueryDTO);
    }

    @ApiOperation(value = "View order by id")
    @GetMapping(name = "/view/{orderId}")
    public OrderResponseDTO findOrderById(@PathVariable Long orderId) throws ResourceNotFoundException {

        return orderService.findOrderById(orderId);
    }

    @ApiOperation(value = "Delete order by id")
    @DeleteMapping(name = "/delete/")
    public Map<String, Boolean> deleteOrderById(@RequestParam("orderId") Long orderId) throws ResourceNotFoundException {

        return orderService.deleteOrderById(orderId);
    }

    @ApiOperation(value = "Cancel the order")
    @PutMapping(path = "/cancel/{orderId}")
    public Boolean cancelOrder(@PathVariable(value = "orderId") Long orderId) {
        return orderService.changeStatusOfOrder(orderId, false);
    }

    @ApiOperation(value = "Confirm the order")
    @PutMapping(path = "/confirm/{orderId}")
    public Boolean confirmOrder(@PathVariable(value = "orderId") Long orderId) {
        return orderService.isOrderConfirmable(orderId);
    }

}
