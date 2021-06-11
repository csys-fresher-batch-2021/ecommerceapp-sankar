package in.sankarvinoth.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cart {

	public Cart() {
		
	}
private String username;
private String status;
private String userName;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
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

private String productName;
private int productTotal;
private int quantity;
private LocalDate orderPlacedDate;
private LocalTime orderPlacedTime;
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
@Override
public String toString() {
	return "Cart [username=" + username + ", status=" + status + ", userName=" + userName + ", productName="
			+ productName + ", productTotal=" + productTotal + ", quantity=" + quantity + ", orderPlacedDate="
			+ orderPlacedDate + ", orderPlacedTime=" + orderPlacedTime + "]";
}


}
