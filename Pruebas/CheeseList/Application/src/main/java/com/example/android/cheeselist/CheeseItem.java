package com.example.android.cheeselist;

public class CheeseItem{
    private String name;
    private Boolean isStarred = false;

    public CheeseItem(String cheeseName){
        setName(cheeseName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStarred() {
        return isStarred;
    }

    public void setStarred(Boolean starred) {
        this.isStarred = starred;
    }
}
