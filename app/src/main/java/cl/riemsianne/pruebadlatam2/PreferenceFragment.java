package cl.riemsianne.pruebadlatam2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.prefs.Preferences;

import cl.riemsianne.pruebadlatam2.adpters.PreferencesAdapter;
import cl.riemsianne.pruebadlatam2.models.Preference;


public class PreferenceFragment extends Fragment implements PreferenceClickListener {

    private  PreferencesAdapter adapter;

    public PreferenceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.preferenceRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PreferencesAdapter(this);
        recyclerView.setAdapter(adapter);


    }

    public void updateList(Preference preference){
        adapter.update(preference);
        Log.d("preference",preference.getGame());
    }


    @Override
    public void transporting(Preference preference) {
        Intent intent = new Intent(getActivity(),DetailsActivity.class);
        intent.putExtra("prefer", preference.getGame());
        getActivity().startActivity(intent);
    }
}






