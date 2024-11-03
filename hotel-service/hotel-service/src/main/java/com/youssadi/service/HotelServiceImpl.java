package com.youssadi.service;

import com.youssadi.clients.LocationFeignClient;
import com.youssadi.dao.HotelRepository;
import com.youssadi.dto.requests.HotelRequest;
import com.youssadi.dto.responses.HotelResponse;
import com.youssadi.dto.responses.LocationResponse;
import com.youssadi.exceptions.ErrorException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.youssadi.domain.Hotel;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("ALL")
@Service

public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CircuitLocationService circuitLocationService;

    Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Override
    public HotelResponse getHotel(long hotelId) {
        logger.info("within hotel service ");
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() ->
                new ErrorException("Hotel not found for id : " + hotelId ));
        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setHotelId(hotel.getHotelId());
        hotelResponse.setName(hotel.getName());
        hotelResponse.setNumberOfStars(hotel.getNumberOfStars());
        hotelResponse.setNumberOfRooms(hotel.getNumberOfRooms());
        hotelResponse.setLocationResponse(circuitLocationService.getLocationById(hotel.getLocationId()));
        return hotelResponse;
    }
    @Override
    public long createHotel(HotelRequest hotelRequest) {
        logger.info("within hotel service ");
        Hotel hotel = new Hotel();
        hotel.setName(hotelRequest.getName());
        hotel.setNumberOfStars(hotelRequest.getNumberOfStars());
        hotel.setNumberOfRooms(hotelRequest.getNumberOfRooms());
        hotel.setLocationId(hotelRequest.getLocationId());
        hotelRepository.save(hotel);
        return hotel.getHotelId();
    }






}
