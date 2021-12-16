package salesordersystem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ItemModel implements Serializable{
	private static final long serialVersionUID = -6113909960226134858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private String itemName;
//	private String taxStatus;
	private float weight;
	private float price;
	
	@ManyToOne(fetch= FetchType.EAGER)
	private CustomerModel customer;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
//	public String getTaxStatus() {
//		return taxStatus;
//	}
//	public void setTaxStatus(String taxStatus) {
//		this.taxStatus = taxStatus;
//	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	
	
}
