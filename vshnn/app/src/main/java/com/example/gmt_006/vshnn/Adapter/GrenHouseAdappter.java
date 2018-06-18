package com.example.gmt_006.vshnn.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmt_006.vshnn.Activity.GreenHouseMainActivity;
import com.example.gmt_006.vshnn.Activity.MainActivity;
import com.example.gmt_006.vshnn.Model.GrenHouse;
import com.example.gmt_006.vshnn.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GrenHouseAdappter extends RecyclerView.Adapter<GrenHouseAdappter.GreenHouseViewHolder>{
    public ArrayList<GrenHouse> mData = new ArrayList<>();
    public LayoutInflater layoutInflater;
    public GreenHouseMainActivity mainActivity;
    private Activity mActivity;

    public GrenHouseAdappter(GreenHouseMainActivity activity, int with, ArrayList<GrenHouse> mData) {
        this.mData = mData;
        this.mainActivity = activity;
        layoutInflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public GreenHouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.streamgreenhouse,null);
        GreenHouseViewHolder itemholder = new GreenHouseViewHolder(view);
        return itemholder;
    }

    @Override
    public void onBindViewHolder(@NonNull GreenHouseViewHolder holder, int position) {
            GrenHouse grenHouse = mData.get(position);
            holder.tvName.setText("Name of The green huose: "+grenHouse.getName());
            Picasso.get().load("http://demo.ilyra.vn/images/"+grenHouse.getImage()).placeholder(R.drawable.logo).error(R.drawable.asdas).into(holder.hinhgreenhuose);
            holder.tvId.setText("ID: "+grenHouse.getId().toString());
            holder.tvProvince.setText("Province: "+grenHouse.getProvince_id().toString());
            holder.tvAdress.setText("Address: "+grenHouse.getAddress());
    }

    @Override
    public int getItemCount() {
        if(mData == null || mData.isEmpty()){
            return 0;
        }
        else {
            return mData.size();
        }

    }


    public class GreenHouseViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName,tvId,tvProvince,tvAdress;
        public ImageView hinhgreenhuose;
        public GreenHouseViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_namegreenhouse);
            hinhgreenhuose = itemView.findViewById(R.id.item_imggreenhouse);
            tvId = itemView.findViewById(R.id.txtid);
            tvProvince = itemView.findViewById(R.id.txtprovinceid);
            tvAdress = itemView.findViewById(R.id.txtaddress);
        }
    }
}
