package workForce.repositories;


import workForce.jobs.Job;
import workForce.jobs.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class JobRepository {

    private List<Job> jobs;
    private Listener listener;

    public JobRepository(Listener listener) {
        this.jobs = new ArrayList<>();
        this.listener = listener;
    }

    public void addJob(Job job) {
        job.setListener(this.listener);
        this.jobs.add(job);
    }

    public void update() {
        this.jobs.forEach(Job::update);
        this.jobs.removeIf(Job::isDone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Job job : this.jobs) {
            sb.append(job).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
