package exercise_9.dto;

import java.io.Serializable;
import java.util.Date;

public class InvoiceDTO implements Comparable<InvoiceDTO>,Serializable {
	
	private static final long serialVersionUID = -838961596762804221L;
	private Integer invoiceNumber, customerID;
	private Date invoiceDate;
	
	public InvoiceDTO() {}
	
	public InvoiceDTO(int invoiceNo, int customerID, Date invoiceDate) {
		this.invoiceDate = invoiceDate;
		this.customerID = customerID;
		this.invoiceNumber = invoiceNo;
	}
	
	public InvoiceDTO(InvoiceDTO invoiceDto) {
		this.invoiceDate = invoiceDto.getInvoiceDate();
		this.invoiceNumber = invoiceDto.getInvoiceNumber();
		this.customerID = invoiceDto.getCustomerID();
	}

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [invoiceNumber=" + invoiceNumber + ", customerID=" + customerID + ", invoiceDate="
				+ invoiceDate + "]";
	}

	@Override
	public int compareTo(InvoiceDTO otherDTO) {
		return this.getInvoiceNumber().compareTo(otherDTO.getInvoiceNumber());
	}

}

/*
 * Invoice Table
 * 
 * CREATE TABLE invoice_master(invoice_no SERIAL, invoice_date DATE, customer_id);
 * ALTER TABLE invoice_master ADD PRIMARY KEY (invoice_no);
 * 
 */

