package org.example.StrategyPattern.robot;

import org.example.StrategyPattern.Interface.Flyable;
import org.example.StrategyPattern.Interface.Talkable;
import org.example.StrategyPattern.Interface.Walkable;
import org.example.StrategyPattern.noFly;
import org.example.StrategyPattern.noWalk;
import org.example.StrategyPattern.normalTalk;

public class Robot {
    Walkable walkable;
    Flyable flyable;
    Talkable talkable;
    public Robot(Walkable walkable, Flyable flyable, Talkable talkable) {
        this.walkable = walkable;
        this.flyable =  flyable;
        this.talkable = talkable;
    }
}
