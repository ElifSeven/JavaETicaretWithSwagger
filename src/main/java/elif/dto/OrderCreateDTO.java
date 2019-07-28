package elif.dto;

import java.util.List;

public class OrderCreateDTO {

    private String orderCost;
    private Long userId;
    private List<ProductCreateDTO> productIdList;

    public String getOrderCost() {
        return orderCost;
    }


    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProductCreateDTO> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<ProductCreateDTO> productIdList) {
        this.productIdList = productIdList;
    }
}
