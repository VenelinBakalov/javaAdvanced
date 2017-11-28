package app.observer;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public interface Subject {

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}
