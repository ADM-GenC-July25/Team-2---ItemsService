package com.cognizant.restaurant.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cognizant.restaurant.entity.Category;
import com.cognizant.restaurant.entity.Item;
import com.cognizant.restaurant.entity.SpiceLevel;
import com.cognizant.restaurant.dto.ItemProjection;
import com.cognizant.restaurant.entity.Allergen;
import com.cognizant.restaurant.repository.AllergenRepository;
import com.cognizant.restaurant.repository.CategoryRepository;
import com.cognizant.restaurant.repository.ItemRepository;
import com.cognizant.restaurant.repository.SpiceLevelRepository;

@Service
public class ItemService {
	
	private ItemRepository itemRepository;
	private CategoryRepository categoryRepository;
	private AllergenRepository allergenRepository;
	private SpiceLevelRepository spiceLevelRepository;

	public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository,
			AllergenRepository allergenRepository, SpiceLevelRepository spiceLevelRepository) {
		super();
		this.itemRepository = itemRepository;
		this.categoryRepository = categoryRepository;
		this.allergenRepository = allergenRepository;
		this.spiceLevelRepository = spiceLevelRepository;
	}
	
	public List<ItemProjection> getAllItems() {
		return itemRepository.findAllProjectedBy();
	}
	
	public void setAllItems() {
		Category[] categories = {
			new Category("Beverages"),
			new Category("Sides"),
			new Category("Mains"),
			new Category("Desserts")
		};

		for(Category category : categories) {
			categoryRepository.saveAndFlush(category);
		}

		SpiceLevel[] spiceLevels = {
			new SpiceLevel("Mild"),
			new SpiceLevel("Medium"),
			new SpiceLevel("Hot"),
			new SpiceLevel("Solar-Flare")
		};

		for(SpiceLevel spiceLevel : spiceLevels) {
			spiceLevelRepository.saveAndFlush(spiceLevel);
		}

		Item[] items = {
			new Item(
				"Cosmic Coffee",
				"Premium coffee blend from distant star systems",
				categories[0],
				spiceLevels[0],
				4.50,
				"cosmic_coffee.jpg",
				1,
				3
			),
			new Item(
					"Nebula Tea",
					"Herbal tea infused with stardust essence",
					categories[0],
					spiceLevels[0],
					7.00,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Galaxy Smoothie",
					"Mixed berry smoothie with cosmic energy",
					categories[0],
					spiceLevels[0],
					9.25,
					"cosmic_coffee.jpg",
					1,
					0
					),
			new Item(
					"Meteor Mocha",
					"Rich chocolate coffee with asteroid foam",
					categories[0],
					spiceLevels[0],
					10.00,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Cosmic Crasher",
					"HCocktail with a blend of interstellar spirits and a splash of stardust",
					categories[1],
					spiceLevels[1],
					10.00,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Galactic Salad",
					"Fresh greens from the Andromeda Galaxy",
					categories[1],
					spiceLevels[0],
					10.00,
					"cosmic_coffee.jpg",
					1,
					0
				),
			
			new Item(
					"Planetary Fries",
					"Crispy fries seasoned with space salt",
					categories[1],
					spiceLevels[0],
					6.50,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Asteroid Rings",
					"Onion rings with meteor dust coating",
					categories[1],
					spiceLevels[0],
					7.75,
					"cosmic_coffee.jpg",
					1,
					5
				),
			new Item(
					"Solar Soup",
					"Warm soup with solar-powered vegetables",
					categories[1],
					spiceLevels[0],
					8.25,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Alien Delight",
					"A mysterious dish with exotic alien ingredients",
					categories[2],
					spiceLevels[2],
					15.00,
					"cosmic_coffee.jpg",
					1,
					7
				),
			new Item(
					"Meteor Meatballs",
					"Spicy meatballs made from meteorite-infused beef",
					categories[2],
					spiceLevels[2],
					14.00,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Nebula Noodles",
					"Noodles tossed in a spicy nebula sauce with space vegetables",
					categories[2],
					spiceLevels[1],
					13.50,
					"cosmic_coffee.jpg",
					1,
					4
				),
			
			new Item(
					"Stellar Steak",
					"Grilled steak seasoned with cosmic spices and served with a side of planetary fries",
					categories[2],
					spiceLevels[1],
					20.00,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Plasma Pasta",
					"Pasta in a creamy plasma sauce with a hint of spice",
					categories[2],
					spiceLevels[1],
					16.00,
					"cosmic_coffee.jpg",
					1,
					6
				),
			new Item(
					"Quantum Quiche",
					"A savory quiche with a blend of space cheeses and vegetables",
					categories[2],
					spiceLevels[0],
					12.00,
					"cosmic_coffee.jpg",
					1,
					1
				),
			new Item(
					"Lunar Lemonade",
					"Refreshing lemonade with a hint of moon dust",
					categories[0],
					spiceLevels[0],
					6.00,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Starship Sangria",
					"A fruity sangria with a cosmic twist",
					categories[0],
					spiceLevels[0],
					11.00,
					"cosmic_coffee.jpg",
					1,
					2
				),
			new Item(
					"Comet Cola",
					"Classic cola with a splash of comet essence",
					categories[0],
					spiceLevels[0],
					3.00,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Black Hole Brownie",
					"Decadent chocolate brownie with a molten center",
					categories[3],
					spiceLevels[0],
					4.50,
					"cosmic_coffee.jpg",
					1,
					0
				),
			new Item(
					"Supernova Smasher Sundae",
					"Ice cream sundae with cosmic toppings and a supernova of flavors",
					categories[3],
					spiceLevels[3],
					8.00,
					"cosmic_coffee.jpg",
					1,
					8
				)
		};
		for(Item item : items) {
			itemRepository.saveAndFlush(item);
		}
		
		Allergen[] allergens = {
				new Allergen("Meteor-Dust", items[0]),
				new Allergen("Meteor-Dust", items[1]),
				new Allergen("Plasma-Sensitive", items[4]),
				new Allergen("Meteor-Dust", items[4]),
				new Allergen("Alien-Protein", items[9]),
				new Allergen("Synthetic-Compounds", items[9]),
				new Allergen("Gluten", items[10]),
				new Allergen("Eggs", items[10]),
				new Allergen("Gluten", items[11]),
				new Allergen("Soy", items[11]),
				new Allergen("Dairy", items[11]),
				new Allergen("Gluten", items[13]),
				new Allergen("Dairy", items[13]),
				new Allergen("Eggs", items[13]),
				new Allergen("Gluten", items[14]),
				new Allergen("Dairy", items[14]),
				new Allergen("Eggs", items[14]),
				new Allergen("Plasma-Sensitive", items[16]),
				new Allergen("Gluten", items[18]),
				new Allergen("Dairy", items[18]),
				new Allergen("Eggs", items[18]),
				new Allergen("Nuts", items[18]),
				new Allergen("Dairy", items[19]),
				new Allergen("Nuts", items[19]),
				new Allergen("Plasma-Sensitive", items[19]),
				new Allergen("Synthetic-Compounds", items[19]),
		};
		for(Allergen allergen : allergens) {
			allergenRepository.saveAndFlush(allergen);
		}
	}

	public Map<String, List<String>> getOptions() {

		Map<String, List<String>> options = new HashMap<>();
		
		options.put("categories", categoryRepository
				.findAll()
				.stream()
				.sorted((a, b) -> a.getId() > b.getId() ? 1 : -1)
				.map((c) -> c.getName())
				.toList());
		options.put("allergens", allergenRepository
				.findAll()
				.stream()
				.map((a) -> a.getName())
				.distinct()
				.toList());
		options.put("spiceLevels", spiceLevelRepository
				.findAll()
				.stream()
				.sorted((a, b) -> a.getId() > b.getId() ? 1 : -1)
				.map((s) -> s.getName())
				.toList());

		return options;
	}

	public List<ItemProjection> getFeaturedItems(int number) {
		PageRequest pageRequest = PageRequest.of(0, number, Sort.by(Direction.DESC, "popularity"));
		return itemRepository.findAllProjectedBy(pageRequest);
	}
	
	public List<ItemProjection> getFilteredItems(
			String categoryName,
			String spiceLevelName,
			Double minPrice,
			Double maxPrice,
			List<String> execludedAllergens
			){
		return itemRepository.findFilteredItems(categoryName, spiceLevelName, minPrice, maxPrice, execludedAllergens);
		
	}
}
