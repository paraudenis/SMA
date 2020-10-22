package com.example.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<ListModel> ListModel_List;

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.row_list_example, parent, false);
        return new ListViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListModel listModel = ListModel_List.get(position);
        holder.setValues(listModel.getNume(),listModel.getPrenume(),listModel.getVarsta());
    }

    public ListAdapter(List<ListModel> listModel_List) {
        this.ListModel_List = listModel_List;
    }

    @Override
    public int getItemCount() {
        return ListModel_List.size();
    }
}
