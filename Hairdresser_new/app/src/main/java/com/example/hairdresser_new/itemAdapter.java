package com.example.hairdresser_new;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ItemViewHolder> {

    private List<DataModel> mlist;
    private List<String> list = new ArrayList<>();

    public itemAdapter(List<DataModel> mlist){
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item, parent ,false);
        return  new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
       DataModel model = mlist.get(position);
       holder.mTextView.setText(model.getItemText());

       boolean isExpandable = model.isExpandable();
       holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

       if (isExpandable){
           holder.mArrowImage.setImageResource(R.drawable.ic_baseline_expand_less_24);

       }else {
           holder.mArrowImage.setImageResource(R.drawable.ic_baseline_expand_more_24);
       }


       NestedAdapter adapter = new NestedAdapter(list);
       holder.nestedRecyclerview.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
       holder.nestedRecyclerview.setHasFixedSize(true);
       holder.nestedRecyclerview.setAdapter(adapter);
       holder.linearLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               model.setExpandable(!model.isExpandable());
               list = model.getNestedList();
               notifyItemChanged(holder.getAdapterPosition());

           }
       });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public  class  ItemViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout linearLayout;
        private RelativeLayout expandableLayout;
        private TextView mTextView;
        private ImageView mArrowImage;
        private RecyclerView nestedRecyclerview;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            mTextView = itemView.findViewById(R.id.itemTv);
            mArrowImage = itemView.findViewById(R.id.arro_imageview);
            nestedRecyclerview = itemView.findViewById(R.id.child_rv);
        }
    }
}
