package com.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.springframework.web.HttpRequestHandler;

import com.ssm.bean.Item;

public class ItemController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
        
        req.setAttribute("itemsList", itemsList);
      //设置转发的视图
        req.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(req, resp);
	}

}
