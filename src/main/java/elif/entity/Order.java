package elif.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "cost")
    private String cost;

    @Column(name = "order_create_date")
    private Date orderCreateDate;

    @Column(name = "order_update_date")
    private String orderUpdateDate;

    @ManyToOne
    @JoinColumn(name = "user_fk", foreignKey = @ForeignKey(name = "fk_order_user_id"))
    private User user;

    @OneToMany(mappedBy = "orderId")
    private List<OrderProductQuantity> orderProductQuantityList = new ArrayList<OrderProductQuantity>();

    @Column(name = "status")
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<OrderProductQuantity> getOrderProductQuantityList() {
        return orderProductQuantityList;
    }

    public void setOrderProductQuantityList(List<OrderProductQuantity> orderProductQuantityList) {
        this.orderProductQuantityList = orderProductQuantityList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order() {
    }

    public Order(String cost, Date orderCreateDate, String orderUpdateDate) {
        this.cost = cost;
        this.orderCreateDate = orderCreateDate;
        this.orderUpdateDate = orderUpdateDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public String getOrderUpdateDate() {
        return orderUpdateDate;
    }

    public void setOrderUpdateDate(String orderUpdateDate) {
        this.orderUpdateDate = orderUpdateDate;
    }
}
