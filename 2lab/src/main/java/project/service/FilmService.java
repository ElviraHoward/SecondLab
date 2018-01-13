package project.service;

import project.model.FilmEntity;

import java.util.List;

/**
 * Created by Elvira on 17.12.2017.
 */
public interface FilmService {
    public void addFilm(FilmEntity film);
    public void updateFilm(FilmEntity film);
    public FilmEntity getFilmById(Integer idFilm);
    public List<FilmEntity> getAllFilms();
    public void deleteFilm(Integer idFilm);
}
