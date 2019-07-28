package elif.dto;

import elif.entity.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderResponseDTO {

    @Autowired
    private ModelMapper modelMapper;

    public void configuration() {
        PropertyMap<Order, OrderResponseDTO> orderMap = new PropertyMap<Order, OrderResponseDTO>() {
            @Override
            protected void configure() {
                map().setOrderCost(source.getCost());

            }
        };
        modelMapper.addMappings(orderMap);
    }

    private List<ProductCreateDTO> productCreateDTOList;
    private String orderCost;

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
}
