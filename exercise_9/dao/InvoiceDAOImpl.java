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

	private static InvoiceDAOImpl invDAOobj;

	private InvoiceDAOImpl() {
	}

	public static InvoiceDAOImpl getInvoiceDAOImpl() {
		if (invDAOobj == null) {
			invDAOobj = new InvoiceDAOImpl();
			return invDAOobj;
		}
		return invDAOobj.createClone();
	}

	private InvoiceDAOImpl createClone() {
		if (invDAOobj != null) {
			try {
				return (InvoiceDAOImpl) super.clone();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public InvoiceDTO findByInvoiceID(int inv_id) {
		InvoiceDTO dto = null;
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from invoice_master where invoice_no=?");
			ps.setInt(1, inv_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new InvoiceDTO();
				dto.setInvoice_no(inv_id);
				dto.setCustomer_id(rs.getInt("customer_id"));
				dto.setInvoice_date(rs.getDate("invoice_date"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		}
		return dto;
	}

	@Override
	public InvoiceDTO findByCustomerID(int cus_id) {
		InvoiceDTO dto = null;
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from invoice_master where customer_id=?");
			ps.setInt(1, cus_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new InvoiceDTO();
				dto.setInvoice_no(rs.getInt("invoice_no"));
				dto.setCustomer_id(rs.getInt("customer_id"));
				dto.setInvoice_date(rs.getDate("invoice_date"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
			return null;
		}
		return dto;
	}

	@Override
	public Collection<InvoiceDTO> findAll() {
		List<InvoiceDTO> invoices = null;
		try {
			Connection con = DBHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from invoice_master");

			invoices = new ArrayList<>();
			while (rs.next()) {
				InvoiceDTO dto = new InvoiceDTO();
				dto.setInvoice_no(rs.getInt("invoice_no"));
				dto.setCustomer_id(rs.getInt("customer_id"));
				dto.setInvoice_date(rs.getDate("invoice_date"));
				invoices.add(dto);
			}
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		}
		return invoices;
	}

	@Override
	public int updateInvoice(InvoiceDTO newInvoice) {
		int affectedRows = 0;
		try {
			Connection con = DBHelper.getConnection();

			int inv_id = newInvoice.getCustomer_id();

			PreparedStatement ps = con.prepareStatement("select * from invoice_master where invoice_no=?");
			ps.setInt(1, inv_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ps = con.prepareStatement("update invoice_master set customer_id=?, invoice_date=? where invoice_no=?");
				ps.setInt(1, newInvoice.getCustomer_id());
				ps.setDate(2, new Date(newInvoice.getInvoice_date().toInstant().toEpochMilli()));
				ps.setInt(3, newInvoice.getInvoice_no());

				affectedRows = ps.executeUpdate();
				DBHelper.closeConnection(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBHelper.closeConnection(e);
		}
		return affectedRows;
	}

	@Override
	public int deleteInvoiceByID(int inv_id) {
		int affectedRows = 0;
		try {
			Connection con = DBHelper.getConnection();

			PreparedStatement ps = con.prepareStatement("delete from invoice_master where invoice_no=?");
			ps.setInt(1, inv_id);
			affectedRows = ps.executeUpdate();
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			e.printStackTrace();
			DBHelper.closeConnection(e);
		}
		return affectedRows;
	}

}
