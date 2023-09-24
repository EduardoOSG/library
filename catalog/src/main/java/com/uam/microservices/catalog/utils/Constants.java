package com.uam.microservices.catalog.utils;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Locale;

public class Constants implements Serializable {
    private static final long serialVersionUID = 450523432343613423L;

    public static final String MESSAGE_ERROR_ROGISTRATION_CODE_DUPLICATED = "There is already an employee record with that registration code";
    public static final String MESSAGE_ERROR_REQUIERED_REQUEST = "The entity %s is not valid.";
    public static final String MESSAGE_ERROR_INVALID_EMAIL = "invalid email structure";
    public static final String MESSAGE_ERROR_GENERIC_ERROR = "An error occurred on the server.";
    public static final String MENSSAGE_ERROR_CONSULT_EMPLOYEE = "An error occurred while querying the employee.";
    public static final String MENSSAGE_ERROR_CONSULT_GENDER = "An error occurred while querying the gender.";

    public static final Locale LOCALE_MX = new Locale("es", "MX");
    public static final ZoneId TIME_ZONE_MX = ZoneId.of("UTC-06:00");
    public static final String MENSSAGE_ERROR_REQUIRED = "parameter is required:%s";
    public static final String MENSSAGE_ERROR_EXIST = "There is already a record for id:%s";
    public static final String MENSSAGE_ERROR_NOT_EXIST = "There is no record %s ";
    public static final String MENSSAGE_ERROR_NOT_SAVE = "Failed to save record\n";

}
