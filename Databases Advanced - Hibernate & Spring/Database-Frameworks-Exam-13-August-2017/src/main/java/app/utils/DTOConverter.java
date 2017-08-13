package app.utils;

import app.dto.employees.EmployeeExportJsonDto;
import app.entities.Employee;
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

    private DTOConverter() {};

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

//    public static List<EmployeeExportJsonDto> convertProductiveEmployee(Iterable<Employee> employees) {
//        PropertyMap<Employee, EmployeeExportJsonDto> propertyMap = new PropertyMap<Employee, EmployeeExportJsonDto>() {
//            @Override
//            protected void configure() {
//                map().setFullName(source.getFirstName() + " " + source.getLastName());
//            }
//        };
//
//        mapper.addMappings(propertyMap);
//        List<EmployeeExportJsonDto> resultList = convert(employees, EmployeeExportJsonDto.class);
//        return resultList;
//    }
}
