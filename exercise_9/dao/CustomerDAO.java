package exercise_9.dao;

import java.util.Collection;

import exercise_9.dto.CustomerDTO;

public abstract class CustomerDAO {
	public abstract CustomerDTO find(int customerID);
	public abstract CustomerDTO findByName(String customerName);
	public abstract Collection<CustomerDTO> findAll();
	public abstract CustomerDTO update(CustomerDTO customerDto);
	public abstract CustomerDTO save(CustomerDTO customerDto);
	public abstract boolean delete(int customerID);
}
