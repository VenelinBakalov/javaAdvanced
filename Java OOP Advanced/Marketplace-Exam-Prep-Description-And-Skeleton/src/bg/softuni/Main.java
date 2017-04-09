package bg.softuni;

import bg.softuni.controller.ProductController;
import bg.softuni.framework.container.Container;
import bg.softuni.framework.container.DependencyContainer;
import bg.softuni.framework.dispatch.ControllerDispatcher;
import bg.softuni.framework.dispatch.Dispatcher;
import bg.softuni.framework.lifecycle.*;
import bg.softuni.framework.lifecycle.controller.ControllerActionPair;
import bg.softuni.framework.lifecycle.request.RequestMethod;
import bg.softuni.framework.parser.*;
import bg.softuni.provider.data.DataProvider;
import bg.softuni.provider.data.ShopDatabase;
import bg.softuni.provider.type.ClassProvider;
import bg.softuni.provider.type.TypeProvider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Map;

@ComponentScan(classes = {
        Main.class,
        ProductController.class,
        DataProvider.class,
        ShopDatabase.class,
        Dispatcher.class,
        ControllerDispatcher.class
})
public class Main {

    public static void main(String args[]) throws Exception {
        TypeProvider provider = new ClassProvider(Main.class.getAnnotation(ComponentScan.class).classes());
        Parser parser = new AnnotationParser();
        Container container = new DependencyContainer(parser, provider);
        container.addDependency(TypeProvider.class, provider);
        container.addDependency(Parser.class, parser);
        container.addDependency(Container.class, container);
        Dispatcher dispatcher = container.resolve(Dispatcher.class);
    }

}
