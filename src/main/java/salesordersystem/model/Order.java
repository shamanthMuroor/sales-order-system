//package salesordersystem.model;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.persistence.Query;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//
//public class Order {
//
//	SessionFactory sc = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//	Session session = sc.openSession();
//	Transaction t = session.beginTransaction();
//	
//	public void insertToCustomer(Customer customer) throws Exception {
////		customer.setCustomerID(customer.getCustomerID());
////		customer.setCusname(customer.getCusname());
////		customer.setContact(customer.getContact());
////		customer.setDeliveryAddress(customer.getDeliveryAddress());
//		session.save(customer);
//		t.commit();
//		System.out.println("Data inserted successfully");
//	    session.close();
//	}
//	
//	public void insertToItem(Item item) throws Exception {
//		session.save(item);
//		t.commit();
//		System.out.println("Data inserted successfully");
//	    session.close();
//	}
//	
////
////	public void delete(String usn) {
////		Query q = session.createQuery("delete from Student where usn = :usn");
////		q.setParameter("usn", usn);
////		int status = q.executeUpdate();
////		if (status == 0) {
////			System.out.println(usn + " Deleted successfully");
////		} else {
////			System.out.println(usn + " not found");
////		}
////	}
////
//	public List display() {
////		Query q = session.createQuery("select customer, item from Customer customer, Item item where customer.customerID = item.customerID");
//		Query q = session.createQuery("select customer, item from Customer customer, Item item where customer.customerID = item.customerID");
//		List<Object> details = new ArrayList();
//		List l = q.getResultList();
//		Iterator it = l.iterator();
//		while (it.hasNext()) {
//			Object ob = (Object) it.next();
//			details.add(ob);
////			System.out.println("customer objects: " + ob);
////			System.out.println(ob.customerID);
////			System.out.println(ob.toString());
////			System.out.println();
//		}
//		return details;
//	}
////
////	public void search(String usn) {
////		Query q = session.createQuery("from Student where usn = :usn");
////		q.setParameter("usn", usn);
////		List l = q.getResultList();
////		if (l.isEmpty()) {
////			System.out.println("Not Found");
////		} else {
////			Iterator it = l.iterator();
////			System.out.println("Student Details:");
////			while (it.hasNext()) {
////				Student s = (Student) it.next();
////				System.out.println(s.toString());
////			}
////		}
////	}
//	
//}
//
//
//
////
////<!-- 		<c:forEach  var="customer" items="${cusArrList}">
////<li>Customer ID: ${customer.customerID}</li>
////<li>Customer Name: ${customer.cusname}</li>
////<li>Customer contact: ${customer.contact}</li>
////<li>Customer Delivery Address: ${customer.deliveryAddress}</li>
////<br><hr><br>
////</c:forEach> -->
