package examplelibrarydesign.com.examplelibrarydesing.view.interface_view;

import android.content.DialogInterface;

/**
 * Created by sarango on 12/10/2016.
 */

public interface BaseInterface {

    void createProgressDialog();

    void showProgressDialog(String message);

    void hideProgressDialog();

    void createAlertDialog();

    void showAlertDialog(String titleAlert, String message, String buttonPositive, String buttonNegative,
                         DialogInterface.OnClickListener onClickListenerButtonPositive,
                         DialogInterface.OnClickListener onClickListenerButtonNegative);

}
