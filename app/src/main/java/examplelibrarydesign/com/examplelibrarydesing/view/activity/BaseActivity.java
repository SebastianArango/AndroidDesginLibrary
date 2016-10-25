package examplelibrarydesign.com.examplelibrarydesing.view.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import examplelibrarydesign.com.examplelibrarydesing.view.interface_view.BaseInterface;

/**
 * Created by sarango on 12/10/2016.
 */

public class BaseActivity extends AppCompatActivity implements BaseInterface {

    private AlertDialog.Builder alertDialog;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createAlertDialog();
    }


    @Override
    public void createProgressDialog() {
        progressDialog = new ProgressDialog(BaseActivity.this);
        progressDialog.setCancelable(false);
    }

    @Override
    public void showProgressDialog(String message) {
        progressDialog.setMessage(message);
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void createAlertDialog() {
        alertDialog = new AlertDialog.Builder(BaseActivity.this);
        alertDialog.setCancelable(false);
    }

    @Override
    public void showAlertDialog(final String titleAlert, final String message, final String buttonPositive, final String buttonNegative,
                                final DialogInterface.OnClickListener onClickListenerButtonPositive,
                                final DialogInterface.OnClickListener onClickListenerButtonNegative) {
        alertDialog.setTitle(titleAlert);
        alertDialog.setMessage(message);

        if (buttonNegative == null) {
            alertDialog.setNegativeButton(buttonPositive, onClickListenerButtonPositive);
        } else {
            alertDialog.setPositiveButton(buttonPositive, onClickListenerButtonPositive);
            alertDialog.setNegativeButton(buttonNegative, onClickListenerButtonNegative);
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.show();
            }
        });
    }
}
