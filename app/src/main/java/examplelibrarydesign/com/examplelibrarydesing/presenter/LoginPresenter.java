package examplelibrarydesign.com.examplelibrarydesing.presenter;

import android.content.Context;
import android.content.DialogInterface;

import examplelibrarydesign.com.examplelibrarydesing.R;
import examplelibrarydesign.com.examplelibrarydesing.utils.ValidateFields;
import examplelibrarydesign.com.examplelibrarydesing.view.interface_view.LoginInterface;

/**
 * Created by sarango on 12/10/2016.
 */

public class LoginPresenter {

    private LoginInterface loginInterface;

    public LoginPresenter(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    public void validateStringsOfEditText(String email, String password, Context context) {
        boolean stringIsEmpty = validateStrings(email, password);

        if (stringIsEmpty) {
            loginInterface.showAlertDialog(context.getResources().getString(R.string.title_general_dialog),
                    context.getResources().getString(R.string.message_error_empty_field),
                    context.getResources().getString(R.string.button_ok), null, onClickButtonPositive(), null);
        } else {

            if (validateFormatEmail(email)) {
                loginInterface.callNextActivity();
            } else {
                loginInterface.showAlertDialog(context.getResources().getString(R.string.title_general_dialog),
                        context.getResources().getString(R.string.message_error_email),
                        context.getResources().getString(R.string.button_ok), null, onClickButtonPositive(), null);
            }
        }
    }

    public boolean validateFormatEmail(String email) {
        return ValidateFields.validateEmailFormat(email);
    }

    private boolean validateStrings(String email, String password) {
        return ValidateFields.validateString(email, password);
    }

    private DialogInterface.OnClickListener onClickButtonPositive() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
    }
}
