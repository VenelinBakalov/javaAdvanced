package workForce.jobs;

/**
 * Created by Venelin on 15.4.2017 г..
 */
public class JobEventListener implements Listener {

    @Override
    public void handle(JobDoneEvent event) {
        System.out.println(String.format("Job %s done!", event.getJobName()));
    }
}
