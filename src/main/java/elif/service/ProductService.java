package elif.service;

import elif.dto.ProductCreateDTO;
import elif.dto.ProductResponseDTO;
import elif.entity.Product;
import elif.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductResponseDTO addProduct(ProductCreateDTO productCreateDTO);

    List<Product> getAllProduct();

    ProductCreateDTO findProductById(Long productId) throws ResourceNotFoundException;

    Map<String, Boolean> deleteProductById(Long productId);


}
