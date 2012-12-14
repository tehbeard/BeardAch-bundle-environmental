package com.tehbeard.beardach.addons.environmental;

import org.bukkit.entity.Player;

import com.google.gson.annotations.Expose;

import me.tehbeard.BeardAch.achievement.Achievement;
import me.tehbeard.BeardAch.achievement.help.Argument;
import me.tehbeard.BeardAch.achievement.help.Usage;
import me.tehbeard.BeardAch.achievement.rewards.IReward;
import me.tehbeard.BeardAch.dataSource.configurable.Configurable;

@Configurable(tag="ignite")
@Usage(arguments = { @Argument(name="ticks",desc="number of ticks to set player on fire for") }, packageName = "Environmental")
public class IgnitionReward implements IReward {

    @Expose
    int ticks;

    public void configure(Achievement arg0, String config) {
        ticks = Integer.parseInt(config);
        
    }

    public void giveReward(Player player) {
        player.setFireTicks(ticks);
    }
    
}
