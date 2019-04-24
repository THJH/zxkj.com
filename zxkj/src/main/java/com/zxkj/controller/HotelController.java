package com.zxkj.controller;


import com.alibaba.druid.sql.visitor.functions.Substring;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.deploy.net.HttpResponse;
import com.zxkj.bean.GlobalConst;
import com.zxkj.bean.PageBean;
import com.zxkj.entity.City;
import com.zxkj.entity.District;
import com.zxkj.entity.Hotel;
import com.zxkj.entity.Province;
import com.zxkj.service.CityService;
import com.zxkj.service.DistrictService;
import com.zxkj.service.HotelService;
import com.zxkj.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>
 * 酒店表 前端控制器
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private DistrictService districtService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/list/{pageNum}")
    public String list(@PathVariable("pageNum") Integer pageNum, Model model) {
        PageBean<Hotel> pageBean = new PageBean<>();

        if (pageNum == null)
            pageNum = 1;
        IPage<Hotel> page = hotelService.page(new Page<>(pageNum, GlobalConst.PAGE_SIZE));

        StringBuffer sb = new StringBuffer();
        List<Hotel> hotelList = page.getRecords();
        pageBean.setRecords(hotelList);

        for (Hotel hotel : hotelList) {
            District district = districtService.getById(hotel.getDistrictId());
            City city = cityService.getById(district.getCityId());
            Province province = provinceService.getById(city.getProvinceId());
            hotel.setProvinceCityDistrict(province.getName() + " " + province.getArea() + " " + city.getName() + " " + district.getName());
        }

        pageBean.setPageNum(page.getCurrent());
        pageBean.setTotalPageNum(page.getPages());
        pageBean.setTotalRecordsNum(page.getTotal());
        model.addAttribute("pageBean",pageBean);

        return "hotel";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute(value = "loginBean") Hotel loginBean, ModelMap model) {
        IPage<Hotel> page = hotelService.page(new Page<>(1, 3));

        return "";
    }

    @RequestMapping("/update")
    public String update(@PathVariable(value = "1", name = "pageNum") Integer pageNum) {
        IPage<Hotel> page = hotelService.page(new Page<>(1, 3));

        return "";
    }

    @RequestMapping("/delete")
    public String delete(String ids,Integer pageNum, Model model) {

        PageBean<Hotel> pageBean = new PageBean<>();;

        String[] str = ids.split(",");

        int del = 0;

        for(int i=0;i<str.length;i++){
            int id = Integer.parseInt(str[i]);

            boolean b = hotelService.removeById(id);

            if (b){
                del++;
            }

        }

        IPage<Hotel> page = hotelService.page(new Page<>(pageNum, GlobalConst.PAGE_SIZE));

        StringBuffer sb = new StringBuffer();
        List<Hotel> hotelList = page.getRecords();
        pageBean.setRecords(hotelList);

        model.addAttribute("pageBean",pageBean);

        if(del==str.length){
           return "hotel";
        }

        return "hotel";
    }
}
