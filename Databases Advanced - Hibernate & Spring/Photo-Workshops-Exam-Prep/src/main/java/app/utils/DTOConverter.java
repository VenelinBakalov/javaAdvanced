package app.utils;

import app.dto.photographers.LandscapePhotographersJsonDto;
import app.entities.Photographer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Venelin on 6.8.2017 г..
 */
public final class DTOConverter {

    private static ModelMapper mapper = new ModelMapper();

    private DTOConverter() {}

    public static <S, D> D convert(S source, Class<D> destinationClass) {
//        ModelMapper mapper = new ModelMapper();
        return mapper.map(source, destinationClass);
    }

    public static <S, D> List<D> convert(Iterable<S> sourceCollection, Class<D> destinationClass) {
//        ModelMapper mapper = new ModelMapper();
        List<D> resultList = new ArrayList<>();

        for (S sourceObj : sourceCollection) {
            D destObj = convert(sourceObj, destinationClass);
            resultList.add(destObj);
        }

        return resultList;
    }

    public static <S, D> Set<D> convertToSet(Iterable<S> sourceCollection, Class<D> destinationClass) {
//        ModelMapper mapper = new ModelMapper();
        Set<D> resultSet = new HashSet<>();

        for (S sourceObj : sourceCollection) {
            D destObj = convert(sourceObj, destinationClass);
            resultSet.add(destObj);
        }

        return resultSet;
    }

    public static List<LandscapePhotographersJsonDto> convertLandscapePhotographers(Iterable<Photographer> photographers) {
//        ModelMapper mapper = new ModelMapper();
        PropertyMap<Photographer, LandscapePhotographersJsonDto> propertyMap = new PropertyMap<Photographer, LandscapePhotographersJsonDto>() {
            @Override
            protected void configure() {
                map().setLensCount(source.getLenses().size());
            }
        };

        mapper.addMappings(propertyMap);
        List<LandscapePhotographersJsonDto> resultList = convert(photographers, LandscapePhotographersJsonDto.class);
        return resultList;
    }
}
