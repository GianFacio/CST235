package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController 
{
	@Inject
	OrdersBusinessInterface service;
	
	@Inject
	private MyTimerService timer;
	
	
	public String onSubmit(User user) 
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.getExternalContext().getRequestMap().put("user", user);
		service.test();
		
		timer.setTimer(5000);
		getAllOrders();
		insertOrder();
		getAllOrders();
		return "TestResponse.xhtml";
	}
	
	public OrdersBusinessInterface getService() 
	{
		return service;
	}
	
	private void getAllOrders() {
		Connection conn = null;
		try {
			conn  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			if(!conn.isClosed()) {
				System.out.println("Success!!");
				String query = "SELECT * FROM testapp.Orders";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					System.out.println(rs.getInt("ID"));
					System.out.println(rs.getString("PRODUCT_NAME"));
					System.out.println(rs.getFloat("PRICE"));
					System.out.println("------------------");
				}
				rs.close();
			}
			conn.close();
		} catch(SQLException e) {
			System.out.println("Failure!!");
			System.out.println(e.getMessage());
		} finally {
			 if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
		}
	}
	
	private void insertOrder() {
		String update = "INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('001122334455', 'This was inserted new', 25.00, 100)";
		Connection conn = null;
		try {
			conn  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			if(!conn.isClosed()) {
				Statement stmt = conn.createStatement();
				int result = stmt.executeUpdate(update);
				System.out.println("Insert result: " + result);
			}
			conn.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			 	if (conn != null) {
	            try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
		}
	}
	public String onSendOrder() {
	service.sendOrder(new Order("342", "Hammer Drill", 34.3f, 234.55f));
	return "OrderResponse.xhtml";
}
	
}

