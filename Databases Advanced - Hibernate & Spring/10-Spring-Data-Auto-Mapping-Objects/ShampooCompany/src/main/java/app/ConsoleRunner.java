package app;

import app.controllers.ShampoosController;
import app.dto.ShampooDto;
import app.service.api.IngredientService;
import app.service.api.ProductionBatchService;
import app.service.api.ShampoosService;
import app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 18.7.2017 г..
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ProductionBatchService<ProductionBatch, Long> productionBatchService;

    private final IngredientService<BasicIngredient, Long> basicIngredientService;

    private final ShampoosService<BasicShampoos, Long> basicShampoosService;

    private final ShampoosController shampoosController;

    @Autowired
    public ConsoleRunner(ProductionBatchService<ProductionBatch, Long> productionBatchService, IngredientService<BasicIngredient, Long> basicIngredientService, ShampoosService<BasicShampoos, Long> basicShampoosService, ShampoosController shampoosController) {
        this.productionBatchService = productionBatchService;
        this.basicIngredientService = basicIngredientService;
        this.basicShampoosService = basicShampoosService;
        this.shampoosController = shampoosController;
    }

    @Override
    public void run(String... strings) throws Exception {
        BasicIngredient i1 = new Mint();
        BasicIngredient i2 = new Mint();
        BasicIngredient i3 = new Strawberry();
        BasicIngredient i4 = new AmoniumCloride();
//        basicIngredientService.save(i1);
//        basicIngredientService.save(i2);
//        basicIngredientService.save(i3);
//        basicIngredientService.save(i4);
////
//        BasicIngredient bi = basicIngredientService.findById(4l);
//        BasicIngredient b1 = basicIngredientService.findById(3l);
//        BasicIngredient b2 = basicIngredientService.findById(2l);
//        BasicIngredient b3 = basicIngredientService.findById(1l);
//        System.out.println(basicIngredientService.findByNameEndsWith("nt"));
//
        ClassicLabel label = new ClassicLabel("Fresh Shine");
        BasicShampoos shampoo = new FreshNuke();
        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(i1);
        ingredients.add(i3);
        shampoo.setIngredients(ingredients);
        shampoo.setLabel(label);
        //em.persist(label);
        ProductionBatch batch = new ProductionBatch();
        batch.setName("FirstSeries");
        shampoo.setBatch(batch);
        basicShampoosService.save(shampoo);
//        BasicShampoos shampoo1 = new FreshNuke();
//        shampoo1.setIngredients(ingredients);
//        shampoo1.setBatch(new ProductionBatch("Some Batch"));
//        shampoo1.setLabel(new ClassicLabel());
//        basicShampoosService.save(shampoo1);

//        ProductionBatch pb = productionBatchService.findById(1l);
//        System.out.println(pb);
//
//
//        List<ProductionBatch> batches = productionBatchService.findBatchByName("FirstSeries");
//        System.out.println(batches);
//
//
//        List<BasicShampoos> shampoos = basicShampoosService.shampoosWithIngredient(i1.getName());
//        System.out.println(shampoos);
//
//        List<BasicShampoos> shampoos1 = basicIngredientService.shampoosWithIngredient(i3);
//        System.out.println(shampoos1);

        ShampooDto shampooDto = shampoosController.shampoo(1l);
        System.out.println(shampooDto);


        Set<String> ingNames = new HashSet<>();
        ingNames.add("Ing1");
        ingNames.add("Ing2");
        ShampooDto shampooDto1 = shampooDto("Kra Kra", "Second Batch", ingNames);
        BasicShampoos kraKra =  shampoosController.createShampoo(shampooDto1);
        BasicShampoos freshNuke =  shampoosController.createShampoo(shampooDto);
        System.out.println(kraKra);
        System.out.println(freshNuke);
    }

    private ShampooDto shampooDto(String labelText, String batchName, Set<String> ingredientNames) {
        ShampooDto shampooDto = new ShampooDto();
        shampooDto.setLabelName(labelText);
        shampooDto.setBatchName(batchName);
        //shampooDto.setIngredientNames(ingredientNames);
        return shampooDto;
    }
}
