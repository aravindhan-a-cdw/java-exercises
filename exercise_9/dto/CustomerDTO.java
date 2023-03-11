package exercise_9.dto;

import java.io.Serializable;

public class CustomerDTO implements Comparable<CustomerDTO>, Serializable {

	private static final long serialVersionUID = -6604078054807316182L;
	private Integer customerID;
	private String customerName;
	private String address;

	public CustomerDTO() {
	}

	public CustomerDTO(int customerID, String name, String address) {
		this.customerID = customerID;
		this.customerName = name;
		this.address = address;
	}
	
	public CustomerDTO(CustomerDTO customerDTO) {
		this.customerID = customerDTO.customerID;
		this.address = customerDTO.address;
		this.customerName = customerDTO.customerName;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerID=" + customerID + ", customerName=" + customerName + ", address=" + address
				+ "]";
	}

	@Override
	public int compareTo(CustomerDTO otherCustomerDTO) {
		return this.getCustomerName().compareTo(otherCustomerDTO.getCustomerName());
	}

}

/*
 * Customer Table
 * 
 * Create table customer_master(customer_id SERIAL, customer_name VARCHAR,
 * address TEXT); ALTER TABLE customer_master ADD PRIMARY KEY (customer_id);
 *
 */
