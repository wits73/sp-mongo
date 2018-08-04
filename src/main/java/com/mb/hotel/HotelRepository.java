package com.mb.hotel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mb.hotel.vo.Hotel;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String>{

      List<Hotel> findByPricePerNightLessThan(int maxPrice);

      @Query(value = "{address.city:?0}")
      List<Hotel> findByCity(String city);
      
      @Query(value = "{address.country:?0}")
      List<Hotel> findByCountry(String country);
}
