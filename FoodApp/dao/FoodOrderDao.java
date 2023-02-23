package com.food.FoodApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.FoodApp.dto.FoodOrder;
import com.food.FoodApp.dto.Item;
import com.food.FoodApp.repository.FoodRepository;
import com.food.FoodApp.repository.ItemRepo;


@Repository
public class FoodOrderDao {

	@Autowired
	FoodRepository foodRepository;

	@Autowired
	ItemRepo itemRepo;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		List<Item> listOfItems= foodOrder.getItems();
		List<Item> res= new ArrayList<>();
		if (listOfItems.isEmpty()) {
			foodOrder= foodRepository.save(foodOrder);
		} else {
			foodOrder = foodRepository.save(foodOrder);
			for(Item item : listOfItems) {
				item.setFoodorder(foodOrder);
				res.add(itemRepo.save(item));
			}
			foodOrder.setItems(res);
		}
		return foodOrder;
	}
	
//	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
//		return foodRepository.save(foodOrder);
//		 
//	}
	public Optional<FoodOrder> getFoodOrderById(int id) {
		return foodRepository.findById(id);
	}
	public List<FoodOrder> getAllFoodOrder(){
		return foodRepository.findAll();
	}
	public FoodOrder updateFoodOrder(FoodOrder foodorder) {
		return foodRepository.save(foodorder);
	}

	public void deleteFoodOrder(int id) {
		foodRepository.deleteById(id);
	}
}
