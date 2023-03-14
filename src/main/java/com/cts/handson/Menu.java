package com.cts.handson;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.handson.dao.ProductDAO;
import com.cts.handson.model.Products;

@Component
public class Menu {
	@Autowired
	private ProductDAO productDAO;
	private Scanner scanner;

	public Menu() {
		scanner = new Scanner(System.in);
	}

	public void displayMenu() {
		System.out.println("\n1. Display all products");
		System.out.println("2. Display a single product by id");
		System.out.println("3. Add a new product");
		System.out.println("4. Update an existing product");
		System.out.println("5. Delete a product");
		System.out.println("6. Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			displayAllProducts();
			break;
		case 2:
			displayProductById();
			break;
		case 3:
			addProduct();
			break;
		case 4:
			updateProduct();
			break;
		case 5:
			deleteProduct();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		displayMenu();
	}

	private void displayAllProducts() {
		List<Products> products = productDAO.getAllProducts();
		System.out.println("\n Product Details:"+"\n");
		products.stream().forEach(p -> System.out.println(p));
	}

	private void displayProductById() {
		System.out.println("\nEnter Id: \n");
		int id = scanner.nextInt();
		Products productById = productDAO.getProductById(id);
		System.out.println("\n Product Details: "+productById + "\n");
	}

	private void addProduct() {
// TODO: Implement method
	}

	private void updateProduct() {
// TODO: Implement method
	}

	private void deleteProduct() {
// TODO: Implement method
	}
}
