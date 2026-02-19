package com.SteamAchievementCard.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VanityResponse {
    
    private VanityInner response;

    @Data
    public static class VanityInner{

        @JsonProperty("steamid")
        private String steamid;

    }
}
