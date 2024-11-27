package intra.bca.co.id.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import intra.bca.co.id.service.impl.SuperCar;

@Controller
public class VehicleController {
	@Autowired
	private SuperCar car;
	
	@RequestMapping(value ="/open-car", method = RequestMethod.GET)
	public String loadFormPage(Model m) {
		m.addAttribute("transmission_enum", SuperCar.Transmission.values());
		m.addAttribute("fuel_enum", SuperCar.Fuel.values());
		m.addAttribute("superCar", this.car); //bean id in spring-service.xml
		return "car-form";
	}
	
	@RequestMapping(value = "/open-car", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute @Valid SuperCar car1, BindingResult result, Model m) {
		m.addAttribute("transmission_enum", SuperCar.Transmission.values());
		m.addAttribute("fuel_enum", SuperCar.Fuel.values());
		if(!result.hasErrors()) m.addAttribute("message", "Successfully saved vehicle: " + car1.toString());
		return "car-form";
	}
	
}
