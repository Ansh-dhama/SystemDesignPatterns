package org.example.StrategyPattern;

import org.example.StrategyPattern.Interface.Talkable;

public class NoTalk implements Talkable {


    @Override
    public void talk() {
        System.out.println("robot is not talking");
    }
}
