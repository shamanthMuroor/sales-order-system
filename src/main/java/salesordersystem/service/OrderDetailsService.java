package salesordersystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import salesordersystem.model.OrderDetailsModel;


@Component
public class OrderDetailsService {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertOrderDetails(OrderDetailsModel orderDetailsModel) {
		this.hibernateTemplate.saveOrUpdate(orderDetailsModel);
	}
//
//	// get single orderDetails
//	@Transactional
//	public OrderDetailsModel getSingleOrderDetails(int orderDetailsId) {
//		return this.hibernateTemplate.get(OrderDetailsModel.class, orderDetailsId);
//	}
//	
	// get all orderDetailss
	@Transactional
	public List<OrderDetailsModel> getOrderDetailsList() {
		List<OrderDetailsModel> orderDetailsModels = this.hibernateTemplate.loadAll(OrderDetailsModel.class);
		return orderDetailsModels;
	}
//	
//	// delete orderDetails by id
//	@Transactional
//	public void deleteOrderDetails(int orderDetailsId) {
//		OrderDetailsModel orderDetailsModel = this.hibernateTemplate.load(OrderDetailsModel.class, orderDetailsId);
//		this.hibernateTemplate.delete(orderDetailsModel);
//	}
	
	
}
