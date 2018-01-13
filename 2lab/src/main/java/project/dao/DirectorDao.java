package project.dao;

import project.model.DirectorEntity;

import java.util.List;

/**
 * Created by Elvira on 17.12.2017.
 */
public interface DirectorDao {
    public void addDirector(DirectorEntity director);
    public void updateDirector(DirectorEntity director);
    public DirectorEntity getDirectorById(Integer idDirector);
    public List<DirectorEntity> getAllDirectors();
    public void deleteDirector(Integer idDirector);
}
