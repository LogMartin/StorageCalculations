package com.builder.database;

import java.util.HashMap;

/**
 * The {@code Projects} class represents a project with a name, installation length, and materials required.
 * It provides methods to manipulate project details and manage materials.
 */
public class Projects {
    private String name;
    private int installLength;
    private HashMap<String, Integer> materials;

    /**
     * Constructs a new project with the given name and installation length.
     * @param name          The name of the project.
     * @param installLength The length of the installation in days.
     */
    public Projects(String name, int installLength) {
        this.name = name;
        this.installLength = installLength;
        this.materials = new HashMap<String, Integer>();
    }

    /**
     * Get the name of the project.
     * @return The name of the project.
     */
    public String getName() { return name; }

    /**
     * Set the name of the project.
     * @param name The new name for the project.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Get the installation length of the project.
     * @return The installation length in days.
     */
    public int getInstallLength() { return installLength; }

    /**
     * Set the installation length of the project.
     * @param installLength The new installation length in days.
     */
    public void setInstallLength(int installLength) { this.installLength = installLength; }

    /**
     * Get the materials required for the project.
     * @return A map of materials and their quantities.
     */
    public HashMap<String, Integer> getMaterials() { return this.materials; }

    /**
     * Add a material with the specified quantity to the project.
     * @param part     The part number of the material.
     * @param quantity The quantity of the material to add.
     */
    public void addMaterial(String part, int quantity) { this.materials.put(part, quantity); }

    /**
     * Remove a material from the project by its name.
     * @param key The name of the material to remove.
     */
    public void removeMaterial(String key) { this.materials.remove(key); }

    /**
     * Reset the materials list, removing all materials from the project.
     */
    public void resetMaterials() { materials.clear();}



}