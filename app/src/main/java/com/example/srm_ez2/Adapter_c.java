package com.example.srm_ez2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_c extends FirebaseRecyclerAdapter<Club_Model,Adapter_c.viewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapter_c(@NonNull FirebaseRecyclerOptions<Club_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Club_Model model) {
        holder.name.setText(model.getC_name());
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
        TextView name,des;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img2 = (CircleImageView)itemView.findViewById(R.id.img2);
            name = (TextView)itemView.findViewById(R.id.c_name);
            des = (TextView)itemView.findViewById(R.id.c_des);
        }
    }
}
