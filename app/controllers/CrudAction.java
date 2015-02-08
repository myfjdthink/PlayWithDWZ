package controllers;

import java.util.List;

import models.Product;
import dwz.DwzMessager;

public class CrudAction extends BaseController {
	public static void add() {
		render("crud/info.html", null);
	}
	public static void info(Long id) {
		Product product = (Product) (id == null ? null : Product.findById(id));
		render("product/productInfo.html", product);
	}

	public static void list() {
		List<Product> products = Product.findAll();
		render("product/productList.html", products);
	}

	public static void save(Product product) {
		if (product.isAdd()) {
//			if (ProductHelper.hasName(product.productName)) {
//				validation.addError(product.productName, "已经存在名为{0}的用户",
//						product.productName);
//			}
		}
		validation.required(product.productName);
		validation.required(product.color);
		validation.required(product.fullUnit);
		validation.required(product.size);
		if (validation.hasErrors()) {
			renderJSON(DwzMessager.getErrorMessager(validation.errors()));
		}
		product.save();
		renderJSON(DwzMessager.getSuccessAndColseMessager());
	}

	public static void delete(Long id) {
		Product product = Product.findById(id);
		product.delete();
		renderJSON(DwzMessager.success);
	}

	public static void hasName(Product product) {
		renderJSON("true");
//		if (ProductHelper.hasName(product.productName)) {
//			renderJSON("false");
//		} else {
//			renderJSON("true");
//		}
	}
}
