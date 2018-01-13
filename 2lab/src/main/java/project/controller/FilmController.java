package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import project.model.DirectorEntity;
import project.model.FilmEntity;
import project.service.FilmServiceImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Map;
import java.util.Set;

import java.util.Set;

/**
 * Created by Elvira on 17.12.2017.
 */
@Controller("/film")
public class FilmController {

    private FilmServiceImpl filmService;

    @Autowired
    @Qualifier(value = "filmService")
    public void setFilmService(FilmServiceImpl filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "film", method = RequestMethod.GET)
    public String listFilms(@ModelAttribute("film") FilmEntity film, Model model) {
        model.addAttribute("film", new FilmEntity());
        model.addAttribute("listFilms", this.filmService.getAllFilms());
        return "film";
    }

    @RequestMapping(value="/film.do", method=RequestMethod.POST)
    public String doActions(@ModelAttribute FilmEntity film, BindingResult result, @RequestParam String action, Map<String, Object> map){
        FilmEntity filmResult = new FilmEntity();
        switch(action.toLowerCase()){
            case "add":
                filmService.addFilm(film);
                filmResult = film;
                break;
            case "edit":
                filmService.updateFilm(film);
                filmResult = film;
                break;
            case "delete":
                filmService.deleteFilm(film.getIdFilm());
                filmResult = new FilmEntity();
                break;
        }
        map.put("film", filmResult);
        map.put("filmList", filmService.getAllFilms());
        return "film";
    }
}
