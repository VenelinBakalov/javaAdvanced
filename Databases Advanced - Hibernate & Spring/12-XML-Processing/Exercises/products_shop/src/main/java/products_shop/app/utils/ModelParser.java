package products_shop.app.utils;

import org.modelmapper.ModelMapper;



public class ModelParser {
    private static ModelMapper modelMapper;

    public static ModelMapper getInstance() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }

    public static <T> T map(Object source, Class<T> destination) {
        return source == null ? null : ModelParser.getInstance().map(source, destination);
    }

}
