package elif.controller;


import elif.dto.ProductDTO;
import elif.entity.Product;
import elif.exception.ResourceNotFoundException;
import elif.repository.ProductRepository;
import elif.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/elif")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;


    @ApiOperation(value = "Add new product")
    @PostMapping("/product")
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    @ApiOperation(value = "View all products")
    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @ApiOperation(value = "View product by id")
    @GetMapping("/product/{id}")
    public ProductDTO findProductById(Long productId) throws ResourceNotFoundException {
        ProductDTO productDTO = modelMapper.map(productService.findProductById(productId), ProductDTO.class);
        return productDTO;
    }

    @ApiOperation(value = "Delete product by id")
    @DeleteMapping("/product/{id}")
    public Map<String, Boolean> deleteProductById(Long productId) throws ResourceNotFoundException {
        return productService.deleteProductById(productId);
    }
}
