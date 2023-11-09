package com.example.srm_ez2;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_c extends FirebaseRecyclerAdapter<Club_Model,Adapter_c.viewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapter_c(@NonNull FirebaseRecyclerOptions<Club_Model> options, RecyclerViewInterface recyclerViewInterface) {
        super(options);
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Club_Model model) {
        holder.Name.setText(model.getC_name());
        holder.des.setText(model.getDes());

        Glide.with(holder.img2.getContext())
                .load(model.getSurl())
                .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img2);
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_layout,parent,false);
        return new viewHolder(view);
    }

    class viewHolder extends RecyclerView.ViewHolder{
        CircleImageView img2;
        TextView Name,des;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img2 = (CircleImageView)itemView.findViewById(R.id.img2);
            Name = (TextView)itemView.findViewById(R.id.c_name);
            des = (TextView)itemView.findViewById(R.id.c_des);

            itemView.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        String name= Name.getText().toString();
                        recyclerViewInterface.onItemClick(name);
                    }
                }
            });
        }
    }
}
