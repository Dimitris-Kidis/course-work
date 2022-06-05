package com.dimitriskidis.AppleFinder.GameState;

public class Context {
    Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy () {
        strategy.collectItem();
    }
}
