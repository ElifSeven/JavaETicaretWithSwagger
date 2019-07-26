package elif.service;

import elif.entity.Product;
import elif.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProduct();

    Product findProductById(Long productId) throws ResourceNotFoundException;


    Map<String, Boolean> deleteProductById(Long productId);


}
