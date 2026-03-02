package com.SteamAchievementCard.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SteamAchievementCard.Model.SteamResponse;
import com.SteamAchievementCard.Model.UserModel;
import com.SteamAchievementCard.Model.VanityResponse;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;

@Service
public class SteamService {

    @Value("${steam.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate = new RestTemplate();

    public UserModel getUser(String input){
        String steamid = resolveSteamId(input);

        String url = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/"
        + "?key=" + apiKey
        + "&steamids=" + steamid;

        SteamResponse response =
        restTemplate.getForObject(url, SteamResponse.class);

        return response.getResponse().getPlayers().get(0);
    }

    private String resolveSteamId(String input) {
        input = input.trim();

        String path;

        try {
            path = URI.create(input).getPath();
        } catch (Exception e) {
            path = input;
        }

        path = path.replaceAll("/+$", "");
        String lastSegment = path.replaceAll(".*/", "");

        if (path.contains("/profiles/")) {
            return path.substring(path.lastIndexOf("/") + 1);
        }

        String vanity = lastSegment;

        String url = "https://api.steampowered.com/ISteamUser/ResolveVanityURL/v1/"
                + "?key=" + apiKey
                + "&vanityurl=" + vanity;

        VanityResponse response =
                restTemplate.getForObject(url, VanityResponse.class);

        if (response == null ||
            response.getResponse() == null ||
            response.getResponse().getSteamid() == null) {

            throw new RuntimeException("Invalid Vanity or SteamID");
        }
        return response.getResponse().getSteamid();
    }
}
