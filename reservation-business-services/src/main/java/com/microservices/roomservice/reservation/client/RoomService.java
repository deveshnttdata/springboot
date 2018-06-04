package com.microservices.roomservice.reservation.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.roomservice.reservation.domain.Room;

@FeignClient(value="ROOMSERVICES")
public interface RoomService {

	@RequestMapping(value="/rooms", method = RequestMethod.GET)
	public List<Room> findAll(@RequestParam(name="roomNumber", required=false) String roomNumber);
}
