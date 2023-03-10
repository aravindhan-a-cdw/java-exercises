package exercise_9.dto;

import java.util.Date;

public class InvoiceDTO {
	
	private Integer invoice_no, customer_id;
	private Date invoice_date;
	
	public InvoiceDTO() {}
	
	public InvoiceDTO(int invoice_no, int customer_id, Date invoice_date) {
		this.invoice_date = invoice_date;
		this.customer_id = customer_id;
		this.invoice_no = invoice_no;
	}
	
	public Integer getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(Integer invoice_no) {
		this.invoice_no = invoice_no;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Date getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}

}

/*
 * Invoice Table
 * 
 * CREATE TABLE invoice_master(invoice_no SERIAL, invoice_date DATE, customer_id);
 * ALTER TABLE invoice_master ADD PRIMARY KEY (invoice_no);
 * 
 */

