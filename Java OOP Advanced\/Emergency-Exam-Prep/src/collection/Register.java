package collection;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public interface Register<T> {

    void enqueueEmergency(T emergency);

    T dequeueEmergency();

    Integer count();

    Boolean isEmpty();
}
