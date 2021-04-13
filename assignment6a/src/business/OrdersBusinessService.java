package business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Connection;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.ConnectionFactory;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
	private List<Order> orders; 
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
    	this.orders = new ArrayList<Order>();
    //	orders.add(new Order("000000001", "This is Product 1", 1.00f, 1));
	//	orders.add(new Order("000000002", "This is Product 2", 2.00f, 2));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	//System.out.println("Hello from the OrdersBusinessService");
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
	
	public void sendOrder(Order order) {
		System.out.println("Queue: " + queue.toString());
		// Send a Message for an Order
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject(order);
			messageProducer.send(message2);
			
			connection.close();
		} catch (JMSException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

}
	}