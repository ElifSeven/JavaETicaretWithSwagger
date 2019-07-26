package elif.dto;

import java.util.List;

public class OrderCreateDTO {

    private String orderCost;
    private Long userId;
    private List<Long> productIdList;

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

    public List<Long> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Long> productIdList) {
        this.productIdList = productIdList;
    }
}
