package com.kerellpnz.shavermaspring.domain.cassandra;

import com.kerellpnz.shavermaspring.domain.Ingredient;
import com.kerellpnz.shavermaspring.domain.Shaverma;

public final class ShavermaUDRUtils {

    private ShavermaUDRUtils() {
    }

    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }

    public static ShavermaUDT toShavermaUDT(Shaverma shaverma) {
        return new ShavermaUDT(shaverma.getName(), shaverma.getIngredients());
    }
}
