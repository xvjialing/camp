package com.example.xvjia.camp3;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {

    public int number = 1;

    public int homefragmentTag = 0;

    public int mapSucessdialog1Tag = 0;

    public int place1_step1_dialog1Tag = 0;

    public int team_finger1Tag = 0;

    public int team_avater5Tag = 0;

    public int linea_fenxiangTag = 0;

    public int clanTag = 0;

    public int waitTag = 0;

    public int getWaitTag() {
        return waitTag;
    }

    public void setWaitTag(int waitTag) {
        this.waitTag = waitTag;
    }

    public int getClanTag() {
        return clanTag;
    }

    public void setClanTag(int clanTag) {
        this.clanTag = clanTag;
    }

    public int getLinea_fenxiangTag() {
        return linea_fenxiangTag;
    }

    public void setLinea_fenxiangTag(int linea_fenxiangTag) {
        this.linea_fenxiangTag = linea_fenxiangTag;
    }

    public int getTeam_avater5Tag() {
        return team_avater5Tag;
    }

    public void setTeam_avater5Tag(int team_avater5Tag) {
        this.team_avater5Tag = team_avater5Tag;
    }

    public void setTeam_finger1Tag(int team_finger1Tag) {
        this.team_finger1Tag = team_finger1Tag;
    }

    public void setPlace1_step1_dialog1Tag(int place1_step1_dialog1Tag) {
        this.place1_step1_dialog1Tag = place1_step1_dialog1Tag;
    }

    public int getHomefragmentTag() {
        return homefragmentTag;
    }

    public int getMapSucessdialog1Tag() {
        return mapSucessdialog1Tag;
    }

    public void setMapSucessdialog1Tag(int mapSucessdialog1Tag) {
        this.mapSucessdialog1Tag = mapSucessdialog1Tag;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
