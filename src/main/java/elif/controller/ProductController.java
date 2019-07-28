package elif.controller;


import elif.dto.ProductCreateDTO;
import elif.dto.ProductResponseDTO;
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
    public ProductResponseDTO addProduct(ProductCreateDTO productCreateDTO) {
        return productService.addProduct(productCreateDTO);
    }

    @ApiOperation(value = "View all products")
    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @ApiOperation(value = "View product by id")
    @GetMapping("/product/{id}")
    public ProductCreateDTO findProductById(Long productId) throws ResourceNotFoundException {
        ProductCreateDTO productCreateDTO = modelMapper.map(productService.findProductById(productId), ProductCreateDTO.class);
        return productCreateDTO;
    }

    @ApiOperation(value = "Delete product by id")
    @DeleteMapping("/product/{id}")
    public Map<String, Boolean> deleteProductById(Long productId) throws ResourceNotFoundException {
        return productService.deleteProductById(productId);
    }
}
