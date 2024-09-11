package bo.com.ahosfot.patterns.behavior.state.states;

import bo.com.ahosfot.patterns.behavior.state.ui.Player;

public class PlayingState extends State {

    PlayingState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop Playing";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused...";
    }

    @Override
    public String onNext() {
        return player.nexTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
