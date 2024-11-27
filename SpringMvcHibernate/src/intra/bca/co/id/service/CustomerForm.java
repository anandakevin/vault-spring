package intra.bca.co.id.service;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class CustomerForm {
	@NotNull
	@Range(min = 1, max = 1000, message = "\"Customer ID\" tidak valid")
	private int custId;
	
	@NotBlank (message = "\"Full Name\" harus diisi")
	private String fullname;
	
	@NotBlank (message = "\"Address\" harus diisi")
	private String address;
	
	@NotEmpty (message = "\"Email\" harus diisi")
	@Email (message = "Format email tidak valid")
	private String email;
	
	private String flag;
	public CustomerForm () {
		super();
	}
	public CustomerForm(@NotNull @Range(min = 1, max = 1000) int custId, @NotBlank String fullname,
			@NotBlank String address, @NotEmpty String email) {
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
