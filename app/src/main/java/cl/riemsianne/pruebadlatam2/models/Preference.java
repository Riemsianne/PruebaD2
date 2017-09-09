package cl.riemsianne.pruebadlatam2.models;

import com.orm.SugarRecord;

/**
 * Created by Riemsianne on 28-08-2017.
 */

public class Preference extends SugarRecord {
    private String platform, game;
    private boolean done;

    public Preference() {
    }

    public Preference(String platform, String game, boolean done) {
        this.platform = platform;
        this.game = game;
        this.done = done;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


}
