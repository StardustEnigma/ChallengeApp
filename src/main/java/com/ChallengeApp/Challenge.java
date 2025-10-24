package com.ChallengeApp;

public class Challenge {
    private Long id;
    private String months;
    private String desc;

    public Challenge(long id, String months, String desc) {
        this.id = id;
        this.months = months;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
