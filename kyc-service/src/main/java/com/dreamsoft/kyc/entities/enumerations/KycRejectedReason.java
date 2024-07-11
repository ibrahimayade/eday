package com.dreamsoft.kyc.entities.enumerations;

public enum KycRejectedReason {
    DEFAULT_ERROR(9999, "Internal Error"),
    INVALID_TITLE(2011, "Invalid title "),
    NULL_TITLE(2012, "Parameter 'title' cannot be null."),
    TITLE_GENDER_MISMATCH(2013, "Gender - Title mismatch. Ex, customer with title Mr can not have gender Female"),
    NULL_GENDER(2014, "Parameter 'gender' cannot be null."),
    INVALID_GENDER(2015, "Invalid gender"),
    NULL_FIRST_NAME(2021, "Parameter 'firstName' cannot be null."),
    INVALID_FIRST_NAME(2022, "First name must be between 2 and 50 characters, start with an alphabet, and may contain only alphabet, space, and '."),
    INVALID_FIRST_NAME_WITH_ACCENT(2023, "First name must be between 2 and 50 characters, start with an alphabet, and may contain only alphabet, space, and '-."),
    NULL_LAST_NAME(2024, "Parameter 'lastName' cannot be null."),
    INVALID_LAST_NAME(2025, "Last name must be between 2 and 50 characters, start with an alphabet, and may contain only alphabet, space, and '."),
    INVALID_LAST_NAME_WITH_ACCENT(2026, "Last name must be between 2 and 50 characters, start with an alphabet, and may contain only alphabet, space, and '-."),
    NULL_DOB(2031, "Parameter 'dob' cannot be null."),
    INVALID_DOB(2032, "Invalid date or Invalid date format. yyyy-MM-dd is expected."),
    MINOR_AGE_DOB(2033, "Age must be 18 years or more"),
    NULL_ADDRESS_LINE1(2041, "Parameter 'addressLine1' cannot be null."),
    INVALID_ADDRESS_LINE1(2042, "address1 must start with an alphanumetic, must be between 2 and 40 characters, and may contain only alphanumerics, ., -, _, #, and spaces"),
    NULL_CITY(2043, "Parameter 'city' cannot be null."),
    INVALID_CITY(2044, "city must be between 2 and 40 characters, and may contain only alphanumerics, -, _, and spaces"),
    NULL_STATE(2045, "Parameter 'state' cannot be null."),
    INVALID_STATE(2046, "state code should be exactly 2 alphabetic characters"),
    NULL_ZIP_CODE(2047, "Parameter 'zipCode' cannot be null."),
    INVALID_ZIP_CODE(2048, "Zip code must be valid US zip code and exactly 5 digits long."),
    NULL_ID_NUMBER(2051, "Parameter 'ID Number' cannot be null."),
    INVALID_ID_NUMBER(2052, "ID Number must be exactly 9 digits."),
    ALREADY_USED_ID_NUMBER(2053, "Id Number already exists"),




    NULL_EMAIL(9001, "Parameter 'email' cannot be null."),
    INVALID_EMAIL(3002, "email is in incorrect format."),
    ALREADY_USED_EMAIL(1011, "Email address already in use by other customer"),
    NULL_PHONE_NUMBER(9001, "Parameter 'phoneNumber' cannot be null."),
    INVALID_PHONE_NUMBER(3002, "Invalid phone number."),
    ALREADY_USED_PHONE_NUMBER(1012, "Phone number already in use by other customer"),
    NULL_PASSWORD(9001, "Parameter 'password' cannot be null."),
    INVALID_PASSWORD(3002, "invalid password format"),
    INVALID_TYPE(3002, "The type must be either 'BUSINESS' or 'INDIVIDUAL'."),
    NULL_BUSINESS_NAME(9001, "Parameter 'businessName' cannot be null."),
    INVALID_BUSINESS_NAME(3002, "Business name must be between 2 and 150 characters, must contain atleast one alphabet, and may contain only numeric, space, _, and '-"),
    NULL_ESTABLISHED_DATE(9001, "Parameter 'establishedDate' cannot be null."),
    NULL_TIN(9001, "Parameter 'tin' cannot be null."),
    INVALID_TIN(3002, "Parameter 'tin' is in invalid format"),
    ALREADY_USED_TIN(1025, "TIN already exists");

    private int errorCode;
    private String message;

     KycRejectedReason(int errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    public static KycRejectedReason valueOf(long errorCode, String message) {
        for (KycRejectedReason error : KycRejectedReason.values()) {
            if (error.errorCode == errorCode && error.message.equalsIgnoreCase(message)) {
                return error;
            }
        }
        return DEFAULT_ERROR;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }


    }
