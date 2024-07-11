package com.dreamsoft.kyc.entities.enumerations;

public enum IdType {
    NATIONAL_ID_CARD("National ID card"),
    PASSPORT("Passport"),
    PAN_CARD("PAN card"),
    VOTER_CARD("Voter card"),
    DRIVING_LICENCE("Driving license"),
    COG_ID("Central or state government ID"),
    LFRPAS("Letter from a recognized public authority or servan"),
    BANKING_BOOK("Banking book with photo ID"),
    EMPLOYEE_ID_CARD("Employee ID card"),
    EDUCATION_ID_CARD("University or education ID card");

    private String desc;
    IdType(String desc){
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }
}
