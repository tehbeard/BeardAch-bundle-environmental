package com.tehbeard.beardach.addons.environmental;

import org.bukkit.entity.Player;

import me.tehbeard.BeardAch.achievement.Achievement;
import me.tehbeard.BeardAch.achievement.help.Argument;
import me.tehbeard.BeardAch.achievement.help.Usage;
import me.tehbeard.BeardAch.achievement.triggers.ITrigger;
import me.tehbeard.BeardAch.dataSource.configurable.Configurable;


@Configurable(tag="time")
@Usage(arguments = { 
        @Argument(name="after",desc="Must be after this time"),
        @Argument(name="before",desc="Must be before this time")
        }, packageName = "Environmental")
public class TimeTrigger implements ITrigger {

    long after = 0;
    long  before = 0;
    public void configure(Achievement ach, String config) {
        String[] c = config.split(":");
        after      = Integer.parseInt(c[0]);
        before     = Integer.parseInt(c[1]);
        
    }

    public boolean checkAchievement(Player p) {
        Long t = p.getWorld().getTime();
        return after<before ? (after < t && before > t) : (after < t || before > t);
    }

}
/*

After: 22000
before: 9000
t: 6000
a<t : F
b>t : T
||  T

After: 2000
before: 9000
t: 5000
a<t : T
b>t : T
&&  T



After: 22000
before: 9000
t: 10000
a<t : F
b>t : F
||  F

After: 2000
before: 9000
t: 10000
a<t : T
b>t : F
&&  T

*/