package cl.riemsianne.pruebadlatam2.data;

import java.util.ArrayList;
import java.util.List;

import cl.riemsianne.pruebadlatam2.models.Preference;

/**
 * Created by Riemsianne on 28-08-2017.
 */

public class Queries {
    public List<Preference> prefers() {
        List<Preference> prefers = new ArrayList<>();
        List<Preference> preferList = Preference.find(Preference.class,"done = 0");
        //List<Preference> preferList = Preference.listAll(Preference.class);
        if(preferList != null && preferList.size() > 0){
            prefers.addAll(preferList);
        }
        return prefers;
    }
}
