package com.example.lab4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ListViewHolder extends RecyclerView.ViewHolder {

    private TextView TVvarsta;
    private TextView TVnume;
    private TextView TVprenume;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        initializeViews();

    }

    private void initializeViews()
    {
        TVvarsta = itemView.findViewById(R.id.tv_row_list_varsta);
        TVnume = itemView.findViewById(R.id.tv_row_list_nume);
        TVprenume = itemView.findViewById(R.id.tv_row_list_prenume);
    }

    public void setValues(String nume, String prenume, int varsta)
    {
        TVvarsta.setText(String.valueOf(varsta));
        TVnume.setText(nume);
        TVprenume.setText(prenume);
    }

}
