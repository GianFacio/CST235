package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
	private List<Order> orders; 
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
    	this.orders = new ArrayList<Order>();
    	orders.add(new Order("000000001", "This is Product 1", 1.00f, 1));
		orders.add(new Order("000000002", "This is Product 2", 2.00f, 2));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("Hello from the OrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}