package com.tehbeard.beardach.addons.environmental;

import org.bukkit.entity.Player;

import com.google.gson.annotations.Expose;

import me.tehbeard.BeardAch.achievement.Achievement;
import me.tehbeard.BeardAch.achievement.help.Argument;
import me.tehbeard.BeardAch.achievement.help.Usage;
import me.tehbeard.BeardAch.achievement.rewards.IReward;
import me.tehbeard.BeardAch.dataSource.configurable.Configurable;

@Configurable(tag="sethealth")
@Usage(arguments = { @Argument(name="heal",desc="Amount to heal to") }, packageName = "Environmental")
public class SetHealthReward implements IReward {

    @Expose
    int health;

    public void configure(Achievement arg0, String config) {
        health = Integer.parseInt(config);
        
    }

    public void giveReward(Player player) {
        player.setHealth(health);
    }
    
}
