package com.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.bean.Item;
@Controller
public class ItemController3 {
	// 商品查询列表
    // @RequestMapping实现 对queryItems方法和url进行映射，一个方法对应一个url
    // 一般建议将url和方法写成一样
    @RequestMapping("/annotationQueryItems")
    public ModelAndView queryItems() throws Exception {

        // 实际中是调用service查找数据库，查询商品列表，这里直接使用静态数据来模拟了
    	List<Item> itemsList = new ArrayList<>();
		Item items_1 = new Item();
		items_1.setId(1);
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        items_1.setCreatetime(new Date());
        Item items_2 = new Item();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iPhone6苹果手机！");
        items_2.setCreatetime(new Date());
        itemsList.add(items_1);
        itemsList.add(items_2);
        items_2.setId(2);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        // 相当于request的setAttribute，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        // 指定视图
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");

        return modelAndView;
    }

    @RequestMapping("/annotationQueryItems2")
    public ModelAndView queryItems2() throws Exception {

        // 实际中是调用service查找数据库，查询商品列表，这里直接使用静态数据来模拟了
    	List<Item> itemsList = new ArrayList<>();
		Item items_1 = new Item();
		items_1.setId(1);
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        items_1.setCreatetime(new Date());
        Item items_2 = new Item();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iPhone6苹果手机！");
        items_2.setCreatetime(new Date());
        itemsList.add(items_1);
        itemsList.add(items_2);
        items_2.setId(2);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        // 相当于request的setAttribute，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        // 指定视图
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");

        return modelAndView;
    }
}
