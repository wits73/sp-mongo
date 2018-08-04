package com.mb.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mb.hotel.vo.Hotel;

@Service
public class HotelService {
	
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> getAll(){
        List<Hotel> hotels = this.hotelRepository.findAll();
        return hotels;
    }
	
	public void insertHotel(Hotel hotel) {
		hotelRepository.insert(hotel);
	}
	
	public void updateHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}
	
	public Hotel getById(String id) {
		return hotelRepository.findOne(id);
	}
	
	public List<Hotel> getByPricePerNight(int maxPrice){
        List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
        return hotels;
    }
	
	public List<Hotel> getByCity(String city){
        List<Hotel> hotels = this.hotelRepository.findByCity(city);
        return hotels;
    }
	
	 public List<Hotel> getByCountry(String country){
        // we can then pass the filters to the findAll() method
        List<Hotel> hotels = this.hotelRepository.findByCountry(country);
        return hotels;
	 }
	
}
