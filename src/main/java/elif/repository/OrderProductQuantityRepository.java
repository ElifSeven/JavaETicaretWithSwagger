package elif.repository;

import elif.entity.Order;
import elif.entity.OrderProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductQuantityRepository extends JpaRepository<OrderProductQuantity, Long> {

    public List<OrderProductQuantity> findByOrderId(Order order);
}
