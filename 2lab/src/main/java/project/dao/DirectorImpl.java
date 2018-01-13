package project.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import project.model.DirectorEntity;
import project.model.FilmEntity;
import project.utils.HibernateSessionFactory;

import java.util.List;

/**
 * Created by Elvira on 17.12.2017.
 */
@Repository
public class DirectorImpl implements DirectorDao {

    private DirectorDao directorDao;

    public DirectorImpl() {
    }

    @Override
    public void addDirector(DirectorEntity director) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(director);
        session.getTransaction().commit();
    }

    @Override
    public void updateDirector(DirectorEntity director) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(director);
        session.getTransaction().commit();
    }

    @Override
    public DirectorEntity getDirectorById(Integer idDirector) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        DirectorEntity directorEntity = (DirectorEntity) session.load(DirectorEntity.class, idDirector);
        return directorEntity;
    }

    @Override
    public List<DirectorEntity> getAllDirectors() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<DirectorEntity> directorList = session.createCriteria(DirectorEntity.class).list();
        return directorList;
    }

    @Override
    public void deleteDirector(Integer idDirector) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        DirectorEntity directorEntity = (DirectorEntity) session.load(DirectorEntity.class, idDirector);
        if(directorEntity!=null){
            session.beginTransaction();
            session.delete(directorEntity);
            session.getTransaction().commit();
        }
    }
}
