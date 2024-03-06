package org.example.validationinfosong.controller;

import org.example.validationinfosong.model.Song;
import org.example.validationinfosong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("song", new Song());
        return "/index";
    }

    @PostMapping("/")
    public String checkValidation(@Valid @ModelAttribute("user") Song song, BindingResult bindingResult, Model model){
        new Song().validate(song, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        } else {
            model.addAttribute("Song", song);
            iSongService.save(song);
            return "/result";
        }
    }
}
