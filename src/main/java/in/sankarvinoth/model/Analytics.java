package in.sankarvinoth.model;

public class Analytics {

	
	 @Override
	public String toString() {
		return "Analytics [productName=" + productName + ", quantitiesSold=" + quantitiesSold + "]";
	}
	private String productName;
	 private int quantitiesSold;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantitiesSold() {
		return quantitiesSold;
	}
	public void setQuantitiesSold(int quantitiesSold) {
		this.quantitiesSold = quantitiesSold;
	}

}
