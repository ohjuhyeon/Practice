package org.kh.product.controller;

import java.util.ArrayList;

import org.kh.product.model.dao.ProductDao;
import org.kh.product.model.vo.Product;
import org.kh.product.view.ProductMenu;


public class ProductController {

	public void Allproduct() {

		ProductMenu menu = new ProductMenu();
		ArrayList<Product> list = new ProductDao().selectlist();
		if (list != null) menu.displayProductList(list);
		else menu.displayProductError();
	}

	public void productSearchtoName(String inputProductName) {

		ProductMenu menu = new ProductMenu();
		Product product = new ProductDao().selectOne(inputProductName);
		menu.displayProduct(product);

	}

	public void insertProduct(Product inputProduct) {
		ProductMenu menu = new ProductMenu();
		new ProductDao().insertProduct(inputProduct);

	}

	public void updateProduct(Product modifyProduct) {
		new ProductDao().updateProduct(modifyProduct);
		
	}

	public void deleteProduct(String inputDelete) {
		new ProductDao().deleteProduct(inputDelete);
		
	}

}
