package in.sankarvinoth.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cart {

	public Cart() {
		
	}
private String username;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getProductTotal() {
	return productTotal;
}
public void setProductTotal(int productTotal) {
	this.productTotal = productTotal;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public LocalDate getOrderPlacedDate() {
	return orderPlacedDate;
}
public void setOrderPlacedDate(LocalDate orderPlacedDate) {
	this.orderPlacedDate = orderPlacedDate;
}
public LocalTime getOrderPlacedTime() {
	return orderPlacedTime;
}
public void setOrderPlacedTime(LocalTime orderPlacedTime) {
	this.orderPlacedTime = orderPlacedTime;
}
private String productName;
private int productTotal;
private int quantity;
private LocalDate orderPlacedDate;
private LocalTime orderPlacedTime;
@Override
public String toString() {
	return "Cart [username=" + username + ", productName=" + productName + ", productTotal=" + productTotal
			+ ", quantity=" + quantity + ", orderPlacedDate=" + orderPlacedDate + ", orderPlacedTime=" + orderPlacedTime
			+ "]";
}

}
