package exercise_9.dao;

import java.util.Collection;

import exercise_9.dto.ItemDTO;

public abstract class ItemDAO {
	public abstract ItemDTO findByID(int item_id);
	public abstract void save(ItemDTO newItem);
	public abstract Collection<ItemDTO> findAll();
	public abstract int updateItem(ItemDTO newItem);
	public abstract int deleteByID(int item_id);
}
