package elif.dto;

import java.sql.Date;
import java.util.List;

public class OrderQueryDTO {

    private List<String> userIdList;
    private Date orderCreateMinDate;
    private Date orderCreateMaxDate;


    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public Date getOrderCreateMinDate() {
        return orderCreateMinDate;
    }

    public void setOrderCreateMinDate(Date orderCreateMinDate) {
        this.orderCreateMinDate = orderCreateMinDate;
    }

    public Date getOrderCreateMaxDate() {
        return orderCreateMaxDate;
    }

    public void setOrderCreateMaxDate(Date orderCreateMaxDate) {
        this.orderCreateMaxDate = orderCreateMaxDate;
    }
}
