package intra.bca.co.id.model;

public class Customer {
	private int custId; 
	private String fullname;
	private String address;
	private String email;
	
	public Customer(int custId, String fullname, String address, String email) {
		super();
		this.custId = custId;
		this.fullname = fullname;
		this.address = address;
		this.email = email;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
