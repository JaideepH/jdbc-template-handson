package com.cts.handson.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.handson.model.Products;

@Repository
public class ProductDAO {

	@Autowired
	private JdbcTemplate jt;
	// Method to retrieve all products from the database
	
	public List<Products> getAllProducts() {
		ResultSetExtractor<List<Products>> rsex = (rs) -> {
			List<Products> allProducts = new ArrayList<>();
			while(rs.next()) {
				Products product = returnProductFromResultSet(rs);
				allProducts.add(product);
			}
			return allProducts;
		};
		return jt.query("select * from products",rsex);
	}

	// Method to retrieve a single product by id from the database
	public Products getProductById(int id) {
		
		RowMapper<Products> rm = (rs,rowNum)-> {
			Products product = returnProductFromResultSet(rs);
        return product;
		};
		
		Products prod = jt.queryForObject("select * from products where id=?", rm, id);
		return prod;
	}

	private Products returnProductFromResultSet(ResultSet rs) throws SQLException {
		Products product=new Products();
		product.setId(Integer.valueOf(rs.getString("id")));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(BigDecimal.valueOf(Double.valueOf(rs.getString("price"))));
		product.setQuantity(Integer.valueOf(rs.getString("quantity")));
		return product;
	}
	// Method to add a new product to the database
	public void addProduct(Products product) {
	// TODO: Implement method
	}
	// Method to update an existing product in the database
	public void updateProduct(Products product) {
	// TODO: Implement method
	}
	// Method to delete a product from the database
	public void deleteProduct(int id) {
	// TODO: Implement method
	}
}
