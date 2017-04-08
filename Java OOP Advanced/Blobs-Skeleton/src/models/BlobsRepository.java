package models;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class BlobsRepository {

    private Map<String, Blob> repository;

    public BlobsRepository() {
        this.repository = new LinkedHashMap<>();
    }

    public Blob find(String name) {
        return this.repository.get(name);
    }

    public void add(Blob blob) {
        this.repository.put(blob.getName(), blob);
    }

    public void update() {
        this.repository.values().forEach(Blob::update);
    }

    public String printStatus() {
        StringBuilder sb = new StringBuilder();
        for (Blob blob : this.repository.values()) {
            sb.append(blob).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
