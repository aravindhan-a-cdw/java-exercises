package exercise_9.dao;

import java.util.Collection;

import exercise_9.dto.InvoiceDTO;

public abstract class InvoiceDAO {
	public abstract InvoiceDTO findByInvoiceID(int inv_id);
	public abstract InvoiceDTO findByCustomerID(int cus_id);
	public abstract Collection<InvoiceDTO> findAll();
	public abstract int updateInvoice(InvoiceDTO newInvoice);
	public abstract int deleteInvoiceByID(int inv_id);
}
