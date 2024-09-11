package bo.com.ahosfot.patterns.behavior.state.states;

import bo.com.ahosfot.patterns.behavior.state.ui.Player;

public abstract class State {
    Player player;

    State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
