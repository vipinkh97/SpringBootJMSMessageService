package io.vipin.dtc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	FavouriteCarRepository favouritecarRepository;

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
        emailRepository.save((email));
    }
    
    @JmsListener(destination = "car", containerFactory = "myFactory")
    public void receiveMessage1(FavouriteCar car) {
        System.out.println("Received <" + car + ">");
        favouritecarRepository.save((car));
    }


}
