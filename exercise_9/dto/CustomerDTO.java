package exercise_9.dto;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Comparable<CustomerDTO>, Serializable {
	
	private static final long serialVersionUID = -1462365674124914972L;
	private Integer customer_id;
	private String customer_name;
	private String address;
	
	public CustomerDTO() {}
	
	public CustomerDTO(int customer_id, String name, String address) {
		this.customer_id = customer_id;
		this.customer_name = name;
		this.address = address;
	}
	
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, customer_id, customer_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(customer_id, other.customer_id)
				&& Objects.equals(customer_name, other.customer_name);
	}
	@Override
	public String toString() {
		return "CustomerDTO [customer_id=" + customer_id + ", customer_name=" + customer_name + ", address=" + address
				+ "]";
	}
	@Override
	public int compareTo(CustomerDTO o) {
		return this.customer_name.compareTo(o.customer_name);
	}


}


/*
 * Customer Table
 * 
 *  Create table customer_master(customer_id SERIAL, customer_name VARCHAR, address TEXT);
 *	ALTER TABLE customer_master ADD PRIMARY KEY (customer_id);
 *
 */
