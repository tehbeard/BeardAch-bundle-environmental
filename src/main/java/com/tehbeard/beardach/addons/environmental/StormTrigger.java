package com.tehbeard.beardach.addons.environmental;

import org.bukkit.entity.Player;

import com.google.gson.annotations.Expose;

import me.tehbeard.BeardAch.achievement.Achievement;
import me.tehbeard.BeardAch.achievement.help.Argument;
import me.tehbeard.BeardAch.achievement.help.Usage;
import me.tehbeard.BeardAch.achievement.triggers.ITrigger;
import me.tehbeard.BeardAch.dataSource.configurable.Configurable;

@Configurable(tag="storm")
@Usage(arguments = { @Argument(name="stormy",desc="Wether to trigger if it's stormy") }, packageName = "Environmental")
public class StormTrigger implements ITrigger {

    @Expose
    private boolean isStormy;
    
    public void configure(Achievement arg0, String config) {
        if(config.equalsIgnoreCase("true")){
            isStormy = true;
        }
        
        if(config.equalsIgnoreCase("false")){
            isStormy = false;
        }
        throw new IllegalArgumentException("invalid value for storm");
        
    }

    public boolean checkAchievement(Player p) {
       
        return p.getWorld().hasStorm() == isStormy;
    }

}
