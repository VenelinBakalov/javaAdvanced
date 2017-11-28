package bg.softuni.framework.parser;

import bg.softuni.framework.parser.strategy.AnnotationParserStrategy;

import java.util.Map;

public interface Parser {

    <C, R> void parse(AnnotationParserStrategy<C, R> parserStrategy, Map<C, R> cachedResult) throws InstantiationException, IllegalAccessException;
}
