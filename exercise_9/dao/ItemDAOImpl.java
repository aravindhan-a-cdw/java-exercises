package exercise_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exercise_9.dto.ItemDTO;
import user_application.DBHelper;

public class ItemDAOImpl extends ItemDAO {
	
	private static ItemDAOImpl itemDAOobj;

	private ItemDAOImpl() {
	}

	public static ItemDAOImpl getInvoiceDAOImpl() {
		if (itemDAOobj == null) {
			itemDAOobj = new ItemDAOImpl();
			return itemDAOobj;
		}
		return itemDAOobj.createClone();
	}

	private ItemDAOImpl createClone() {
		if (itemDAOobj != null) {
			try {
				return (ItemDAOImpl) super.clone();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ItemDTO findByID(int item_id) {
		ItemDTO dto = null;
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from item_master where item_id=?");
			ps.setInt(1, item_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new ItemDTO();
				dto.setItem_id(item_id);
				dto.setDescription(rs.getString("description"));
				dto.setPrice(rs.getInt("price"));
				dto.setUnit(rs.getString("unit"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		}
		return dto;
	}

	@Override
	public Collection<ItemDTO> findAll() {
		List<ItemDTO> items = null;
		try {
			Connection con = DBHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from item_master");
			items = new ArrayList<>();
			
			while (rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItem_id(rs.getInt("item_id"));
				dto.setDescription(rs.getString("description"));
				dto.setPrice(rs.getInt("price"));
				dto.setUnit(rs.getString("unit"));
				items.add(dto);
			}
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		}
		return items;
	}

	@Override
	public int updateItem(ItemDTO newItem) {
		int affectedRows = 0;
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from item_master where item_id=?");
			int item_id = newItem.getItem_id();
			ps.setInt(1, item_id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				ps = con.prepareStatement("update item_master set description=?, price=?, unit=? where item_id=?");
				ps.setString(1, newItem.getDescription());
				ps.setDouble(2, newItem.getPrice());
				ps.setString(3, newItem.getUnit());
				ps.setInt(4, item_id);
				affectedRows = ps.executeUpdate();
			}
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		} finally {
			DBHelper.closeConnection(null);
		}
		return affectedRows;
	}

	@Override
	public int deleteByID(int item_id) {
		int affectedRows = 0;
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from item_master where item_id=?");
			ps.setInt(1, item_id);
			affectedRows = ps.executeUpdate();
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			DBHelper.closeConnection(e);
		}
		return affectedRows;
	}

	@Override
	public void save(ItemDTO newItem) {
		try {
			Connection con = DBHelper.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into item_master(description, price, unit) VALUES(?, ?, ?)");
			ps.setString(1, newItem.getDescription());
			ps.setInt(2, newItem.getPrice());
			ps.setString(3, newItem.getUnit());
			
			ps.executeUpdate();
			DBHelper.closeConnection(null);
		} catch (Exception e) {
			e.printStackTrace();
			DBHelper.closeConnection(e);
		}
	}

}
