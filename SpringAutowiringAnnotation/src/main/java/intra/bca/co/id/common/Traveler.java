package intra.bca.co.id.common;

import org.springframework.beans.factory.annotation.Autowired;

public class Traveler {
	//pilih salah satu tipe saja
	//autowired pada field
	//required=false hanya diperlukan pada saat autowiring dilakukan pada field. Hal ini untuk mencegah Spring memberikan pesan exception apabila bean yang dimaksud tidak ditemukan. Proses pemeriksaan bean tersebut dinamakan dependency checking. dengan ini, variabel ini dapat berisi suatu value sebuah bean ataupun NULL apabila bean yang dimaksud tidak ditemukan 
	@Autowired(required=false)
	//perlu diingat bahwa autowiring dengan annotation ini menggunakan konsep autowiring bytype, jadi dia akan melihat bean dengan tipe class yang sesuai. Apabila terdapat lebih dari 2 bean yang berasal dari class yang sama, maka hasil injection pun tidak dapat diprediksi, untuk mengatasinya, kita bisa menggunakan @Qualifier
	//@Qualifier berfungsi untuk memberitahu bean yang harus dimasukan ke variabel ini, apabila terdapat lebih dari 1 bean yang berasal dari class yang sama. 
	//Pemilihan ini tergantung dari posisi peletakkan QUalifier. Apabila diletakkan pada field, maka ia hanya akan mengatur yang di field saja. APabila diletakkan pada constructor, maka ia mengatur injection pada constructor, dst
	//disini, kita memaksa Spring untuk inject bean dengan id "car" ke variable car apabila dilakukan Autowiring
	//@Qualifier("car")
	private Vehicle car;
	private String origin;
	private String destination;
	
	public Traveler() {
		origin = "";
		destination = "";
	}
	
	//autowired pada constructor
	//@Autowired
	public Traveler(Vehicle car) {
		System.out.println("***** Constructor is called *****");
		this.car = car;
	}

	public Vehicle getCar() {
		return car;
	}

	//autowired pada setter
	//@Autowired
	public void setCar(Vehicle car) {
		this.car = car;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Traveler [origin=" + origin + ", destination=" + destination + "]";
	}
	
	public void showCar() {
		System.out.println(car);
	}
	
	public void startJourney() {
		car.move();
	}
}
