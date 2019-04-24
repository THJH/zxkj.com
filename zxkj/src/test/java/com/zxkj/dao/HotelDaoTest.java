package com.zxkj.dao;

import com.zxkj.entity.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelDaoTest {

    @Autowired
    private HotelDao hotelDao;

    @Test
    public void insert() {
        for (int i = 1; i < 50; i++) {
            Hotel hotel = new Hotel();
            hotel.setName("name_"+i);
            hotel.setType(i%120);
            hotel.setStar(i%5+1);
            hotel.setUrl("https://www.baidu.com");
            hotel.setLogo("cxy.jpg");
            hotel.setDistrictId(i%120);
            hotel.setStreet("street_"+i);
            hotel.setAddress("address_"+i);
            hotel.setLongitude((float) i);
            hotel.setLatitude((float) i);
            hotel.setIntroduction("intro_"+i);
            hotel.setState(i%4);
            hotel.setOpenTime(LocalDateTime.now());
            hotel.setRenovationTime(LocalDateTime.now());
            hotel.setTels("{\"qianTai1\":\"1111\",\"qianTai3\":\"1112\",\"qianTai3\":\"1113\",\"caiWu\":\"2222\"}");
            hotel.setRate(3.2f);
            hotel.setServiceRate(3.2f);
            hotel.setHygieneRate(3.2f);
            hotel.setPositionRate(3.2f);
            hotel.setDeviceRate(3.2f);
            hotel.setDeposit(888);
            hotel.setStartTime(LocalDateTime.now());
            hotel.setEndTime(LocalDateTime.now());
            hotel.setCheckoutTime(LocalDateTime.now());
            hotel.setWeekend("[3,4,5]");
            hotel.setHourlyEndTime(LocalDateTime.now());
            hotel.setHourlyEndTime(LocalDateTime.now());
            hotel.setCreateTime(LocalDateTime.now());
            hotel.setUpdateTime(LocalDateTime.now());
            hotel.setInfo("info_"+i);

            int insert = hotelDao.insert(hotel);
            System.out.println(insert);
        }
    }
}