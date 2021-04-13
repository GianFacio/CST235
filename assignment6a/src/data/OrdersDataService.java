package data;

import beans.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrdersDataService
 */
@Stateless
@Local(OrdersDataInterface.class)
@LocalBean
public class OrdersDataService implements OrdersDataInterface {
    public OrdersDataService() 
    {

    }
    
    public void delete(Order order) 
    {

    }
    
	/**
     * @see OrdersDataInterface#save(Order)
     */
    public void save(Order order) {
    	Connection conn = OrdersDataInterface.getConnection();
		try {
			String query = "INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, order.getOrderNumber());
			ps.setString(2, order.getProductName());
			ps.setFloat(3, order.getPrice());
			ps.setFloat(4,  order.getQuantity());
			
			int rows = ps.executeUpdate();
			if(rows < 1) {
				System.out.println("Could not save order!");
			}
			else {
				System.out.println("Saved order!");
			}
			
			ps.close();
		}
		catch(SQLException ex) {
			System.out.println("Could not add new order: " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
    	
    }

	/**
     * @see OrdersDataInterface#get(String)
     */
    public Order get(String orderNumber) {
        // TODO Auto-generated method stub
			return null;
    }

	/**
     * @see OrdersDataInterface#update(String, Order)
     */
    public void update(String orderNumber, Order order) 
    {
    }

	/**
     * @see OrdersDataInterface#getAll()
     */
    public List<Order> getAll() {
    	Connection conn = OrdersDataInterface.getConnection();
    	List<Order> list = new ArrayList<Order>();
    	try {
				String query = "SELECT * FROM testapp.Orders";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					System.out.println(rs.getInt("ORDER_NO"));
					System.out.println(rs.getString("PRODUCT_NAME"));
					System.out.println(rs.getFloat("PRICE"));
					System.out.println("======");
					list.add(new Order(String.valueOf(rs.getInt("ORDER_NO")), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getFloat("QUANTITY")));
				}
				rs.close();
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
    	return list;
    }

}