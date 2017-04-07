package bg.softuni;

import bg.softuni.framework.lifecycle.*;
import bg.softuni.framework.parser.*;

@ComponentScan(classes = {
        Main.class,
})
public class Main {

    public static void main(String args[]) throws Exception {
        Parser parser = new AnnotationParser(Thread.currentThread().getContextClassLoader());
        parser.parse();
    }

}
