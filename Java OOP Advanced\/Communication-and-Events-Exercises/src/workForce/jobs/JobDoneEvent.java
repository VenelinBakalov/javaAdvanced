package workForce.jobs;

import java.util.EventObject;

/**
 * Created by Venelin on 15.4.2017 г..
 */
public class JobDoneEvent extends EventObject {

    private String jobName;

    public JobDoneEvent(Job source, String jobName) {
        super(source);
        this.jobName = jobName;
    }

    public String getJobName() {
        return this.jobName;
    }
}
