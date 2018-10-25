package com.leopard.tehrancarapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.leopard.tehrancarapp.R;
import com.leopard.tehrancarapp.model.Car;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CarsRecyclerView extends
        RecyclerView.Adapter<CarsRecyclerView.ViewHolder> {

    private static final String TAG = CarsRecyclerView.class.getSimpleName();

    private Context context;
    private List<Car> list;
    private View.OnClickListener onItemClickListener;

    public CarsRecyclerView(Context context, List<Car> list,
                            View.OnClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Todo Butterknife bindings
        @BindView(R.id.textview_car_name)
        TextView textviewCarName;
        @BindView(R.id.textview_car_factory)
        TextView textviewCarFactory;
        @BindView(R.id.textview_car_kilometer)
        TextView textviewCarKilometer;
        @BindView(R.id.textview_car_price)
        TextView textviewCarPrice;
        @BindView(R.id.button_car_delete)
        Button buttonCarDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_layout_car, parent, false);
        ButterKnife.bind(this, view);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Car item = list.get(position);
        holder.textviewCarName.setText(item.getName());
        holder.textviewCarFactory.setText(item.getFactory());
        holder.textviewCarKilometer.setText(item.getKilometer());
        holder.textviewCarPrice.setText(item.getPrice());
        //Todo: Setup viewholder for item
        holder.buttonCarDelete.setOnClickListener(onItemClickListener);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}