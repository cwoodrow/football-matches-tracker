package fr.maif.football.matches.tracker.controller;

import fr.maif.football.matches.tracker.model.FootballGame;
import fr.maif.football.matches.tracker.repository.FootballGameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

@Controller
public class WebAppController {
    private final FootballGameRepository footballGameRepository;

    public WebAppController(FootballGameRepository footballGameRepository) {
        this.footballGameRepository = footballGameRepository;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("games", footballGameRepository.findAll());
        return "index";
    }

    @GetMapping("/games/add")
    public String addGame(Model model){
        model.addAttribute("game", new FootballGame());
        return "edit";
    }

    @GetMapping("/games/edit/{id}")
    public String editGame(@PathVariable("id") String id, Model model){
        model.addAttribute("game", footballGameRepository.findById(id).orElse(new FootballGame()));
        return "edit";
    }

    @PostMapping("/games/upsert")
    public String upsertGame(FootballGame footballGame){
        footballGameRepository.save(footballGame);
        return "redirect:/";
    }

}
