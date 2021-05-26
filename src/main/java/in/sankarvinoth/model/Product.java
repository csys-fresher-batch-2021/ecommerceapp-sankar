package in.sankarvinoth.model;

public class Product {
private int quantity;




public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}

private String productId;


private String productName;
private int amount;
private String category;
private String status;


public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getStatus() {
	return status;
}
@Override
public String toString() {
	return "Product [quantity=" + quantity + ", productId=" + productId + ", productName=" + productName + ", amount="
			+ amount + ", category=" + category + ", status=" + status + "]";
}
public void setStatus(String status) {
	this.status = status;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}





}
