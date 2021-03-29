package business;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import beans.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	private List<Order> orders;
    public AnotherOrdersBusinessService() {
    	orders.add(new Order("000000001", "This is Product 1", 1.00f, 1));
		orders.add(new Order("000000002", "This is Product 2", 2.00f, 2));
		orders.add(new Order("000000003", "This is Product 3", 3.00f, 3));
		orders.add(new Order("000000004", "This is Product 4", 4.00f, 4));
		orders.add(new Order("000000005", "This is Product 5", 5.00f, 5));
		orders.add(new Order("000000006", "This is Product 6", 6.00f, 6));
		orders.add(new Order("000000007", "This is Product 7", 7.00f, 7));
		orders.add(new Order("000000008", "This is Product 8", 8.00f, 8));
		orders.add(new Order("000000009", "This is Product 9", 9.00f, 9));
		orders.add(new Order("0000000010", "This is Product 10", 10.00f, 10));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
       // System.out.println("Hello from the AnotherOrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
		
	}

}
