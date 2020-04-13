package org.kh.product.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.kh.product.controller.ProductController;
import org.kh.product.model.vo.Product;

public class ProductMenu {

	Scanner sc;
	ProductController pc;

	public ProductMenu() {

		sc = new Scanner(System.in);
		pc = new ProductController();

	}

	public void menu() {
		int select = 99;

		while (true) {
			System.out.println(" 상품 관리 프로그램");
			System.out.println(" 1. 상품 전체 조회");
			System.out.println(" 2. 제픔 이름으로 검색");
			System.out.println(" 3. 제품 정보 등록 ");
			System.out.println(" 4. 제품 정보 수정");
			System.out.println(" 5. 제품 정보 삭제");
			System.out.println(" 0. 프로그램 종료");
			System.out.print(" 선택 ");

			select = sc.nextInt();
			switch (select) {
			case 1:
				pc.Allproduct();
				break;
			case 2:
				pc.productSearchtoName(this.inputProductName());
				break;
			case 3:
				pc.insertProduct(this.inputProduct());
				break;
			case 4:
				pc.updateProduct(this.modifyProduct());
				break;
			case 5:
				pc.deleteProduct(this.inputDeleteProduct());
				break;
			case 0:
				System.out.println("프로그램을 종료합니다. ");
				return;
			default:
				System.out.println("잘못 눌렀습니다");
			}
		}
	}

	private String inputProductName() {
		System.out.println("찾으실 상품명을 입력해주세요");
		return sc.next();
	}

	private Product inputProduct() {
		Product product = new Product();

		System.out.print("제품 ID");
		product.setProductId(sc.next());

		System.out.print("제품 이름");
		product.setpName(sc.next());

		System.out.print("가격");
		product.setPrice(sc.nextInt());

		System.out.print("설명");
		product.setDescription(sc.next());

		return product;

	}

	private Product modifyProduct() {
		Product product = new Product();
		System.out.print("수정할 상품 ID를 입력해주세요");
		product.setProductId(sc.next());

		System.out.print("상품 이름 ");
		product.setpName(sc.next());

		System.out.print("상품 가격");
		product.setPrice(sc.nextInt());

		System.out.print("설명");
		product.setDescription(sc.next());

		return product;
	}

	private String inputDeleteProduct() {
		System.out.print("지울 ID를 입력해주세요");
		return sc.next();
	}

	public void displayProductList(ArrayList<Product> list) {
		System.out.println("상품ID , 상품이름 , 가격 , 설명");
		System.out.println("====================================");
		for (Product product : list) {
			System.out.println(product.toString());
		}
	}

	public void displayProduct(Product product) {

		System.out.println("상품ID , 상품이름 , 가격 , 설명");
		System.out.println("====================================");
		System.out.println(product.toString());
	}

	public void displayProductError() {

		System.out.println("데이터가 없습니다~");

	}
}
