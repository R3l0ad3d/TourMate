package com.example.r3l0ad3d.tourmate.ModelClass;

/**
 * Created by r3l0ad3d on 5/4/17.
 */

public class Expences {
    private String userId;
    private String eventId;
    private String expenceResone;
    private String expenceAmount;
    private String expanceDate;
    private String spicalCode;

    public Expences(String expenceResone, String expenceAmount, String expanceDate) {
        this.expenceResone = expenceResone;
        this.expenceAmount = expenceAmount;
        this.expanceDate = expanceDate;
    }

    public Expences(String userId, String eventId, String expenceResone,
                    String expenceAmount, String expanceDate, String spicalCode) {
        this.userId = userId;
        this.eventId = eventId;
        this.expenceResone = expenceResone;
        this.expenceAmount = expenceAmount;
        this.expanceDate = expanceDate;
        this.spicalCode = spicalCode;
    }
}
