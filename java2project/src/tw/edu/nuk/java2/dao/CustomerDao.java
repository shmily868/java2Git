package tw.edu.nuk.java2.dao;

import java.util.List;
import java.util.Map;

import tw.edu.nuk.java2.model.Customer;

public interface CustomerDao {
	Customer get(long Custid);
	void saveOrUpdate(Customer customer);
	void delete(Customer customer);
	void delete(long Custid);
	List<Customer> search(Map<String,String> conditions);
	
}
