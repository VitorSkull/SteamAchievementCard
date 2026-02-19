package com.SteamAchievementCard.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SteamAchievementCard.Model.SteamResponse;
import com.SteamAchievementCard.Model.UserModel;
import com.SteamAchievementCard.Model.VanityResponse;

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

        if (input.matches("\\d+")) {
            return input;
        }

        if (input.contains("/profiles/")) {
            return input.substring(input.lastIndexOf("/") + 1);
        }

        if (input.contains("/id/")) {

            String vanity = input.substring(input.lastIndexOf("/") + 1);

            String url = "https://api.steampowered.com/ISteamUser/ResolveVanityURL/v1/"
                    + "?key=" + apiKey
                    + "&vanityurl=" + vanity;

            VanityResponse response =
                    restTemplate.getForObject(url, VanityResponse.class);

            return response.getResponse().getSteamid();
        }

        return input;
    }
}
