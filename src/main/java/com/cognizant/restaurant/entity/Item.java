package com.cognizant.restaurant.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name = "spicelevel_id")
	private SpiceLevel spiceLevel;
	private Double price;

    @OneToMany(mappedBy = "item")
	private List<Allergen> allergens;
	private String img;
	private Integer availability;
	private Integer popularity;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String name, String description, Category category, SpiceLevel spiceLevel, Double price,
			String img, Integer availability, Integer popularity) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.spiceLevel = spiceLevel;
		this.price = price;
		this.img = img;
		this.availability = availability;
		this.popularity = popularity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public SpiceLevel getSpiceLevel() {
		return spiceLevel;
	}
	public void setSpiceLevel(SpiceLevel spiceLevel) {
		this.spiceLevel = spiceLevel;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<Allergen> getAllergens() {
		return allergens;
	}
	public void setAllergens(List<Allergen> allergens) {
		this.allergens = allergens;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	public Integer getPopularity() {
		return popularity;
	}
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", spiceLevel=" + spiceLevel + ", price=" + price + ", allergens=" + allergens + ", img=" + img
				+ ", availability=" + availability + ", popularity=" + popularity + "]";
	}
	
	public String getCategoryName() {
		return this.category != null ? this.category.getName() : "" ;
	}
	
	public String getSpiceLevelName() {
		return this.spiceLevel != null ? this.spiceLevel.getName() : "";
	}

	public List<String> getAllergenNames(){
		return this.allergens != null ? this.allergens.
				stream().
				map((a) -> a.getName())
				.toList()
				: new ArrayList<>();
				
	}
	
		
}
