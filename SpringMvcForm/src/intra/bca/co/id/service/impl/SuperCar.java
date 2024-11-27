package intra.bca.co.id.service.impl;

import org.hibernate.validator.constraints.NotBlank;

import intra.bca.co.id.service.Vehicle;

public class SuperCar implements Vehicle {
	@NotBlank(message = "\"Brand\" must not be blank.")
	private String brand; 
	
	private String type;
	private String engine;
	private Transmission transmission; 
	private Fuel fuel;
	private boolean available;
	private String motion;

	/*
	beberapa contoh metode validasi yang bisa dilakukan di spring
	disebut juga annotation-based validation
	@NotNull
	atau
	@NotNull @Range (min = 1, max = 99)
	@Size(max = 40)
	private String lastName;
	
	@Size(min = 10, max = 30)
	private String firstName;
	
	@NotEmpty @Email
	private String email;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull @Past
	private Date birthday;
	
	@Phone
	private String phone;
	*/
	

	public SuperCar(String brand, String type, String engine, Transmission transmission, Fuel fuel, boolean available) {
		this.brand = brand;
		this.type = type;
		this.engine = engine;
		this.transmission = transmission;
		this.fuel = fuel;
		this.available = available;
	}

	public SuperCar() {
		brand = "";
		type = "";
		engine = "";
		transmission = null;
		fuel = null;
		available = false;
	}
	
	public enum Fuel {
		GASOLINE, DIESEL, LPG, HYBRID
	}
	
	public enum Transmission {
		AUTOMATIC, MANUAL
	}
	
	@Override
	public String move() {
		return motion;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getMotion() {
		return motion;
	}

	public void setMotion(String motion) {
		this.motion = motion;
	}

	@Override
	public String toString() {
		return "SuperCar [brand=" + brand + 
				", type=" + type + 
				", engine=" + engine + 
				", transmission=" + transmission + 
				", fuel=" + fuel + 
				", available=" + available + "]";
	}
	
	
	
}
