package controllers.business;

import java.util.List;

import models.Client;
import models.business.Invoice;
import util.StringUtil;
import controllers.BaseController;
import dwz.DwzMessager;

public class InvoiceAction extends BaseController {
	public static void add() {
		render("business/invoice/invoiceInfo.html");
	}

	public static void info(Long id) {
		Invoice invoice = (Invoice) (id == null ? null : Invoice.findById(id));
		render("business/invoice/invoiceInfo.html", invoice);
	}

	public static void copy(Long id) {
		Invoice invoiceOld = (Invoice) (id == null ? null : Invoice
				.findById(id));
		Invoice invoice = (Invoice) invoiceOld.copy(new Invoice());
		invoice.id = null;
		render("business/invoice/invoiceInfo.html", invoice);
	}

	public static void list() {
		List<Invoice> invoices = Invoice.findAll();
		render("business/invoice/invoiceList.html", invoices);
	}

	public static void save(Invoice invoice) {
		Client client = (Client) new Client().matchObj(invoice.clientName);
		invoice.client = client;
		if (StringUtil.isEmpty(invoice.invoiceNo)) {
			invoice.invoiceNo = invoice.genNo();
		}
		invoice.save();
		renderJSON(DwzMessager.getSuccessAndColseMessager());
	}

	public static void delete(Long id) {
		Invoice invoice = Invoice.findById(id);
		invoice.delete();
		renderJSON(DwzMessager.success);
	}
}
