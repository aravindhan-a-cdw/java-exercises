package exercise_9;

import java.util.ArrayList;

import exercise_9.dao.CustomerDAOImpl;
import exercise_9.dao.ItemDAOImpl;
import exercise_9.dto.CustomerDTO;
import exercise_9.dto.ItemDTO;

public class Application {

	public static void main(String[] args) {
		CustomerDAOImpl cusImpl = CustomerDAOImpl.getCustomerDAOImpl();
		CustomerDTO dto = new CustomerDTO();
		dto.setAddress("T Nagar, Chennai");
		dto.setCustomer_name("Aravindhan");
		cusImpl.save(dto);
		
		System.out.println("New ID is :" + dto.getCustomer_id());
		
		ArrayList<CustomerDTO> customers = (ArrayList<CustomerDTO>) cusImpl.findAll();
		System.out.println(customers);
		
		dto = customers.get(0);
		
		dto.setAddress("Salem");
		cusImpl.updateCustomer(dto);
		
		customers = (ArrayList<CustomerDTO>) cusImpl.findAll();
		System.out.println(customers);
		
		System.out.println(cusImpl.deleteCustomerByID(customers.get(0).getCustomer_id()));
		
		customers = (ArrayList<CustomerDTO>) cusImpl.findAll();
		System.out.println(customers);
	}
	
	void testItemDAO() {
		ItemDAOImpl itemImpl = ItemDAOImpl.getInvoiceDAOImpl();
		
		ItemDTO dto = new ItemDTO();
		
		dto.setDescription("An apple a day keeps the doctor away!");
		dto.setPrice(50);
		dto.setUnit("KG");
		
		itemImpl.save(dto);
		
		ArrayList<ItemDTO> items = (ArrayList<ItemDTO>) itemImpl.findAll();
		
		System.out.println(items);
		
	}

}
