package com.kerellpnz.shavermaspring.converter;

import com.kerellpnz.shavermaspring.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();
    public IngredientByIdConverter() {
        ingredientMap.put("SLVH",
                new Ingredient("SLVH", "Standard lavash", Ingredient.Type.WRAP));
        ingredientMap.put("CLVH",
                new Ingredient("CLVH", "Cheese lavash", Ingredient.Type.WRAP));
        ingredientMap.put("GRBF",
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
        ingredientMap.put("CARN",
                new Ingredient("CHKN", "Chicken", Ingredient.Type.PROTEIN));
        ingredientMap.put("TMTO",
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
        ingredientMap.put("LETC",
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
        ingredientMap.put("JACK",
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
        ingredientMap.put("SLSA",
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
        ingredientMap.put("SRCR",
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
    }
    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
