package org.example.StrategyPattern.robot;

import org.example.StrategyPattern.*;
import org.example.StrategyPattern.Interface.Flyable;
import org.example.StrategyPattern.Interface.Talkable;
import org.example.StrategyPattern.Interface.Walkable;

public class main {
    public static void main(String[] args) {
       Robot robo1 = new Robot(new normalWalk(),new nowmalFly(), new normalTalk());

       robo1.flyable.fly();
       robo1.walkable.walk();
       robo1.talkable.talk();

    }
}
