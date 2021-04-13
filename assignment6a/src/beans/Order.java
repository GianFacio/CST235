package beans;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Order")
@ManagedBean
@ViewScoped
public class Order implements Serializable 
{
	private static final long serialVersionUID = 1L;
	public String OrderNumber = "";
	public String ProductName = "";
	public float Price = 0;
	public float Quantity = 0;
	
	public Order(String orderNumber, String productName, float price, float quantity) 
	{
		Objects.requireNonNull(orderNumber);
		Objects.requireNonNull(productName);
	    Objects.requireNonNull(price);
	    Objects.requireNonNull(quantity);
	    
		this.OrderNumber = orderNumber;
		this.ProductName = productName;
		this.Price = price;
		this.Quantity = quantity;
		
	}
	
	public String getOrderNumber() {
		return OrderNumber;
	}
	
	public void setOrderNumber(String orderNumber) {
		this.OrderNumber = orderNumber;
	}

	public String getProductName() {
		return ProductName;
	}
	
	public void setProductName(String productName) {
		this.ProductName = productName;
	}
	
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		this.Price = price;
	}
	
	public float getQuantity() {
		return Quantity;
	}
	public void setQuantity(float quantity) {
		this.Quantity = quantity;
	}

}