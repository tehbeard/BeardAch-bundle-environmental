package com.tehbeard.beardach.addons.environmental;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.google.gson.annotations.Expose;

import me.tehbeard.BeardAch.achievement.Achievement;
import me.tehbeard.BeardAch.achievement.help.Argument;
import me.tehbeard.BeardAch.achievement.help.Usage;
import me.tehbeard.BeardAch.achievement.rewards.IReward;
import me.tehbeard.BeardAch.dataSource.configurable.Configurable;

@Configurable(tag="compass")
@Usage(arguments = { 
        @Argument(name="world",desc=""),
        @Argument(name="x",desc=""),
        @Argument(name="y",desc=""),
        @Argument(name="z",desc="")
}, packageName = "Environmental")
public class CompassTargetReward implements IReward {

    @Expose
    private Location l;

    public void configure(Achievement ach, String config) {
        String[] c = config.split(":");
        if(c.length!=4){
            throw new IllegalArgumentException("invalid compass config");
        }
        l = new Location(Bukkit.getWorld(c[0]),
                Double.parseDouble(c[1]),
                Double.parseDouble(c[2]),
                Double.parseDouble(c[3])
                
                );
        
    }

    public void giveReward(Player player) {
        player.setCompassTarget(l);
        
    }

}
