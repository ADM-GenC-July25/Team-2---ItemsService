package com.cognizant.restaurant.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
    "id", "name", "description", "category", "spiceLevel",
    "price", "allergens", "img", "availability", "popularity"
})

public interface ItemProjection {
	
    Long getId();
    String getName();
    String getDescription();
    @JsonProperty("category")
    String getCategoryName();
    @JsonProperty("spiceLevel")
    String getSpiceLevelName();
    Double getPrice();
    @JsonProperty("allergens")
    List<String> getAllergenNames();
    String getImg();
    Integer getAvailability();
    Integer getPopularity();

}
