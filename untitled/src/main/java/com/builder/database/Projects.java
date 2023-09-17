package com.builder.database;

import java.util.HashMap;

public class Projects {
    private String name;
    private int installLength;
    private HashMap<String, Integer> materials;

    public Projects(String name, int installLength) {
        this.name = name;
        this.installLength = installLength;
        this.materials = new HashMap<String, Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstallLength() {
        return installLength;
    }

    public void setInstallLength(int installLength) {
        this.installLength = installLength;
    }

    public HashMap getMaterials() { return this.materials; }

    public void addMaterial(String key, int quantity) { this.materials.put(key,quantity); }

    public void removeMaterial(String key){ this.materials.remove(key); }

    public void resetMaterials(){ materials.clear(); }

}