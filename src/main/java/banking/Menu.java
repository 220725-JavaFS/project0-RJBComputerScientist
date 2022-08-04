package banking;

public class Menu {
	
	private Customer DaCustomer;
	private Admin DaAdmin;
	private Human CurrentHuman;

	public Customer getCurrentCustomer() {
		return DaCustomer;
	}
	
	public void setCurrentCustomer(Customer customer) {
		this.DaCustomer = customer;
	}
	
	public Admin getCurrentAdmin() {
		return DaAdmin;
	}
	
	public void setCurrentAdmin(Admin admin) {
		this.DaAdmin = admin;
	}
	

}
