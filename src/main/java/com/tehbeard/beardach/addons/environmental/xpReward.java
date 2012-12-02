package com.tehbeard.beardach.addons.environmental;

import org.bukkit.entity.Player;

import me.tehbeard.BeardAch.achievement.Achievement;
import me.tehbeard.BeardAch.achievement.help.Argument;
import me.tehbeard.BeardAch.achievement.help.Usage;
import me.tehbeard.BeardAch.achievement.rewards.IReward;
import me.tehbeard.BeardAch.dataSource.configurable.Configurable;

@Configurable(tag="xp")
@Usage(arguments = { @Argument(name="amount",desc="amount of xp to give") }, packageName = "Environmental")
public class xpReward implements IReward {

    int xp;

    public void configure(Achievement arg0, String config) {
        xp = Integer.parseInt(config);
        
    }

    public void giveReward(Player player) {
        player.giveExp(xp);
    }
    
}
