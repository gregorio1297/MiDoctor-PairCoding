package com.example.midoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaMedAdap extends RecyclerView.Adapter<ListaMedAdap.MedViewHold> {

    ArrayList<Med> listamedicamentos;
    public ListaMedAdap(ArrayList<Med> listamedicamentos){
        this.listamedicamentos=listamedicamentos;
    }

    @NonNull
    @Override
    public MedViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_medicamentos,null,false);
        return new MedViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedViewHold holder, int position) {
        holder.viewNombreMed.setText(listamedicamentos.get(position).getNombremed());
        holder.viewHoraMed.setText(listamedicamentos.get(position).getHoramed());
    }

    @Override
    public int getItemCount() {
        return listamedicamentos.size();
    }

    public class MedViewHold extends RecyclerView.ViewHolder {
        TextView viewNombreMed, viewHoraMed;

        public MedViewHold(@NonNull View itemView) {
            super(itemView);

            viewNombreMed = itemView.findViewById(R.id.viewNombreMed);
            viewHoraMed=itemView.findViewById(R.id.viewHoraMed);

        }
    }
}
