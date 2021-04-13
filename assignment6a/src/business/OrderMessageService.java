package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import data.OrdersDataService;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/Order"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {
	@EJB
	OrdersDataService service;
	public OrderMessageService() 
	{

	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		try {
			if (message != null) {
				System.out.println("RECEIVED MESSAGE: "
						+ (message instanceof TextMessage ? ((TextMessage) message).getText() : ""));
				if (message instanceof ObjectMessage) {
					ObjectMessage mapMessage = (ObjectMessage) message;
					Order order = (Order) mapMessage.getObject();
					System.out.println(order.toString());
					service.save(order);
				}
			}
		} catch (JMSException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}