package exercise_9.dto;

import java.io.Serializable;


public class ItemDTO implements Comparable<ItemDTO>, Serializable{

	private static final long serialVersionUID = -5328436508058065837L;
	private Integer itemID, price;
	private String description;
	private String unit;
	
	public ItemDTO() {}

	public ItemDTO(int itemID, String description, int price, String unit) {
		this.itemID = itemID;
		this.price = price;
		this.description = description;
		this.unit = unit;
	}
	
	public ItemDTO(ItemDTO itemDto) {
		this.itemID = itemDto.getItemID();
		this.price = itemDto.getPrice();
		this.description = itemDto.getDescription();
		this.unit = itemDto.getUnit();
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
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
	public int compareTo(ItemDTO otherItemDTO) {
		return this.itemID.compareTo(otherItemDTO.getItemID());
	}

	@Override
	public String toString() {
		return "ItemDTO [itemID=" + itemID + ", price=" + price + ", description=" + description + ", unit=" + unit
				+ "]";
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



