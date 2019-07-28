package elif.dto;

import java.util.List;

public class OrderResponseDTO {


    private List<ProductCreateDTO> productCreateDTOList;
    private String orderCost;
    private String email;

    public List<ProductCreateDTO> getProductCreateDTOList() {
        return productCreateDTOList;
    }

    public void setProductCreateDTOList(List<ProductCreateDTO> productCreateDTOList) {
        this.productCreateDTOList = productCreateDTOList;
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
