package com.springboot.service.guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Devesh Singh on 05/05/18.
 */
@Repository
public interface GuestRepository extends CrudRepository<Guest, Long>{
    Guest findByEmailAddress(String emailAddress);
}
