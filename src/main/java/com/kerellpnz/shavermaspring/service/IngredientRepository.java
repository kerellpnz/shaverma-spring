package com.kerellpnz.shavermaspring.service;

import com.kerellpnz.shavermaspring.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
