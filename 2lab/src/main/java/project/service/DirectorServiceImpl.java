package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project.dao.DirectorDao;
import project.model.DirectorEntity;

import java.util.List;

/**
 * Created by Elvira on 24.12.2017.
 */

@Service
public class DirectorServiceImpl implements DirectorService {

    public DirectorServiceImpl() {
    }

    @Autowired
    private DirectorDao directorDao;

    public void setDirectorDao(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }

    @Override
    public void addDirector(DirectorEntity director) {
        directorDao.addDirector(director);
    }

    @Override
    public void updateDirector(DirectorEntity director) {
        directorDao.updateDirector(director);
    }

    @Override
    public DirectorEntity getDirectorById(Integer idDirector) {
        return directorDao.getDirectorById(idDirector);
    }

    @Override
    public List<DirectorEntity> getAllDirectors() {
        return directorDao.getAllDirectors();
    }

    @Override
    public void deleteDirector(Integer idDirector) {
        directorDao.deleteDirector(idDirector);
    }
}
