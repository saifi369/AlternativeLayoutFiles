package com.example.alternativelayoutfiles.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alternativelayoutfiles.DetailsActivity;
import com.example.alternativelayoutfiles.R;
import com.example.alternativelayoutfiles.model.CityDataItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyViewHolder> {

    private List<CityDataItem> mDataList;
    private Context mContext;

    public MyDataAdapter(List<CityDataItem> mDataList, Context mContext) {
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.list_item_layout,parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("meratag", "onBindViewHolder: size: "+mDataList.size());

        CityDataItem cityDataItem=mDataList.get(position);

        holder.textView.setText((position+1)+cityDataItem.getCityName());

        InputStream inputStream=null;
        try{
            inputStream = mContext.getAssets().open(cityDataItem.getImage());
            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
            holder.imageView.setImageBitmap(bitmap);
            Log.d("meratag", "getView: Image Downloaded: "+cityDataItem.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (inputStream == null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(mContext, DetailsActivity.class);
            intent.putExtra("data_key",cityDataItem);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
