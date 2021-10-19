package com.example.hairdresser_new;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NestedAdapter extends RecyclerView.Adapter <NestedAdapter.NestViewHolder> {

    private List<String> mList;

    public NestedAdapter(List<String> mList){
        this.mList = mList;
    }

    @NonNull
    @Override
    public NestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item,parent,false);
       return  new NestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestViewHolder holder, int position) {
    holder.mTv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NestViewHolder extends  RecyclerView.ViewHolder{
        private TextView mTv;
        public NestViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.nestedItemTv);
        }
    }

}
