package in.sankarvinoth.model;

import java.sql.Date;
import java.sql.Time;


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
public Date getOrderPlacedDate() {
	return orderPlacedDate;
}
public void setOrderPlacedDate(Date date) {
	this.orderPlacedDate = date;
}
public Time getOrderPlacedTime() {
	return orderPlacedTime;
}
public void setOrderPlacedTime(Time time) {
	this.orderPlacedTime = time;
}
private String productName;
private int productTotal;
private int quantity;
private Date orderPlacedDate;
private Time orderPlacedTime;
@Override
public String toString() {
	return "Cart [username=" + username + ", productName=" + productName + ", productTotal=" + productTotal
			+ ", quantity=" + quantity + ", orderPlacedDate=" + orderPlacedDate + ", orderPlacedTime=" + orderPlacedTime
			+ "]";
}

}
