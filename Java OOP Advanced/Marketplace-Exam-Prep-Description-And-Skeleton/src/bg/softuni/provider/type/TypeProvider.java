package bg.softuni.provider.type;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public interface TypeProvider {

    Class[] getClassesByAnnotation(Class annotation);
}
