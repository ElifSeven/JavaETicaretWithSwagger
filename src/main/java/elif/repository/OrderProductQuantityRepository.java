package elif.repository;

import elif.entity.OrderProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductQuantityRepository extends JpaRepository<OrderProductQuantity, Long> {
}
