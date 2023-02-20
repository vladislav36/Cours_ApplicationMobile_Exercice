package com.example.superrecycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ObjetAdapter extends RecyclerView.Adapter<ObjetAdapter.MyViewHolder> {

    public List<Secret> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvNom;
        public TextView tvAge;

        public TextView tvDate;
        public MyViewHolder(LinearLayout v) {
            super(v);
            tvNom = v.findViewById(R.id.tvNom);
            tvAge = v.findViewById(R.id.tvAge);
            tvDate = v.findViewById(R.id.tvDate);
        }
    }

    public ObjetAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public ObjetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.objet_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        Log.i("DEBOGAGE", "appel a onCreateViewHolder");
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Secret objetCourant = list.get(position);
        holder.tvNom.setText(objetCourant.nom);
        holder.tvAge.setText(""+objetCourant.nbGrand);
        holder.tvDate.setText(""+objetCourant.Time);// TODO setText sur un integer crash
        Log.i("DEBOGAGE", "appel a onBindViewHolder " + position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
