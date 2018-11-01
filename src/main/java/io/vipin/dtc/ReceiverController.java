package io.vipin.dtc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiverController {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private FavouriteCarRepository carRepository;

	@PostMapping("/sendEmail")
	public String SendEmail(@RequestBody  Email email) {
		System.out.println("Email Received");
		jmsTemplate.convertAndSend("mailbox", email);
		return "Email Transacted Successfully";
	}
	
	@PostMapping("/sendFavouriteCar")
	public String SendFavouriteCar(@RequestBody FavouriteCar car) {
		System.out.println("FavouriteCar Received");
		jmsTemplate.convertAndSend("car", car);
		return "FavouriteCar Transacted Successfully";
	}
	
	@RequestMapping("/getEmail")
	public List<Email> getEmails(){
		List<Email> mails=new ArrayList<>();
		emailRepository.findAll()
		.forEach(mails::add);
		return mails;
	}
	
	@RequestMapping("/getFavouritecar")
	public List<FavouriteCar> getFavouritecars(){
		List<FavouriteCar> cars=new ArrayList<>();
		carRepository.findAll()
		.forEach(cars::add);
		return cars;
	}
	
	@RequestMapping("/getFavouritecar/{id}")
	public FavouriteCar getFavouritecar(@PathVariable String id){
		return carRepository.findById(id).get();
	}
	
	@RequestMapping("/getEmail/{id}")
	public Email getEmail(@PathVariable String id){
		return emailRepository.findById(id).get();
	}
	
}
