package intra.bca.co.id.common;

public class HelloWorld implements Hello {
	private String message;
	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	public void printMessage() {
		System.out.println("Your message: " + message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
