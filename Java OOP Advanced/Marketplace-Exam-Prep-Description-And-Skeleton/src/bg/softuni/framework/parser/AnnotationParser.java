package bg.softuni.framework.parser;

import bg.softuni.framework.parser.strategy.AnnotationParserStrategy;

import java.util.Map;

/**
 * @author RoYaL
 */
public class AnnotationParser implements Parser {

    @Override
    public <C, R> void parse(AnnotationParserStrategy<C, R> parserStrategy, Map<C, R> cachedResult) throws InstantiationException, IllegalAccessException {
        parserStrategy.parse(cachedResult);
    }
}

