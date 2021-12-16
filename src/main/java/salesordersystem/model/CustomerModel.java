package salesordersystem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerModel implements Serializable{
	private static final long serialVersionUID = 5351127822038425145L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cusname;
	private String contact;
	private String deliveryAddress;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer", fetch= FetchType.EAGER)
	private List<ItemModel> itemmodel;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public List<ItemModel> getItemmodel() {
		return itemmodel;
	}
	public void setItemmodel(List<ItemModel> itemmodel) {
		this.itemmodel = itemmodel;
	}
	@Override
	public String toString() {
		return "CustomerModel [cid=" + cid + ", cusname=" + cusname + ", contact=" + contact + ", deliveryAddress="
				+ deliveryAddress + ", itemmodel=" + itemmodel + "]";
	}

	 
}

