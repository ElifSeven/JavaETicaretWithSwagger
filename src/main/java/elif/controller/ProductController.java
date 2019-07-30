package elif.controller;


import elif.dto.ProductCreateDTO;
import elif.dto.ProductResponseDTO;
import elif.entity.Product;
import elif.exception.ResourceNotFoundException;
import elif.repository.ProductRepository;
import elif.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "Add new product")
    @PostMapping("/add")
    public ProductResponseDTO addProduct(ProductCreateDTO productCreateDTO) {
        return productService.addProduct(productCreateDTO);
    }

    @ApiOperation(value = "View all products")
    @GetMapping("/view")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @ApiOperation(value = "View product by id")
    @GetMapping("/view/{id}")
    public Product findProductById(Long productId) throws ResourceNotFoundException {

        return productService.findProductById(productId);
    }

    @ApiOperation(value = "Delete product by id")
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteProductById(Long productId) throws ResourceNotFoundException {
        return productService.deleteProductById(productId);
    }
}
