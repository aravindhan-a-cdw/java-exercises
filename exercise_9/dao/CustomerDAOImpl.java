package exercise_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise_9.dto.CustomerDTO;
import user_application.DBHelper;

public class CustomerDAOImpl extends CustomerDAO implements Cloneable {

	private static CustomerDAOImpl cusDAOobj;

	private CustomerDAOImpl() {
	} // Prevent creating new Object directly

	public static CustomerDAOImpl getCustomerDAOImpl() {
		if (cusDAOobj == null) {
			cusDAOobj = new CustomerDAOImpl();
			return cusDAOobj;
		}
		return cusDAOobj.createClone();
	}

	private CustomerDAOImpl createClone() {
		if (cusDAOobj != null) {
			try {
				return (CustomerDAOImpl) super.clone();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public CustomerDTO findByID(int uid) {
		CustomerDTO dto = null;
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer_master where customer_id=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new CustomerDTO();
				dto.setCustomer_id(uid);
				dto.setCustomer_name(rs.getString("customer_name"));
				dto.setAddress(rs.getString("address"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		}
		return dto;
	}

	@Override
	public CustomerDTO findByName(String cus_name) {
		CustomerDTO dto = null;
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer_master where customer_name=?");
			ps.setString(1, cus_name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new CustomerDTO();
				dto.setCustomer_id(rs.getInt("customer_id"));
				dto.setCustomer_name(rs.getString("customer_name"));
				dto.setAddress(rs.getString("address"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		}
		return dto;
	}

	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> customers = null;
		try {
			Connection con = DBHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer_master");

			customers = new ArrayList<CustomerDTO>();

			while (rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setCustomer_id(rs.getInt("customer_id"));
				dto.setCustomer_name(rs.getString("customer_name"));
				dto.setAddress(rs.getString("address"));
				customers.add(dto);
			}
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		}
		return customers;
	}

	@Override
	public int updateCustomer(CustomerDTO newCustomerDto) {

		try {
			Connection con = DBHelper.getConnection();

			int uid = newCustomerDto.getCustomer_id();

			PreparedStatement ps = con.prepareStatement("select * from customer_master where customer_id=?");
			ps.setInt(1, uid);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				ps = con.prepareStatement("update customer_master set customer_name=?, address=? where customer_id=?");
				ps.setString(1, newCustomerDto.getCustomer_name());
				ps.setString(2, newCustomerDto.getAddress());
				ps.setInt(3, newCustomerDto.getCustomer_id());

				int n = ps.executeUpdate();
				DBHelper.closeConnection(null);
				return n;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBHelper.closeConnection(e);
		}
		return 0;

	}

	@Override
	public int deleteCustomerByID(int cus_id) {
		try {
			Connection con = DBHelper.getConnection();

			PreparedStatement ps = con.prepareStatement("delete from customer_master where customer_id=?");
			ps.setInt(1, cus_id);

			int rs = ps.executeUpdate();
			DBHelper.closeConnection(null);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			DBHelper.closeConnection(e);
		}
		return 0;
	}

	@Override
	public int deleteCustomerByName(String cus_name) {
		try {
			Connection con = DBHelper.getConnection();

			PreparedStatement ps = con.prepareStatement("delete from customer_master where customer_name=?");
			ps.setString(1, cus_name);

			int rs = ps.executeUpdate();
			DBHelper.closeConnection(null);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			DBHelper.closeConnection(e);
		}
		return 0;
	}

	@Override
	public void save(CustomerDTO newCustomerDto) {
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into customer_master(customer_name, address) VALUES(?, ?) returning customer_id");
			ps.setString(1, newCustomerDto.getCustomer_name());
			ps.setString(2, newCustomerDto.getAddress());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				newCustomerDto.setCustomer_id(rs.getInt(1));
			}
//			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
//	            if (generatedKeys.next()) {
//	                newCustomerDto.setCustomer_id(generatedKeys.getInt(1));
//	            }
//	            else {
//	                throw new SQLException("Creating user failed, no ID obtained.");
//	            }
//	        }
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			e.printStackTrace();
			DBHelper.closeConnection(e);
		}
	}

}
