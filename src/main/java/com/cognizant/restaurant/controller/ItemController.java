package com.cognizant.restaurant.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.restaurant.dto.ItemProjection;
import com.cognizant.restaurant.services.ItemService;


@RestController
public class ItemController {
	
	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@GetMapping("/all")
	public List<ItemProjection> getAllItems() {
		return itemService.getAllItems();
	}
	
	@PostMapping("/all")
	public void storeAllObjects() {
		itemService.setAllItems();
	}
	
	@GetMapping("/options")
	public Map<String, List<String>> getOptions(){
		return itemService.getOptions();
	}
	
	@GetMapping("/featured/{number}")
	public List<ItemProjection> getFeaturedItems(@PathVariable int number){
		return itemService.getFeaturedItems(number);
	}
	
	@GetMapping("/filtered")
    public List<ItemProjection> getFilteredItems(
            @RequestParam(name = "category", required = false) String categoryName,
            @RequestParam(name = "spiceLevel", required = false) String spiceLevelName,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice,
            @RequestParam(name = "excludedAllergens", required = false) List<String> excludedAllergens
    ) {
        return itemService.getFilteredItems(categoryName, spiceLevelName, minPrice, maxPrice, excludedAllergens);
	}
	
}
