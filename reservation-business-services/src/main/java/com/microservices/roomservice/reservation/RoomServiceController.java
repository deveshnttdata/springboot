package com.microservices.roomservice.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.roomservice.reservation.domain.Room;

@RestController
public class RoomServiceController {

	@Autowired
	private RestTemplate restTemplate;
	
	/*@Autowired
	private RoomService roomService;*/
	
	@RequestMapping(value ="/rooms", method = RequestMethod.GET)
	public List<Room> getAllRooms(){
		
		//Using RestTemplate
		ResponseEntity<List<Room>> response = restTemplate.exchange("http://ROOMSERVICES/rooms",HttpMethod.GET, null,
												new ParameterizedTypeReference<List<Room>>(){});
		if(response.getStatusCode()==HttpStatus.OK){
			return response.getBody();
		}
		
		return new ArrayList<Room>();
		
		//Using Feign Client
		//return this.roomService.findAll(null);
		
	}
}
