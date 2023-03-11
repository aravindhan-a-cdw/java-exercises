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

	private static CustomerDAOImpl customerDaoObj;

	private CustomerDAOImpl() {
	} // Prevent creating new Object directly

	public static CustomerDAOImpl getCustomerDAOImpl() {
		if (customerDaoObj == null) {
			customerDaoObj = new CustomerDAOImpl();
			return customerDaoObj;
		}
		return customerDaoObj.createClone();
	}

	private CustomerDAOImpl createClone() {
		if (customerDaoObj != null) {
			try {
				return (CustomerDAOImpl) super.clone();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public CustomerDTO find(int customerID) {
		CustomerDTO customerDTO = null;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from customer_master where customer_id=?");
			preparedStatement.setInt(1, customerID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customerDTO = new CustomerDTO();
				customerDTO.setCustomerID(customerID);
				customerDTO.setCustomerName(resultSet.getString("customer_name"));
				customerDTO.setAddress(resultSet.getString("address"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		}
		return customerDTO;
	}

	@Override
	public CustomerDTO findByName(String customerName) {
		CustomerDTO customerDTO = null;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from customer_master where customer_name=?");
			preparedStatement.setString(1, customerName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customerDTO = new CustomerDTO();
				customerDTO.setCustomerID(resultSet.getInt("customer_id"));
				customerDTO.setCustomerName(resultSet.getString("customer_name"));
				customerDTO.setAddress(resultSet.getString("address"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		}
		return customerDTO;
	}

	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> customers = null;
		try {
			Connection connection = DBHelper.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer_master");

			customers = new ArrayList<CustomerDTO>();

			while (resultSet.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setCustomerID(resultSet.getInt("customer_id"));
				dto.setCustomerName(resultSet.getString("customer_name"));
				dto.setAddress(resultSet.getString("address"));
				customers.add(dto);
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		}
		return customers;
	}

	@Override
	public CustomerDTO update(CustomerDTO customerDto) {
		CustomerDTO updatedCustomerDto = null;

		try {
			Connection connection = DBHelper.getConnection();

			int customerID = customerDto.getCustomerID();

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from customer_master where customer_id=?");
			preparedStatement.setInt(1, customerID);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				preparedStatement = connection
						.prepareStatement("update customer_master set customer_name=?, address=? where customer_id=?");
				preparedStatement.setString(1, customerDto.getCustomerName());
				preparedStatement.setString(2, customerDto.getAddress());
				preparedStatement.setInt(3, customerDto.getCustomerID());

				int affectedRows = preparedStatement.executeUpdate();
				if (affectedRows == 0) {
					throw new SQLException("No rows updated!");
				}
				DBHelper.closeConnection(null);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			DBHelper.closeConnection(exception);
		}
		return updatedCustomerDto;

	}

	@Override
	public boolean delete(int customerID) {
		try {
			Connection connection = DBHelper.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from customer_master where customer_id=?");
			preparedStatement.setInt(1, customerID);

			int affectedRows = preparedStatement.executeUpdate();
			DBHelper.closeConnection(null);
			return affectedRows == 1;
		} catch (Exception exception) {
			exception.printStackTrace();
			DBHelper.closeConnection(exception);
		}
		return false;
	}

	@Override
	public CustomerDTO save(CustomerDTO customerDto) {
		CustomerDTO newCustomerDto = null;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into customer_master(customer_name, address) VALUES(?, ?) returning customer_id");
			preparedStatement.setString(1, customerDto.getCustomerName());
			preparedStatement.setString(2, customerDto.getAddress());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				newCustomerDto = new CustomerDTO(customerDto);
				newCustomerDto.setCustomerID(rs.getInt(1));
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			exception.printStackTrace();
			DBHelper.closeConnection(exception);
		}
		return newCustomerDto;
	}

}
