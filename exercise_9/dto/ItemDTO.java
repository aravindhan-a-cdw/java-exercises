package exercise_9.dto;

import java.io.Serializable;


public class ItemDTO  implements Comparable<ItemDTO>,Serializable{

	private static final long serialVersionUID = -931260797917878872L;
	private Integer item_id, price;
	private String description;
	private String unit;
	
	public ItemDTO() {}

	public ItemDTO(int item_id, String description, int price, String unit) {
		this.item_id = item_id;
		this.price = price;
		this.description = description;
		this.unit = unit;
	}
	
	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public int compareTo(ItemDTO o) {
		return this.item_id.compareTo(o.getItem_id());
	}
}


/*
 * ITEM Table
 * 
 * CREATE TABLE item_master(item_id SERIAL, description TEXT, price NUMERIC(8,2), unit VARCHAR(10));
 * ALTER TABLE item_master ADD PRIMARY KEY (item_id);
 * 
 * 
 */



