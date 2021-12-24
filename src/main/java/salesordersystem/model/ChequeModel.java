package salesordersystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class ChequeModel extends Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int orderId;
	
	private String chequeNo, bankID;

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private OrderDetailsModel orderDetailsModel;
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderDetailsModel getOrderDetailsModel() {
		return orderDetailsModel;
	}

	public void setOrderDetailsModel(OrderDetailsModel orderDetailsModel) {
		this.orderDetailsModel = orderDetailsModel;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public void authorized() {
		
	}

	@Override
	public String toString() {
		return "Cheque [chequeNo=" + chequeNo + ", bankID=" + bankID + ", amount=" + getAmount() + "]";
	}
	
	
	
}
