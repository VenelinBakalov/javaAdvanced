package app.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Guest Lector on 17-Jul-17.
 */
@Entity
@Table(name = "labels")
public class ClassicLabel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String name;

    @OneToOne(mappedBy = "label")
    private BasicShampoos basicShampoos;

    public ClassicLabel() {
    }

    public ClassicLabel(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassicLabel{" +
                "name='" + name + '\'' +
                '}';
    }
}
