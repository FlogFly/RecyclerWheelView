package com.example.recyclewheelview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclewheelview.bean.OperationBean;

import java.util.List;

/**
 * Project:RecycleWheelView
 * Author:dyping
 * Date:2017/7/11 13:40
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context mContext;
    List<OperationBean> list;

    public ItemAdapter(Context mContext, List<OperationBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_operation, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.itemName.setText(list.get(position % list.size()).getName());
        holder.itemMoeny.setText(list.get(position % list.size()).getMoney());
        holder.itemYearPercent.setText(list.get(position % list.size()).getYearPercent());
        holder.itemYearCompletePercent.setText(list.get(position % list.size()).getYearCompletePercent());
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class ItemViewHolder extends ViewHolder {
        TextView itemName;
        TextView itemMoeny;
        TextView itemYearPercent;
        TextView itemYearCompletePercent;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemMoeny = (TextView) itemView.findViewById(R.id.money);
            itemYearPercent = (TextView) itemView.findViewById(R.id.year_to_year);
            itemYearCompletePercent = (TextView) itemView.findViewById(R.id.year_complete);
        }
    }
}
