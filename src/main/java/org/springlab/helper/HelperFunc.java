package org.springlab.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springlab.config.constant.Constant;

public class HelperFunc {
    public static Date getFormartedDate(String dateText) throws ParseException {
        if (dateText == null) {
            return null;
        }

        SimpleDateFormat dateFormatter = new SimpleDateFormat(Constant.DATE_FORMAT);
        Date formatedDate;

        formatedDate = dateFormatter.parse(dateText);
        if (formatedDate == null) {
            throw new ParseException("Date is null", 1);
        }

        return formatedDate;
    }
}