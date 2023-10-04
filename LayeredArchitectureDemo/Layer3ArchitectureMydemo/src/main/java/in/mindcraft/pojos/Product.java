package in.mindcraft.pojos;

public class Product {
//product no, product name, product price, quantity, discount
	private int pid;
	private String name;
	private double price;
	private int qty;
	private double discount;
	
	
	public Product() {
		
	}
	
	public Product(int pid, String name, double price, int qty, double discount) {
		//super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.discount = discount;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return " Product [pid=" + pid + ", name=" + name + ", price=" + price + ", qty=" + qty + ", discount=" + discount
				+ "\n] ";
	}
	
	
	
	
}
