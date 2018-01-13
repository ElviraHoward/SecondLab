package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.model.DirectorEntity;
import project.service.DirectorServiceImpl;

import java.util.Map;

/**
 * Created by Elvira on 17.12.2017.
 */
@Controller
public class DirectorController {
    private DirectorServiceImpl directorService;

    @Autowired
    @Qualifier(value = "directorService")
    public void setDirectorService(DirectorServiceImpl directorService) {
        this.directorService = directorService;
    }

    @RequestMapping(value = "director", method = RequestMethod.GET)
    public String listDirectors(@ModelAttribute("director") DirectorEntity director, Model model) {
        model.addAttribute("director", new DirectorEntity());
        model.addAttribute("listDirectors", this.directorService.getAllDirectors());
        return "director";
    }
    @RequestMapping(value="/director.do", method=RequestMethod.POST)
    public String doActions(@ModelAttribute DirectorEntity director, BindingResult result, @RequestParam String action, Map<String, Object> map){
         DirectorEntity directorResult = new DirectorEntity();
        switch(action.toLowerCase()){
            case "add":
                directorService.addDirector(director);
                directorResult = director;
                break;
            case "edit":
                directorService.updateDirector(director);
                directorResult = director;
                break;
            case "delete":
                directorService.deleteDirector(director.getIdDirector());
                directorResult = new DirectorEntity();
                break;
        }
        map.put("director", directorResult);
        map.put("directorList", directorService.getAllDirectors());
        return "director";
    }
}
