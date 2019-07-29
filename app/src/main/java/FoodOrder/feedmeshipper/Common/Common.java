package FoodOrder.feedmeshipper.Common;

import java.util.Calendar;
import java.util.Locale;

import FoodOrder.feedmeshipper.Model.Shipper;

public class Common {
    public static final String SHIPPER_TABLE = "Shippers";
    public static final String ORDER_NEED_SHIP_TABLE = "OrdersNeedShip";

    public static final int REQUEST_CODE = 1000;

    public static Shipper currentShipper;

    public static String convertCodeToStatus(String status) {
        if (status.equals("0"))
            return "Placed";
        else if (status.equals("1"))
            return "In my way";
        else
            return "Shipping";
    }

    public static String getDate(long time){
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(
                android.text.format.DateFormat.format("dd-MM-yyyy HH:mm", calendar).toString());

        return date.toString();

    }



}
