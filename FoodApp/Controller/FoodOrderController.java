package com.food.FoodApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.FoodApp.dao.FoodOrderDao;
import com.food.FoodApp.dto.FoodOrder;

@RestController
@RequestMapping("/foodorders")
public class FoodOrderController {

	@Autowired
	FoodOrderDao foodOrderDao;
	
	@PostMapping
	public FoodOrder placeFoodorder(@RequestBody FoodOrder foodorder ) {
		return foodOrderDao.saveFoodOrder(foodorder);
	}
	
}
