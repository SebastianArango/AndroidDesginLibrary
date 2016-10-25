package examplelibrarydesign.com.examplelibrarydesing;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import examplelibrarydesign.com.examplelibrarydesing.presenter.LoginPresenter;
import examplelibrarydesign.com.examplelibrarydesing.utils.ValidateFields;
import examplelibrarydesign.com.examplelibrarydesing.view.activity.LoginActivity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


/**
 * Created by sarango on 12/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginTest {


    @Test
    public void validateStringFromEditTextShouldReturnTrueIfAnyEmpty() {
        String email = "user1@gmail.com";
        String password = "";

        boolean validation = ValidateFields.validateString(email, password);
        assertTrue(validation);
    }

    @Test
    public void validateStringFromEditTextShouldReturnFalseIfNotHaveFieldEmpty() {
        String email = "user1@gmail.com";
        String password = "asdf1234";

        boolean validation = ValidateFields.validateString(email, password);
        assertFalse(validation);
    }

    @Test
    public void validateFormatOfEmailSendFromActivityShouldReturnFalseIfHaveError() {
        String email = "user1";
        boolean validateEmail = ValidateFields.validateEmailFormat(email);
        assertFalse(validateEmail);
    }

    @Test
    public void validateFormatOfEmailSendFromActivityShouldReturnTrueIfNotHaveError() {
        String email = "user1@gmail.com";
        boolean validateEmail = ValidateFields.validateEmailFormat(email);
        assertTrue(validateEmail);

    }

    @Test
    public void validateBooleanReturnForValidateFormatEmailForSendMessageErrorIfIsFalse() {

        String email = "user1@gom";
        LoginPresenter loginPresenter = new LoginPresenter(new Activity());
        boolean validateFormatEmail = loginPresenter.validateFormatEmail(email);

        assertFalse("Error", validateFormatEmail);
    }
}
