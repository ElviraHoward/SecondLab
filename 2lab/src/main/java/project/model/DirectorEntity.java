package project.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Elvira on 17.12.2017.
 */
@Entity
@Table(name = "director", schema = "spring")
public class DirectorEntity {
    private int idDirector;
    private String name;
    private int countOfOscars;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_director")
    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "count_of_oscars")
    public int getCountOfOscars() {
        return countOfOscars;
    }

    public void setCountOfOscars(int countOfOscars) {
        this.countOfOscars = countOfOscars;
    }

    @Override
    public int hashCode() {
        int result = idDirector;
        result = 31 * result + name.hashCode();
        result = 31 * result + countOfOscars;
        return result;
    }

    @Override
    public String toString() {
        return "DirectorEntity{" +
                "name='" + name + '\'' +
                ", countOfOscars=" + countOfOscars +
                '}';
    }

}
