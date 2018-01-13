package project.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import project.model.FilmEntity;
import org.springframework.stereotype.Repository;
import project.utils.HibernateSessionFactory;

import java.util.List;

/**
 * Created by Elvira on 17.12.2017.
 */
@Repository
public class FilmImpl implements FilmDao {

    private FilmDao filmDao;

    public FilmImpl() {
    }

    @Override
    public void addFilm(FilmEntity film) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(film);
        session.getTransaction().commit();
    }

    @Override
    public void updateFilm(FilmEntity film) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(film);
        session.getTransaction().commit();
    }

    @Override
    public FilmEntity getFilmById(Integer idFilm) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        FilmEntity filmEntity = (FilmEntity) session.load(FilmEntity.class, idFilm);
        return filmEntity;
    }

    @Override
    public List<FilmEntity> getAllFilms() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<FilmEntity> filmList = session.createCriteria(FilmEntity.class).list();
        return filmList;
    }

    @Override
    public void deleteFilm(Integer idFilm) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        FilmEntity filmEntity = (FilmEntity) session.load(FilmEntity.class, idFilm);
        if(filmEntity!=null){
            session.beginTransaction();
            session.delete(filmEntity);
            session.getTransaction().commit();
        }
    }
}
