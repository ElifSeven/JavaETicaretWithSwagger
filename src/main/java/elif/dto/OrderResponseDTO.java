package elif.dto;

import java.util.List;

public class OrderResponseDTO {

    private List<OrderProductQuantityResponseDTO> orderProductQuantityResponseDTOList;
    private String orderCost;
    private String email;

    public List<OrderProductQuantityResponseDTO> getOrderProductQuantityResponseDTOList() {
        return orderProductQuantityResponseDTOList;
    }

    public void setOrderProductQuantityResponseDTOList(List<OrderProductQuantityResponseDTO> orderProductQuantityResponseDTOList) {
        this.orderProductQuantityResponseDTOList = orderProductQuantityResponseDTOList;
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
