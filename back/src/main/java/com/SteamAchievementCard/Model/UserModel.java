package com.SteamAchievementCard.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserModel {
    @JsonProperty("steamid")
    private String steamid;

    @JsonProperty("personaname")
    private String personaName;

    @JsonProperty("profileurl")
    private String profileUrl;

    @JsonProperty("avatar")
    private String avatar;

}
