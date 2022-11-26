package com.example.jawaban_uts_revandra;

import java.util.Date;

public class Berita {
    String judul;
    String content;
    String rilis;
    int picture;
    String category;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }


    public Berita(String judul,
            String rilis,
            String category,
            int picture,
                  String content)
    {
        this.judul = judul;
        this.content = content;
        this.rilis = rilis;
        this.category = category;
        this.picture = picture;}

}
