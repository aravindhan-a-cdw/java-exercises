package exercise_9.dao;

import java.util.Collection;

import exercise_9.dto.ItemDTO;

public abstract class ItemDAO {
	public abstract ItemDTO find(int itemID);
	public abstract ItemDTO save(ItemDTO itemDto);
	public abstract Collection<ItemDTO> findAll();
	public abstract ItemDTO updateItem(ItemDTO itemDto);
	public abstract boolean deleteByID(int itemID);
}
