package com.example.srm_ez2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_Upcoming extends FirebaseRecyclerAdapter<upcoming_model,Adapter_Upcoming.myView> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapter_Upcoming(@NonNull FirebaseRecyclerOptions<upcoming_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myView holder, int position, @NonNull upcoming_model model) {
        holder.title.setText(model.getTitle());
        holder.date.setText(model.getDate());
        holder.time.setText(model.getTime());
        holder.reg.setText(model.getReg());
        Glide.with(holder.image.getContext())
                .load(model.getImage())
                .placeholder(R.drawable.loading_svgrepo_com)
                .error(R.drawable.loading_svgrepo_com)
                .into(holder.image);
    }

    @NonNull
    @Override
    public myView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_card_design,parent,false);
        return new myView(view);
    }

    class myView extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, time,date,reg;

        public myView(@NonNull View itemView) {
            super(itemView);

            image =(ImageView)itemView.findViewById(R.id.upcoming_image);
            title = (TextView) itemView.findViewById(R.id.upcoming_text);
            date = (TextView) itemView.findViewById(R.id.date_fire);
            time = (TextView) itemView.findViewById(R.id.time_fire);
            reg = (TextView) itemView.findViewById(R.id.reg_fire);
        }
    }
}