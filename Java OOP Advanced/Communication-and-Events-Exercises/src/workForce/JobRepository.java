package workForce;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class JobRepository {

    private List<Job> jobs;

    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    public void add(Job element) {
        this.jobs.add(element);
    }

    public void remove(Job element) {
        this.jobs.remove(element);
    }

    public void update() {
        Iterator<Job> jobIterator = this.jobs.iterator();
        while (jobIterator.hasNext()) {
            jobIterator.next().update();
        }
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
