package com.zhitar.xml.example;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XmlDateAdapter extends XmlAdapter<String, Date> {

    public static final String DATE_PATTERN = "dd.MM.yyyy";

    private final DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }
}
