package com.example.hairdresser_new;

import java.util.List;

public class DataModel {

    private List<String> nestedList;
    private String itemText;
    private boolean isExpandable;

    public DataModel(List<String> itemList, String itemText) {
        this.nestedList = itemList;
        this.itemText = itemText;
        isExpandable = false;
    }

    public List<String> getNestedList() {
        return nestedList;
    }

    public String getItemText() {
        return itemText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
