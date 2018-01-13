package project.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Elvira on 17.12.2017.
 */
@Entity
@Table(name = "film", schema = "spring")
public class FilmEntity {
    private int idFilm;
    private String name;
    private int releaseDate;
    private double rating;

    public FilmEntity() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_film")
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
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
    @Column(name = "release_date")
    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "rating")
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idFilm;
        result = 31 * result + name.hashCode();
        result = 31 * result + releaseDate;
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "FilmEntity{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", rating=" + rating +
                '}';
    }

}
