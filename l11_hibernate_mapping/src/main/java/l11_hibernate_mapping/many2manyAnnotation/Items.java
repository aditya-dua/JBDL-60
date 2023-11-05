package l11_hibernate_mapping.many2manyAnnotation;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="item-m2m-annotation")
public class Items {
	@Id
	@Column(name="item_id")
	@GeneratedValue
	private int id;
	
	@Column(name="itemId")
	private String itemId;
	
	@Column(name="price")
	private double price;
	
	
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
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", itemId=" + itemId + ", price=" + price + ", carts="  + "]";
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
