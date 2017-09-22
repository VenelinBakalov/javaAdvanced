package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;

import java.lang.reflect.Field;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public class Injector {

    public static void injectDependencies(Object client, Object service) throws ReflectiveOperationException {
        Class clientClass = client.getClass();
        Class serviceClass = service.getClass();

        Field[] clientFields = clientClass.getDeclaredFields();
        for (Field clientField : clientFields) {
            if (!clientField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            clientField.setAccessible(true);

            Field[] serviceFields = serviceClass.getDeclaredFields();
            for (Field serviceField : serviceFields) {
                if (!serviceField.getType().equals(clientField.getType())) {
                    continue;
                }
                serviceField.setAccessible(true);
                clientField.set(client, serviceField.get(service));
            }
        }
    }
}
