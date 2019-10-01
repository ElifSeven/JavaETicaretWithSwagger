package elif.dto;

public class OrderProductQuantityResponseDTO {

    private String productName;
    private int productOrderQuantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductOrderQuantity() {
        return productOrderQuantity;
    }

    public void setProductOrderQuantity(int productOrderQuantity) {
        this.productOrderQuantity = productOrderQuantity;
    }
}
