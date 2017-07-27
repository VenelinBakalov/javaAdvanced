package soft.uni.utils;

import org.modelmapper.ModelMapper;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class ModelParser {

    private static ModelMapper modelMapper;

    public static ModelMapper getInstance() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }
}
