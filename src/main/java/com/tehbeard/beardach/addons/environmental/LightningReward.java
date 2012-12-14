package com.tehbeard.beardach.addons.environmental;

import org.bukkit.World;
import org.bukkit.entity.Player;

import com.google.gson.annotations.Expose;

import me.tehbeard.BeardAch.achievement.Achievement;
import me.tehbeard.BeardAch.achievement.help.Argument;
import me.tehbeard.BeardAch.achievement.help.Usage;
import me.tehbeard.BeardAch.achievement.rewards.IReward;
import me.tehbeard.BeardAch.dataSource.configurable.Configurable;

@Configurable(tag="lightning")
@Usage(arguments = { @Argument(name="real",desc="Whether to use real or fake lightning") }, packageName = "Environmental")
public class LightningReward implements IReward {

    @Expose
    private boolean real;
    
    public void configure(Achievement ach, String config) {
        if(config.equalsIgnoreCase("true")){
            real = true;
        }
        
        if(config.equalsIgnoreCase("false")){
            real = false;
        }
        throw new IllegalArgumentException("invalid value for lightning");
    }

    public void giveReward(Player player) {
        World world = player.getWorld();
        if(real){
            world.strikeLightning(player.getLocation());
        }else{
            world.strikeLightningEffect(player.getLocation());
        }
        
    }

     
}
