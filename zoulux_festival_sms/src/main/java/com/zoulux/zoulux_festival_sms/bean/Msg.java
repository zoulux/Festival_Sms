package com.zoulux.zoulux_festival_sms.bean;

/**
 * Created by zoulux on 2015-10-02 11:03.
 */
public class Msg {
    private int id;
    private int fetivalId;
    private String conent;

    public Msg(int id, int fetivalId, String conent) {
        this.id = id;
        this.fetivalId = fetivalId;
        this.conent = conent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFetivalId() {
        return fetivalId;
    }

    public void setFetivalId(int fetivalId) {
        this.fetivalId = fetivalId;
    }

    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent;
    }
}
