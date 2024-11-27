package intra.bca.co.id.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import intra.bca.co.id.bo.CustomerBo;
import intra.bca.co.id.service.Customer;
import intra.bca.co.id.service.CustomerForm;

@Controller
public class CustomerController {
	@Autowired
	private CustomerBo customerBo;
	
	@RequestMapping(value = "/list-customer", method = RequestMethod.GET)
	public String listCustomer(Model m) {
		m.addAttribute("customers", customerBo.findAllCustomer());
		return "customer-list";
	}
	
	@RequestMapping(value = "/create-customer", method = RequestMethod.GET)
	public String prepareCreate(Model m) {
		CustomerForm customer = new CustomerForm();
		m.addAttribute("err_message", "");
		m.addAttribute("success_message", "");
		m.addAttribute("cust_id", "");
		customer.setFlag("CREATE");
		m.addAttribute("customerForm", customer);
		return "customer-form";
	}
	
	@RequestMapping(value = "/create-customer", method = RequestMethod.POST)
	public String submitCreate(@ModelAttribute @Valid CustomerForm cust, BindingResult result, Model m) {
		String flag = cust.getFlag();
		m.addAttribute("err_message", "");
		m.addAttribute("success_message", "");
		
		if(flag.equals("CREATE")) m.addAttribute("cust_id", 0);
		else m.addAttribute("cust_id", cust.getCustId());
		
		if(!result.hasErrors()) {
			Customer customer = new Customer(cust.getCustId(), cust.getFullname(), cust.getAddress(), cust.getEmail());
			try {
				if(flag.equals("CREATE")) {
					customerBo.insert(customer);
					m.addAttribute("success_message", "Successfully created customer: " + cust.getFullname());
				}
				else {
					customerBo.update(customer);
					m.addAttribute("success_message", "Successfully updated customer: " + cust.getFullname());
				}
				
				m.addAttribute("cust_id", cust.getCustId());
				cust.setFlag("UPDATE");
			} catch (Exception e) {
				m.addAttribute("err_message", e.getMessage());
			}
		}
		return "customer-form";
	}
	
	@RequestMapping(value = { "/delete-customer-{custId}" }, method = RequestMethod.GET)
	public String submitDelete(@PathVariable int custId) {
		customerBo.delete(custId);
		return "redirect:/list-customer";
	}
	
	@RequestMapping(value = { "/update-customer-{custId}" }, method = RequestMethod.GET)
	public String prepareUpdate(@PathVariable int custId, Model m) {
		Customer cust = customerBo.findByCustomerId(custId);
		CustomerForm customer = new CustomerForm();
		customer.setCustId(custId);
		customer.setFullname(cust.getFullName());
		customer.setAddress(cust.getAddress());
		customer.setEmail(cust.getEmail());
		customer.setFlag("EDIT");
		m.addAttribute("err_message", "");
		m.addAttribute("success_message", "");
		m.addAttribute("cust_id", custId);
		m.addAttribute("customerForm", customer);
		return "customer-form";
	}
	
	@RequestMapping(value = { "/update-customer-{custId}" }, method = RequestMethod.POST)
	public String submitUpdate(@ModelAttribute @Valid CustomerForm cust, BindingResult result, Model m) {
		m.addAttribute("err_message", "");
		m.addAttribute("success_message", "");
		m.addAttribute("cust_id", cust.getCustId());
		
		if(!result.hasErrors()) {
			Customer customer = new Customer(cust.getCustId(), cust.getFullname(), cust.getAddress(), cust.getEmail());
			try {
				customerBo.update(customer);
				m.addAttribute("success_message", "Successfully updated Customer: " + cust.getFullname());
				m.addAttribute("cust_id", cust.getCustId());
				cust.setFlag("UPDATE");
			} catch (Exception e) {
				m.addAttribute("err_message", e.getMessage());
			}
		}
		return "customer-form";
	}
}
