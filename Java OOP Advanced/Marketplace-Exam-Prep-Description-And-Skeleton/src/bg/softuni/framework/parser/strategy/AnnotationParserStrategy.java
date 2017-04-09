package bg.softuni.framework.parser.strategy;

import java.util.Map;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public interface AnnotationParserStrategy<C, R> {

    void parse(Map<C, R> cachedResult) throws IllegalAccessException, InstantiationException;
}
