package models.business;

import interfaces.NoAble;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.Client;
import models.BaseModel;
import play.data.validation.Required;
import util.StringUtil;

@Entity
@Table(name = "invoice")
public class Invoice extends BaseModel implements NoAble {
	public static String INVOICE_STATUS_ADJUST = "Adjust";
	public static String INVOICE_STATUS_SENT = "Sent";

	@Required
	public String invoiceNo;
	@Required
	@ManyToOne
	public Client client;

	public String clientName;

	public String contacts;

	public String phone;
	public String directLine;
	public String address;
	public String remark;
	public String status;

	public Invoice() {
		super();
	}

	public String toString() {
		return "Invoice(" + invoiceNo + ")";
	}

	@Override
	public String genNo() {
		Integer maxNo = getMaxNo();
		maxNo += 1;
		return maxNo.toString();
	}

	@Override
	public Integer getMaxNo() {
		Invoice invoice = Invoice.find("order by invoiceNo desc").first();
		return StringUtil.toInteger(invoice.invoiceNo, 1);
	}
}
