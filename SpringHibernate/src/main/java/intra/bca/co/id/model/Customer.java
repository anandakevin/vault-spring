package intra.bca.co.id.model;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int custId; 
	private String fullname;
	private String address;
	private String email;
	
	public Customer() {
		super();
	}
	
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
	
	@Override
	public String toString() {
		return custId + " | " + fullname + " | " + address + " | " + email;
	}
}
