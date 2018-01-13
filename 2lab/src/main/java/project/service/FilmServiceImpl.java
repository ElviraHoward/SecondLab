package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.FilmDao;
import project.model.FilmEntity;

import java.util.List;

/**
 * Created by Elvira on 24.12.2017.
 */
@Service
public class FilmServiceImpl implements FilmService {

    public FilmServiceImpl() {
    }

    public void setFilmDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Autowired
    private FilmDao filmDao;

    @Override
    @Transactional
    public void addFilm(FilmEntity film) {
        filmDao.addFilm(film);
    }

    @Override
    @Transactional
    public void updateFilm(FilmEntity film) {
        filmDao.updateFilm(film);
    }

    @Override
    @Transactional
    public FilmEntity getFilmById(Integer idFilm) {
        return filmDao.getFilmById(idFilm);
    }

    @Override
    @Transactional
    public List<FilmEntity> getAllFilms() {
        return filmDao.getAllFilms();
    }

    @Override
    @Transactional
    public void deleteFilm(Integer idFilm) {
        filmDao.deleteFilm(idFilm);
    }
}
