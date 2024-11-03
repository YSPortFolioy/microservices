package com.youssadi.service;

import com.youssadi.domain.Hotel;
import com.youssadi.dto.requests.HotelRequest;
import com.youssadi.dto.responses.HotelResponse;

public interface HotelService {
    public long createHotel(HotelRequest hotelRequest);
    public HotelResponse getHotel(long hotelId);
}
