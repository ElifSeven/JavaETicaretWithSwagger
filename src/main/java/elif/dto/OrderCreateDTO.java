package elif.dto;

import java.util.List;

public class OrderCreateDTO {

    private String email;
    private List<ProductCreateDTO> productList;
    private Long productId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProductCreateDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductCreateDTO> productList) {
        this.productList = productList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
