package elif.dto;

import java.util.List;

public class OrderCreateDTO {

	private String email;
	private List<Long> productList;
	private Long productId;

	public String getEmail() {
		return email;
	}

	public List<Long> getProductList() {
		return productList;
	}

	public void setProductList(List<Long> productList) {
		this.productList = productList;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
