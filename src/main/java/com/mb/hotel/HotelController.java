package com.mb.hotel;

//import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.web.bind.annotation.*;

import com.mb.hotel.vo.Hotel;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = hotelService.getAll();
        return hotels;
    }

    @PutMapping
    public void insertHotel(@RequestBody Hotel hotel){
        this.hotelService.insertHotel(hotel);
    }
    
    @PostMapping
    public void update(@RequestBody Hotel hotel){
        this.hotelService.updateHotel(hotel);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id){
        Hotel hotel = this.hotelService.getById(id);
        return hotel;
    }
    
    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        List<Hotel> hotels = this.hotelService.getByPricePerNight(maxPrice);
        return hotels;
    }
    
    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels = this.hotelService.getByCity(city);
        return hotels;
    }
    
    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        // create a query class (QHotel)
        //QHotel qHotel = new QHotel("hotel");
        // using the query class we can create the filters
        //BooleanExpression filterByCountry = qHotel.address.country.eq(country);

        // we can then pass the filters to the findAll() method
        List<Hotel> hotels = this.hotelService.getByCountry(country);
        return hotels;
    }
/*
    @GetMapping("/recommended")
    public List<Hotel> getRecommended(){
        final int maxPrice = 100;
        final int minRating = 7;

        // create a query class (QHotel)
        QHotel qHotel = new QHotel("hotel");

        // using the query class we can create the filters
        BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);

        // we can then pass the filters to the findAll() method
        List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByPrice.and(filterByRating));

        return hotels;
    }
   */
}
