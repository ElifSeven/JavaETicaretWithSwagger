package elif.dto;

import java.util.List;

public class OrderResponseDTO {

    private List<ProductResponseDTO> productResponseDTOList;
    private String orderCost;
    private String email;


    public List<ProductResponseDTO> getProductCreateDTOList() {
        return productResponseDTOList;
    }

    public void setProductCreateDTOList(List<ProductResponseDTO> productCreateDTOList) {
        this.productResponseDTOList = productCreateDTOList;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
