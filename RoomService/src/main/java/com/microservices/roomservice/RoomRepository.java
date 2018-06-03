package com.microservices.roomservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

	public Room findByRoomNumber(String roomNumber);
}
