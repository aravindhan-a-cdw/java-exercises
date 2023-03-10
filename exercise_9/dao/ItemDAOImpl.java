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
	
	private static ItemDAOImpl itemDaoObj;

	private ItemDAOImpl() {
	}

	public static ItemDAOImpl getInvoiceDAOImpl() {
		if (itemDaoObj == null) {
			itemDaoObj = new ItemDAOImpl();
			return itemDaoObj;
		}
		return itemDaoObj.createClone();
	}

	private ItemDAOImpl createClone() {
		if (itemDaoObj != null) {
			try {
				return (ItemDAOImpl) super.clone();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ItemDTO find(int itemID) {
		ItemDTO itemDto = null;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from item_master where item_id=?");
			preparedStatement.setInt(1, itemID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				itemDto = new ItemDTO();
				itemDto.setItemID(itemID);
				itemDto.setDescription(resultSet.getString("description"));
				itemDto.setPrice(resultSet.getInt("price"));
				itemDto.setUnit(resultSet.getString("unit"));
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		}
		return itemDto;
	}

	@Override
	public Collection<ItemDTO> findAll() {
		List<ItemDTO> items = null;
		try {
			Connection connection = DBHelper.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item_master");
			items = new ArrayList<>();
			
			while (resultSet.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItemID(resultSet.getInt("item_id"));
				dto.setDescription(resultSet.getString("description"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setUnit(resultSet.getString("unit"));
				items.add(dto);
			}
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		}
		return items;
	}

	@Override
	public ItemDTO updateItem(ItemDTO itemDto) {
		ItemDTO updatedItemDto = null;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from item_master where item_id=?");
			int itemID = itemDto.getItemID();
			preparedStatement.setInt(1, itemID);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				preparedStatement = connection.prepareStatement("update item_master set description=?, price=?, unit=? where item_id=?");
				preparedStatement.setString(1, itemDto.getDescription());
				preparedStatement.setDouble(2, itemDto.getPrice());
				preparedStatement.setString(3, itemDto.getUnit());
				preparedStatement.setInt(4, itemID);
				if(preparedStatement.executeUpdate() == 1) {
					updatedItemDto = new ItemDTO(itemDto);
				}
			}
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		} finally {
			DBHelper.closeConnection(null);
		}
		return updatedItemDto;
	}

	@Override
	public boolean deleteByID(int itemID) {
		int affectedRows = 0;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from item_master where item_id=?");
			preparedStatement.setInt(1, itemID);
			affectedRows = preparedStatement.executeUpdate();
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			DBHelper.closeConnection(exception);
		}
		return affectedRows == 1;
	}

	@Override
	public ItemDTO save(ItemDTO itemDto) {
		ItemDTO savedItemDto = null;
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into item_master(description, price, unit) VALUES(?, ?, ?) returning item_id");
			preparedStatement.setString(1, itemDto.getDescription());
			preparedStatement.setInt(2, itemDto.getPrice());
			preparedStatement.setString(3, itemDto.getUnit());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				savedItemDto = new ItemDTO(itemDto);
				savedItemDto.setItemID(resultSet.getInt(1));
			}
			savedItemDto = new ItemDTO(itemDto);
			DBHelper.closeConnection(null);
		} catch (Exception exception) {
			exception.printStackTrace();
			DBHelper.closeConnection(exception);
		}
		return savedItemDto;
	}

}
