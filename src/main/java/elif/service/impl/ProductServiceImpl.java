package elif.service.impl;

import elif.dto.ProductCreateDTO;
import elif.dto.ProductResponseDTO;
import elif.entity.Product;
import elif.repository.ProductRepository;
import elif.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDTO addProduct(ProductCreateDTO productCreateDTO) {

        Product product = productCreateDTOtoProduct(productCreateDTO);
        product = productRepository.save(product);
        return productResponseDTOFromProduct(product);

    }

    public Product productCreateDTOtoProduct(ProductCreateDTO productCreateDTO) {

        Product productFromProductCreateDTO = new Product();
        productFromProductCreateDTO.setProductName(productCreateDTO.getProductName());
        productFromProductCreateDTO.setBrand(productCreateDTO.getProductBrand());
        productFromProductCreateDTO.setPrice(productCreateDTO.getProductPrice());
        productFromProductCreateDTO.setProductQuantity(productCreateDTO.getProductQuantity());

        return productFromProductCreateDTO;

    }

    public ProductResponseDTO productResponseDTOFromProduct(Product product) {

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setProductBrand(product.getBrand());
        productResponseDTO.setProductPrice(product.getPrice());

        return productResponseDTO;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long productId) {

        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException());

    }

    @Override
    public Map<String, Boolean> deleteProductById(Long productId) {

        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        productRepository.deleteById(productId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;

    }
}
