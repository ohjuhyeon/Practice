package org.kh.product.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.kh.product.model.vo.Product;

public class ProductDao {

	public ProductDao() {
	}

	public ArrayList<Product> selectlist() {

		ArrayList<Product> list = new ArrayList<Product>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM PRODUCT";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PRODUCT", "PRODUCT");

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				Product product = new Product();
				product.setProductId(rset.getString("product_id"));
				product.setpName(rset.getString("P_name"));
				product.setPrice(rset.getInt("price"));
				product.setDescription(rset.getString("description"));
				list.add(product);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public Product selectOne(String inputProductName) {

		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM PRODUCT WHERE P_NAME = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PRODUCT", "PRODUCT");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputProductName);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				product = new Product();
				product.setProductId(rset.getString("product_id"));
				product.setpName(rset.getString("P_name"));
				product.setPrice(rset.getInt("price"));
				product.setDescription(rset.getString("description"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return product;
	}

	public void insertProduct(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO PRODUCT VALUES(?,?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PRODUCT", "PRODUCT");
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, product.getProductId());
			pstmt.setString(2, product.getpName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			result = pstmt.executeUpdate();
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void updateProduct(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "UPDATE PRODUCT SET P_NAME = ? , PRICE = ? , DESCRIPTION = ? WHERE PRODUCT_ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PRODUCT", "PRODUCT");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product.getpName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getDescription());
			pstmt.setString(4, product.getProductId());
			result = pstmt.executeUpdate();
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void deleteProduct(String inputDelete) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PRODUCT", "PRODUCT");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputDelete);

			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
