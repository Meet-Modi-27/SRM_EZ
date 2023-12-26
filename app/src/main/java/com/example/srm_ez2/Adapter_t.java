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


public class Adapter_t extends FirebaseRecyclerAdapter<Model, Adapter_t.myViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapter_t(@NonNull FirebaseRecyclerOptions<Model> options,RecyclerViewInterface recyclerViewInterface) {
        super(options);
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Model model) {
        holder.Name.setText(model.getName());
        holder.Course.setText(model.getCourse());
        holder.Email.setText(model.getEmail());
        holder.Room.setText(model.getRoom());

        Glide.with(holder.img.getContext())
                .load(model.getSurl())
                .placeholder(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView Name, Course, Email, Room;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView) itemView.findViewById(R.id.img1);
            Name = (TextView) itemView.findViewById(R.id.nametxt);
            Course = (TextView) itemView.findViewById(R.id.coursetxt);
            Email = (TextView) itemView.findViewById(R.id.emailtxt);
            Room = (TextView) itemView.findViewById(R.id.roomtxt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        String name = Name.getText().toString();
                        recyclerViewInterface.onItemClick(name);
                    }
                }
            });
        }

    }
}