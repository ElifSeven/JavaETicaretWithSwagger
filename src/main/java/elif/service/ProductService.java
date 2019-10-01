package elif.service;

import elif.dto.OrderProductQuantityResponseDTO;
import elif.dto.ProductCreateDTO;
import elif.dto.ProductResponseDTO;
import elif.entity.OrderProductQuantity;
import elif.entity.Product;
import elif.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductResponseDTO addProduct(ProductCreateDTO productCreateDTO);

    List<Product> getAllProduct();

    Product findProductById(Long productId) throws ResourceNotFoundException;

    Map<String, Boolean> deleteProductById(Long productId);
    
    ProductResponseDTO productResponseDTOFromProduct(Product product);

    OrderProductQuantityResponseDTO orderProductQuantityResponseDTOFromOrderProductQuantity(OrderProductQuantity orderProductQuantity);



}
