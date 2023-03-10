package exercise_9.dao;

import java.util.Collection;

import exercise_9.dto.InvoiceDTO;

public abstract class InvoiceDAO {
	public abstract InvoiceDTO find(int invoiceID);
	public abstract InvoiceDTO findByCustomerID(int customerID);
	public abstract Collection<InvoiceDTO> findAll();
	public abstract InvoiceDTO update(InvoiceDTO invoiceDto);
	public abstract boolean delete(int invoiceID);
}
