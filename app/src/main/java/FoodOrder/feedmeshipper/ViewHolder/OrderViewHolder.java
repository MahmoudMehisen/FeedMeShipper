package FoodOrder.feedmeshipper.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import FoodOrder.feedmeshipper.R;
import info.hoang8f.widget.FButton;

public class OrderViewHolder extends RecyclerView.ViewHolder{

    public TextView orderId,orderStatus,orderPhone, orderDate;
    public FButton btnShipping;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        orderId = (TextView) itemView.findViewById(R.id.orderId);
        orderPhone = (TextView) itemView.findViewById(R.id.orderPhone);
        orderStatus = (TextView) itemView.findViewById(R.id.orderStatus);
        orderDate = (TextView) itemView.findViewById(R.id.order_date);


        btnShipping = (FButton)itemView.findViewById(R.id.btnShipping);
    }
}
