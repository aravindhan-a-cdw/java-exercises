package exercise_9.dto;

import java.util.Objects;

public class InvoiceTransactionDTO {

	private Integer invoice_no, item_no, item_quantity;
	
	public Integer getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(Integer invoice_no) {
		this.invoice_no = invoice_no;
	}

	public Integer getItem_no() {
		return item_no;
	}

	public void setItem_no(Integer item_no) {
		this.item_no = item_no;
	}

	public Integer getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(Integer item_quantity) {
		this.item_quantity = item_quantity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(invoice_no, item_no, item_quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTransactionDTO other = (InvoiceTransactionDTO) obj;
		return Objects.equals(invoice_no, other.invoice_no) && Objects.equals(item_no, other.item_no)
				&& Objects.equals(item_quantity, other.item_quantity);
	}
	
	@Override
	public String toString() {
		return "InvoiceTransactionDTO [invoice_no=" + invoice_no + ", item_no=" + item_no + ", item_quantity="
				+ item_quantity + "]";
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


