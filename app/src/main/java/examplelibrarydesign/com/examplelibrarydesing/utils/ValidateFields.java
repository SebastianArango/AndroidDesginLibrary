package examplelibrarydesign.com.examplelibrarydesing.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sarango on 12/10/2016.
 */

public class ValidateFields {


    public static boolean validateString(String... field) {

        for (String data : field) {
            if (data.trim().equals(""))
                return true;
        }

        return false;
    }

    public static boolean validateEmailFormat(String email) {

        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        return mather.find();

    }
}
