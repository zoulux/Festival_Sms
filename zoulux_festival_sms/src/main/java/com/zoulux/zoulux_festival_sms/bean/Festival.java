package com.zoulux.zoulux_festival_sms.bean;

import java.util.Date;

/**
 * Created by Lenovo on 2015-9-29-0029.
 */
public class Festival {
    private  int id;
    private String name;
    private  String dsc;
    private Date date;

    public Festival(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
