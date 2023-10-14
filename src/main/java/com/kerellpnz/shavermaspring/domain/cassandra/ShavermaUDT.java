package com.kerellpnz.shavermaspring.domain.cassandra;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@UserDefinedType("shaverma")
public class ShavermaUDT {

    private final String name;
    private final List<IngredientUDT> ingredients;
}
