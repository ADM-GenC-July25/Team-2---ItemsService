package com.cognizant.restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.restaurant.dto.ItemProjection;
import com.cognizant.restaurant.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	List<ItemProjection> findAllProjectedBy();

	List<ItemProjection> findAllProjectedBy(Pageable pageable);
	
	Optional<ItemProjection> findProjectionById(Long id);
	
	@Query("SELECT i FROM Item i WHERE i.id IN :ids")
	List<ItemProjection> findAllProjectionsByIds(@Param("ids") List<Long> ids);


	@Query("""
			    SELECT i FROM Item i
			    JOIN i.category c
			    JOIN i.spiceLevel s
			    LEFT JOIN i.allergens a
			    WHERE (:categoryName IS NULL OR c.name = :categoryName)
			      AND (:spiceLevelName IS NULL OR s.name = :spiceLevelName)
			      AND (:minPrice IS NULL OR i.price >= :minPrice)
			      AND (:maxPrice IS NULL OR i.price <= :maxPrice)
			      AND (:excludedAllergens IS NULL OR
					NOT EXISTS (
			            SELECT 1 FROM Allergen a
			            WHERE a.item = i
			              AND a.name IN :excludedAllergens
					      )
					)
			    GROUP BY i.id
			""")

	List<ItemProjection> findFilteredItems(@Param("categoryName") String categoryName,
			@Param("spiceLevelName") String spiceLevelName, @Param("minPrice") Double minPrice,
			@Param("maxPrice") Double maxPrice, @Param("excludedAllergens") List<String> excludedAllergens);

}
