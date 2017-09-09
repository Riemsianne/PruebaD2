package cl.riemsianne.pruebadlatam2.adpters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.riemsianne.pruebadlatam2.PreferenceClickListener;
import cl.riemsianne.pruebadlatam2.R;
import cl.riemsianne.pruebadlatam2.data.Queries;
import cl.riemsianne.pruebadlatam2.models.Preference;



public class PreferencesAdapter extends RecyclerView.Adapter<PreferencesAdapter.ViewHolder> {

    private List<Preference> preferences = new Queries().prefers();
    private PreferenceClickListener listener;

    public PreferencesAdapter(PreferenceClickListener listener) {
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_preferences, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Preference preference = preferences.get(position);
        holder.textView2.setText(preference.getPlatform());
        holder.textview.setText(preference.getGame());

        holder.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int auxPosition = holder.getAdapterPosition();
                        Preference auxPreference = preferences.get(auxPosition);
                        auxPreference.setDone(true);
                        auxPreference.save();
                        preferences.remove(auxPosition);
                        notifyItemRemoved(auxPosition);

                    }
                }, 400);
            }
        });


        holder.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preference auxPreference = preferences.get(holder.getAdapterPosition());
                listener.transporting(auxPreference);


            }
        });


    }

    @Override
    public int getItemCount() {
        return preferences.size();
    }

    public void update(Preference preference) {
        preferences.add(preference);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textview;
        private TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);

            textview = (TextView) itemView.findViewById(R.id.preferenceTv);
            textView2 = (TextView) itemView.findViewById(R.id.preferenceTv2);
        }


    }



    }
