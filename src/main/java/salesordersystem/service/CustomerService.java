package salesordersystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import salesordersystem.model.CustomerModel;


@Component
public class CustomerService {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertCustomer(CustomerModel customerModel) {
		this.hibernateTemplate.saveOrUpdate(customerModel);
	}

	// get single customer
	@Transactional
	public CustomerModel getSingleCustomer(int cid) {
		return this.hibernateTemplate.get(CustomerModel.class, cid);
	}
	
	@Transactional
	public CustomerModel getSingleCustomer(String cusname) {
		return this.hibernateTemplate.get(CustomerModel.class, cusname);
	}
	
	// get all customers
	@Transactional
	public List<CustomerModel> getCustomerList() {
		List<CustomerModel> customerModels =  this.hibernateTemplate.loadAll(CustomerModel.class);
		return customerModels;
	}
	
	// delete customer by id
	@Transactional
	public void deleteCustomer(int cid) {
		CustomerModel customerModel = this.hibernateTemplate.load(CustomerModel.class,cid);
		this.hibernateTemplate.delete(customerModel);
	}
	
	
}
