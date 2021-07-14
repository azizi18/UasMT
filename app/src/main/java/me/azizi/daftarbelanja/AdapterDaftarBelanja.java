package me.azizi.daftarbelanja;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterDaftarBelanja extends RecyclerView.Adapter<AdapterDaftarBelanja.DaftarViewHolder> {

    private List<DaftarBelanja> daftarBelanjaList = new ArrayList<>();

    public void setDaftarBelanjas(List<DaftarBelanja> daftarBelanjaList) {
        this.daftarBelanjaList = daftarBelanjaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DaftarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_belanja, parent, false);
        return new DaftarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarViewHolder holder, int position) {
        DaftarBelanja daftarBelanja = daftarBelanjaList.get(position);

        holder.tvName.setText(daftarBelanja.getNama());
        holder.tvBanyak.setText(String.valueOf(daftarBelanja.getBanyak()));
    }

    @Override
    public int getItemCount() {
        return daftarBelanjaList.size();
    }

    public class DaftarViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvBanyak;
        public DaftarViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNama);
            tvBanyak = itemView.findViewById(R.id.tvBanyak);
        }
    }
}
