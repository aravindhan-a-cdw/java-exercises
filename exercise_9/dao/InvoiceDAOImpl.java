package exercise_9.dao;

import java.sql.Statement;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exercise_9.dto.InvoiceDTO;
import user_application.DBHelper;

public class InvoiceDAOImpl extends InvoiceDAO {

	private static InvoiceDAOImpl invDaoObj;

	private InvoiceDAOImpl() {
	}

	public static InvoiceDAOImpl getInvoiceDAOImpl() {
		if (invDaoObj == null) {
			invDaoObj = new InvoiceDAOImpl();
			return invDaoObj;
		}
		return invDaoObj.createClone();
	}

	private InvoiceDAOImpl createClone() {
		if (invDaoObj != null) {
			try {
				return (InvoiceDAOImpl) super.clone();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public InvoiceDTO find(int invoiceID) {
		InvoiceDTO invoiceDto = null;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from invoice_master where invoice_no=?");
			preparedStatement.setInt(1, invoiceID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				invoiceDto = new InvoiceDTO();
				invoiceDto.setInvoiceNumber(invoiceID);
				invoiceDto.setCustomerID(resultSet.getInt("customer_id"));
				invoiceDto.setInvoiceDate(resultSet.getDate("invoice_date"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		}
		return invoiceDto;
	}

	@Override
	public InvoiceDTO findByCustomerID(int customerID) {
		InvoiceDTO invoiceDto = null;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from invoice_master where customer_id=?");
			preparedStatement.setInt(1, customerID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				invoiceDto = new InvoiceDTO();
				invoiceDto.setInvoiceNumber(resultSet.getInt("invoice_no"));
				invoiceDto.setCustomerID(resultSet.getInt("customer_id"));
				invoiceDto.setInvoiceDate(resultSet.getDate("invoice_date"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
			return null;
		}
		return invoiceDto;
	}

	@Override
	public Collection<InvoiceDTO> findAll() {
		List<InvoiceDTO> invoices = null;
		try {
			Connection connection = DBHelper.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from invoice_master");

			invoices = new ArrayList<>();
			while (resultSet.next()) {
				InvoiceDTO invoiceDto = new InvoiceDTO();
				invoiceDto.setInvoiceNumber(resultSet.getInt("invoice_no"));
				invoiceDto.setCustomerID(resultSet.getInt("customer_id"));
				invoiceDto.setInvoiceDate(resultSet.getDate("invoice_date"));
				invoices.add(invoiceDto);
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		}
		return invoices;
	}

	@Override
	public InvoiceDTO update(InvoiceDTO invoiceDto) {
		InvoiceDTO updateInvoiceDto = null;
		
		try {
			Connection connection = DBHelper.getConnection();

			int invoiceID = invoiceDto.getInvoiceNumber();

			PreparedStatement preparedStatement = connection.prepareStatement("select * from invoice_master where invoice_no=?");
			preparedStatement.setInt(1, invoiceID);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				preparedStatement = connection.prepareStatement("update invoice_master set customer_id=?, invoice_date=? where invoice_no=?");
				preparedStatement.setInt(1, invoiceDto.getCustomerID());
				preparedStatement.setDate(2, new Date(invoiceDto.getInvoiceDate().toInstant().toEpochMilli()));
				preparedStatement.setInt(3, invoiceDto.getInvoiceNumber());

				if(preparedStatement.executeUpdate() == 1) {
					updateInvoiceDto = new InvoiceDTO(invoiceDto);					
				}
				DBHelper.closeConnection(null);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			DBHelper.closeConnection(exception);
		}
		return updateInvoiceDto;
	}

	@Override
	public boolean delete(int invoiceID) {
		int affectedRows = 0;
		try {
			Connection connection = DBHelper.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("delete from invoice_master where invoice_no=?");
			preparedStatement.setInt(1, invoiceID);
			affectedRows = preparedStatement.executeUpdate();
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			exception.printStackTrace();
			DBHelper.closeConnection(exception);
		}
		return affectedRows != 0;
	}

}
