package bg.softuni.framework.dispatch;

import bg.softuni.framework.lifecycle.request.RequestMethod;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public interface Dispatcher {

    String dispatch(RequestMethod requestMethod, String uri) throws InvocationTargetException, IllegalAccessException;
}
