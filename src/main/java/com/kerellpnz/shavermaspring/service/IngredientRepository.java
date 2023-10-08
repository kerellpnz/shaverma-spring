package com.kerellpnz.shavermaspring.service;

import com.kerellpnz.shavermaspring.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {
    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
