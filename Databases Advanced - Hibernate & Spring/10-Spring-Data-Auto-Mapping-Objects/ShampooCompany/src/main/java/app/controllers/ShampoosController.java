package app.controllers;

import app.dao.api.IngredientsDao;
import app.dto.BaseIngredientDto;
import app.dto.IngredientDto;
import app.dto.ShampooDto;
import app.model.*;
import app.service.api.ShampoosService;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 20.7.2017 г..
 */
@Controller
public class ShampoosController {

    private final ShampoosService<BasicShampoos, Long> shampoosService;

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public ShampoosController(ShampoosService<BasicShampoos, Long> shampoosService) {
        this.shampoosService = shampoosService;
    }

    public ShampooDto shampoo(Long id) {
        BasicShampoos shampoo = shampoosService.findById(id);
        ShampooDto shampooDto = convertToDto(shampoo);
        return shampooDto;
    }

    public BasicShampoos createShampoo(ShampooDto shampooDto) {
        BasicShampoos shampoo = convertToEntity(shampooDto);
        shampoosService.save(shampoo);
        return shampoo;
    }

    private ShampooDto convertToDto(BasicShampoos shampoo) {
        mapper = new ModelMapper();
        return mapper.map(shampoo, ShampooDto.class);
    }

    private BasicShampoos convertToEntity(ShampooDto shampooDto) {
        mapper = new ModelMapper();
        TypeMap<ShampooDto, BasicShampoos> typeMap =
                mapper.createTypeMap(ShampooDto.class, BasicShampoos.class);

        typeMap.include(ShampooDto.class, FreshNuke.class);
//        for (BaseIngredientDto baseIng : shampooDto.getIngredients()) {
//            typeMap.map(baseIng);
//        }
        Converter<Set<BaseIngredientDto>, Set<BasicIngredient>> converter = new Converter<Set<BaseIngredientDto>, Set<BasicIngredient>>() {
            @Override
            public Set<BasicIngredient> convert(MappingContext<Set<BaseIngredientDto>, Set<BasicIngredient>> mappingContext) {
                Set<BasicIngredient> resultSet = new HashSet<>();
                Set<BaseIngredientDto> ingDtos = mappingContext.getSource();
                if(ingDtos == null) {
                    return resultSet;
                }
                for (BaseIngredientDto ingDto : ingDtos) {
                    BasicIngredient ing = null;
                    if("Mint".equals(ingDto.getName())) {
                        ing = new Mint();
                    } else if ("Strawberry".equals(ingDto.getName())) {
                        ing = new Strawberry();
                    }
                    resultSet.add(ing);
                }
                return resultSet;
            }
        };

        Provider<BasicShampoos> shampooProvider = new Provider<BasicShampoos>() {
            @Override
            public BasicShampoos get(ProvisionRequest<BasicShampoos> provisionRequest) {
                ShampooDto shampooDto = (ShampooDto) provisionRequest.getSource();
                BasicShampoos result = null;
                if("Fresh Shine".equals(shampooDto.getLabelName())) {
                    result = new FreshNuke();
                } else if("Kra Kra".equals(shampooDto.getLabelName())) {
                    result = new KraKra();
                }
                return result;
            }
        };
        typeMap.setProvider(shampooProvider);


        typeMap.addMappings(m -> m.using(converter).map(ShampooDto::getIngredients, BasicShampoos::setIngredients));
        return typeMap.map(shampooDto);
    }


}
