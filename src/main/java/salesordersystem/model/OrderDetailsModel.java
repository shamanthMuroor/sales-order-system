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
public class OrderDetailsModel implements Serializable{
	private static final long serialVersionUID = 909388769952044481L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private CustomerModel customer;
	private ItemModel item;
	private int qty;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreated;
	private String payMode;
	private String payStatus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public CustomerModel getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	public ItemModel getItem() {
		return item;
	}
	public void setItem(ItemModel item) {
		this.item = item;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	@Override
	public String toString() {
		return "OrderDetailsModel [orderId=" + orderId + ", customer=" + customer + ", item=" + item + ", qty=" + qty
				+ ", dateCreated=" + dateCreated + ", payMode=" + payMode + ", payStatus=" + payStatus + "]";
	}
	

	
	
}
