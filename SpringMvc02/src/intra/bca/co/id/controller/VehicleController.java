package intra.bca.co.id.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import intra.bca.co.id.service.Vehicle;

@Controller
public class VehicleController {
	
	@Autowired
	private Vehicle car;
	
	@RequestMapping("/showcar")
	public ModelAndView showCar() {
		return new ModelAndView("welcome", "message", car.toString());
		//open welcome.jsp and pass the message
	}
	
	@RequestMapping("/showmove")
	public ModelAndView showMove() {
		return new ModelAndView("welcome", "message", car.move());
		//open welcome.jsp and pass the message
	}
}
