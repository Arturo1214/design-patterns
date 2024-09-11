package bo.com.ahosfot.patterns.behavior.state.ui;

import bo.com.ahosfot.patterns.behavior.state.states.ReadyState;
import bo.com.ahosfot.patterns.behavior.state.states.State;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Player {
    @Getter
    private State state;
    @Getter @Setter
    private boolean playing = false;
    private List<String> playList = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i  = 1; i < 12; i++) {
            playList.add("Track " + i);
        }

    }

    public void changeState(State state) {
        this.state = state;
    }

    public String startPlayback() {
        return "Playing " + playList.get(currentTrack);
    }

    public String nexTrack() {
        currentTrack++;
        if (currentTrack > playList.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playList.size() - 1;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
