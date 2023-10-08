package com.kerellpnz.shavermaspring.controller;

import com.kerellpnz.shavermaspring.domain.Ingredient;
import com.kerellpnz.shavermaspring.domain.Shaverma;
import com.kerellpnz.shavermaspring.domain.ShavermaOrder;
import com.kerellpnz.shavermaspring.service.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("shavermaOrder")
public class DesignShavermaController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignShavermaController(
            IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = ingredientRepo.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "shavermaOrder")
    public ShavermaOrder order() {
        return new ShavermaOrder();
    }

    @ModelAttribute(name = "shaverma")
    public Shaverma shaverma() {
        return new Shaverma();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processShaverma(@Valid Shaverma shaverma, Errors errors,
                                  @ModelAttribute ShavermaOrder shavermaOrder) {
        if (errors.hasErrors()) {
            return "design";
        }

        shavermaOrder.addShaverma(shaverma);
        log.info("Processing shaverma: {}", shaverma);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
