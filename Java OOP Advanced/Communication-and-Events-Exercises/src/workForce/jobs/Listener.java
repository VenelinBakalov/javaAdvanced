package workForce.jobs;

import java.util.EventListener;

/**
 * Created by Venelin on 15.4.2017 г..
 */
public interface Listener extends EventListener {

    void handle(JobDoneEvent event);
}
