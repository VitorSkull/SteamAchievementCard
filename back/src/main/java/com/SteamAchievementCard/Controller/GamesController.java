package com.SteamAchievementCard.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SteamAchievementCard.Model.UserModel;
import com.SteamAchievementCard.Service.SteamService;

@RestController
@RequestMapping("/Games")
public class GamesController {
    private final SteamService steamService;

    public GamesController(SteamService steamService){
        this.steamService = steamService;
    }

    @GetMapping
    public UserModel getGames(@RequestParam String steamid) {

        UserModel user = steamService.getUser(steamid);

        return user;
    }
}
