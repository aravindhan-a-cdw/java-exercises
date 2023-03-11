package exercise_9;

import java.util.ArrayList;

import exercise_9.dao.CustomerDAOImpl;
import exercise_9.dao.ItemDAOImpl;
import exercise_9.dto.CustomerDTO;
import exercise_9.dto.ItemDTO;

public class Application {

	public static void main(String[] args) {
		CustomerDAOImpl customerDaoImpl = CustomerDAOImpl.getCustomerDAOImpl();
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setAddress("T Nagar, Chennai");
		customerDto.setCustomerName("Aravindhan");
		customerDto = customerDaoImpl.save(customerDto);
		
		System.out.println("New ID is :" + customerDto.getCustomerID());
		
		ArrayList<CustomerDTO> customers = (ArrayList<CustomerDTO>) customerDaoImpl.findAll();
		System.out.println(customers);
		
		customerDto = customers.get(0);
		
		customerDto.setAddress("Salem");
		customerDaoImpl.update(customerDto);
		
		customers = (ArrayList<CustomerDTO>) customerDaoImpl.findAll();
		System.out.println(customers);
		
		System.out.println(customerDaoImpl.delete(customerDto.getCustomerID()));
		
		customers = (ArrayList<CustomerDTO>) customerDaoImpl.findAll();
		System.out.println(customers);
		
		testItemDAO();
	}
	
	static void testItemDAO() {
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
