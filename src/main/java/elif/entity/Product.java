package elif.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "prdocut_create_date")
    private Date createProductDate;

    @Column(name = "product_update_date")
    private Date updateProductDate;

    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Product() {
    }

    public Product(String productName, String brand, String price, Date createProductDate, Date updateProductDate) {

        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.createProductDate = createProductDate;
        this.updateProductDate = updateProductDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreateProductDate() {
        return createProductDate;
    }

    public void setCreateProductDate(Date createProductDate) {
        this.createProductDate = createProductDate;
    }

    public Date getUpdateProductDate() {
        return updateProductDate;
    }

    public void setUpdateProductDate(Date updateProductDate) {
        this.updateProductDate = updateProductDate;
    }
}
