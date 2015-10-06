package com.zoulux.zoulux_festival_sms.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2015-9-29-0029.
 */
public class FestivalLab {

    private static FestivalLab mIntance;
    private List<Festival> mFestivals = new ArrayList<>();


    private FestivalLab() {
        mFestivals.add(new Festival(1, "国庆节"));
        mFestivals.add(new Festival(2, "中秋节"));
        mFestivals.add(new Festival(3, "元旦"));
        mFestivals.add(new Festival(4, "春节"));
        mFestivals.add(new Festival(5, "端午节"));
        mFestivals.add(new Festival(6, "七夕"));
        mFestivals.add(new Festival(7, "圣诞节"));
        mFestivals.add(new Festival(8, "儿童节"));


    }

    public List<Festival> getFestivals() {

        return new ArrayList<>(mFestivals);
    }


    public Festival getFestivalById(int id) {
        for (Festival festival : mFestivals) {
            if (festival.getId() == id) {
                return festival;
            }
        }
        return null;
    }

    public static FestivalLab getIntance() {
        if (mIntance == null)
            synchronized (FestivalLab.class) {
                if (mIntance == null)
                    mIntance = new FestivalLab();

            }


        return mIntance;
    }
}
