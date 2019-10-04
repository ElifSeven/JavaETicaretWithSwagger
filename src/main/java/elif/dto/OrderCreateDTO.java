package elif.dto;

import java.util.HashMap;

public class OrderCreateDTO {

    private String email;
    private HashMap<Long, Integer> productWithQuantityList;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<Long, Integer> getProductWithQuantityList() {
        return productWithQuantityList;
    }

    public void setProductWithQuantityList(HashMap<Long, Integer> productWithQuantityList) {
        this.productWithQuantityList = productWithQuantityList;

    }
}
