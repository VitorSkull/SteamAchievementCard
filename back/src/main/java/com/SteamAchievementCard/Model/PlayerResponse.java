package com.SteamAchievementCard.Model;

import lombok.Data;
import java.util.List;

@Data
public class PlayerResponse {

    private List<UserModel> players;
    
}
