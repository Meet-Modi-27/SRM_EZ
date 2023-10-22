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


public class Adapter_t extends FirebaseRecyclerAdapter<Model, Adapter_t.myViewHolder> implements t_interface {
    private String query = "";

    public Adapter_t(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Model model) {
        if (model.getName().toLowerCase().contains(query.toLowerCase())) {
            holder.bind(model);
        } else {
            holder.hide();
        }
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new myViewHolder(view);
    }

    public void filter(String newQuery) {
        query = newQuery;
        notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

    }

    class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView Name, Course, Email, Room;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img1);
            Name = itemView.findViewById(R.id.nametxt);
            Course = itemView.findViewById(R.id.coursetxt);
            Email = itemView.findViewById(R.id.emailtxt);
            Room = itemView.findViewById(R.id.roomtxt);
        }

        public void bind(Model model) {
            Name.setText(model.getName());
            Course.setText(model.getCourse());
            Email.setText(model.getEmail());
            Room.setText(model.getRoom());

            Glide.with(img.getContext())
                    .load(model.getSurl())
                    .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                    .circleCrop()
                    .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                    .into(img);
            
        }

        public void hide() {
            itemView.setVisibility(View.GONE);
            itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }
    }
}

