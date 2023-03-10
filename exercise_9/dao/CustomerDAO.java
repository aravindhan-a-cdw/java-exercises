package exercise_9.dao;

import java.util.Collection;

import exercise_9.dto.CustomerDTO;

public abstract class CustomerDAO {
	public abstract CustomerDTO findByID(int uid);
	public abstract CustomerDTO findByName(String uname);
	public abstract Collection<CustomerDTO> findAll();
	public abstract int updateCustomer(CustomerDTO newCustomerDto);
	public abstract void save(CustomerDTO newCustomerDto);
	public abstract int deleteCustomerByID(int uid);
	public abstract int deleteCustomerByName(String uname);
}
