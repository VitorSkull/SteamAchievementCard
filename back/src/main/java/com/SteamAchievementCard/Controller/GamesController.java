package com.SteamAchievementCard.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getGames(@RequestParam String steamid) {
        try{
            UserModel user = steamService.getUser(steamid);

            if(user == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "User not found"));
            }
            return ResponseEntity.ok(user);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Cannot reach user data",
                     "error", e.getMessage()));
        }

    }
}
