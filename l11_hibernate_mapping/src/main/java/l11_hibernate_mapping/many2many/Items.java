package l11_hibernate_mapping.many2many;

import java.util.Set;

public class Items {
	
	private int id;
	private String itemId;
	private double price;
	private Set<Cart> carts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", itemId=" + itemId + ", price=" + price + ", carts=" + carts + "]";
	}
	public Items( String itemId, double price) {
		super();
		
		this.itemId = itemId;
		this.price = price;
		
	}
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
