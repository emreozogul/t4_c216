package com.t4.catalog;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;

public class Item<o>  extends TreeItem<o> {



    private final String type ;
    private String tag;
    private final String name;
    private String description;
    private TreeItem<String> folder;


    private ArrayList<Attribute> attributes;


    public Item(o o, String type, String tag, String name, String description, TreeItem<String> folder) {
        super(o);
        this.type = type;
        this.tag = tag;
        this.name = name;
        this.description = description;
        this.folder = folder;
        this.attributes = new ArrayList<>();
    }

    public String getType() {
        return type;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }



    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }

    public void removeAttribute(Attribute attribute) {
        this.attributes.remove(attribute);
    }

    public void removeAttribute(int index) {
        this.attributes.remove(index);
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", tag='" + tag + '\'' +
                ", description='" + description + '\'' +
                ", folder=" + folder +
                ", attributes=" + attributes +
                '}';
    }


    public void setAttributes(Attribute attribute) {
        this.attributes.add(attribute);
    }


    public TreeItem<String> getFolder() {
        return folder;
    }

    public void setFolder(TreeItem<String> folder) {
        this.folder = folder;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

}

