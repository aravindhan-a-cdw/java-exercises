package exercise_9.dto;

import java.util.Objects;

public class InvoiceTransactionDTO {
	
	private Integer invoiceNumber, itemNumber, itemQuantity;

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(invoiceNumber, itemNumber, itemQuantity);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;			
		}
		if (object == null) {
			return false;			
		}
		if (getClass() != object.getClass()) {
			return false;			
		}
		InvoiceTransactionDTO otherObject = (InvoiceTransactionDTO) object;
		return Objects.equals(invoiceNumber, otherObject.invoiceNumber) && Objects.equals(itemNumber, otherObject.itemNumber)
				&& Objects.equals(itemQuantity, otherObject.itemQuantity);
	}
	
	
	
}

/*
 * Invoice Transaction Table
 * 
 *  Create table invoice_transaction(invoice_no INTEGER, item_no INTEGER, item_quantity INTEGER);
 *	ALTER TABLE invoice_transaction ADD PRIMARY KEY (invoice_no, item_no);
 *
 *
 */


