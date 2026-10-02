package org.example.Projects.musicSystem.manager;


import org.example.Projects.musicSystem.CustomQueuePlayStrategy;
import org.example.Projects.musicSystem.Interface.PlayStrategy;
import org.example.Projects.musicSystem.RandomPlayStrategy;
import org.example.Projects.musicSystem.SequentialPlayStrategy;
import org.example.Projects.musicSystem.enums.StrategyType;

public class StrategyManager {
    private static StrategyManager instance;

    private StrategyManager() {}

    public static synchronized StrategyManager getInstance() {
        if (instance == null) {
            instance = new StrategyManager();
        }
        return instance;
    }

    public PlayStrategy getStrategy(StrategyType type) {
        switch (type) {
            case SEQUENTIAL:
                return new SequentialPlayStrategy();
            case RANDOM:
                return new RandomPlayStrategy();
            case CUSTOM:
                return new CustomQueuePlayStrategy();
            default:
                return new SequentialPlayStrategy();
        }
    }
}