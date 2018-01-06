package tw.edu.nuk.java2.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.nuk.java2.dao.CustomerDao;
import tw.edu.nuk.java2.model.Customer;

@Controller
public class ServiceFacade {
	

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	

    @RequestMapping(value="/hello", method=RequestMethod.GET)
	public void sayHello() {
	}
	
   
    @RequestMapping(value="/insert", method=RequestMethod.GET)
	public String setupInsertion(Model model) {
    	
    	Customer customer = new Customer();
    	model.addAttribute("customer", customer);
    	return "Insert";
	}
    
    @RequestMapping(value="/insert", method=RequestMethod.POST)
	@Transactional
	public String doInsertion(@ModelAttribute("customer") Customer customer, Model model) {
    	customerDao.saveOrUpdate(customer);  
		model.addAttribute("companyName", customer.getCompanyName());
		model.addAttribute("contactName", customer.getContactName());
		model.addAttribute("contactTitle", customer.getContactTitle());
    	
    	return "redirect:query";
	}
    
    @RequestMapping(value="/update")
    @Transactional
	public String setupUpdateForm(Model model, @RequestParam(value="custid", defaultValue="") String custid) {
    	
    	Customer customer = customerDao.get(Long.parseLong(custid));
    	model.addAttribute("customer", customer);
    	return "Update";
	}
  
    @RequestMapping(value="/updateConfirm")
	@Transactional
	public String doUpdate(@ModelAttribute("customer") Customer customer, Model model) {
    	customerDao.saveOrUpdate(customer);  
		model.addAttribute("companyName", customer.getCompanyName());
		model.addAttribute("contactName", customer.getContactName());
		model.addAttribute("contactTitle", customer.getContactTitle());
    	
    	return "redirect:query";
	}
  /*  
    @RequestMapping(value="/updateConfirm")
	@Transactional
	public String doUpdate(@ModelAttribute("customer") Customer customer, Model model){
    	
    	//Transaction tx = null;
    	Session session = null;
    	try {
			session = sessionFactory.getCurrentSession();
			//tx = session.getTransaction();
			//tx.begin();
			session.saveOrUpdate(customer);			
			//customerDao.saveOrUpdate(customer);  
			model.addAttribute("companyName", customer.getCompanyName());
			model.addAttribute("contactName", customer.getContactName());
			model.addAttribute("contactTitle", customer.getContactTitle());
			//tx.commit();
		} catch (HibernateException e) {
			try {
				//if (tx!=null) {
				//	tx.rollback();
				//}
				e.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (session != null) {
				//session.close();
			}
		}
    	
    	return "redirect:query";
    }
    */
    
	@RequestMapping(value="/query")
	@Transactional
	public String doQuery(@RequestParam(value="companyName", defaultValue="") String companyName,
			@RequestParam(value="contactName", defaultValue="") String contactName,
			@RequestParam(value="contactTitle", defaultValue="") String contactTitle,
			Model model) {
		Map<String, String> conditions = new HashMap<String,String>();
		conditions.put("companyName", companyName);
		conditions.put("contactName", contactName);
		conditions.put("contactTitle", contactTitle);
		model.addAttribute("customers", customerDao.search(conditions));
		model.addAttribute("companyName", companyName);
		model.addAttribute("contactName", contactName);
		model.addAttribute("contactTitle", contactTitle);
		return "Browse";
	}
	
	@RequestMapping(value="/delete")
	@Transactional
	public String doDeletion(@RequestParam(value="companyName", defaultValue="") String companyName,
			@RequestParam(value="contactName", defaultValue="") String contactName,
			@RequestParam(value="contactTitle", defaultValue="") String contactTitle,
			@RequestParam(value="custid", defaultValue="") String custid,
			Model model, HttpServletResponse response) {
		
		customerDao.delete(Long.parseLong(custid));
		model.addAttribute("companyName", companyName);
		model.addAttribute("contactName", contactName);
		model.addAttribute("contactTitle", contactTitle);
				
		return "redirect:query";
	}
	

}
