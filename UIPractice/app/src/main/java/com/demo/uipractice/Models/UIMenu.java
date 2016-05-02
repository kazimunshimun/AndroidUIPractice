package com.demo.uipractice.Models;

/**
 * Created by TigerIT on 5/2/16.
 */
public class UIMenu {

    private String title, detail;
    private int imageResource;

    public UIMenu() {
    }

    public UIMenu(String title, String detail, int imageResource) {
        this.title = title;
        this.detail = detail;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getMenuImageResource() {
        return imageResource;
    }

    public void setMenuImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

}
