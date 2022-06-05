package com.dimitriskidis.AppleFinder.GameState;

import com.dimitriskidis.AppleFinder.Manager.GameStateManager;

public class StateFactory {

    public StateFactory createState(int i, GameStateManager state, GameState[] gameStates) {
        if (i == GameStateManager.INTRO) {
            gameStates[i] = new IntroState(state);
            gameStates[i].init();
        } else if (i == GameStateManager.MENU) {
            gameStates[i] = new MenuState(state);
            gameStates[i].init();
        } else if (i == GameStateManager.PLAY) {
            gameStates[i] = new PlayState(state);
            gameStates[i].init();
        } else if (i == GameStateManager.GAMEOVER) {
            gameStates[i] = new GameOverState(state);
            gameStates[i].init();
        }

        return null;
    }
}
