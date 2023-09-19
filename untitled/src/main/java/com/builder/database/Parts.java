package com.builder.database;

/**
 * The {@code Parts} class represents parts with attributes such as PSP number (Unique ID), size, lead time,
 * and volume. It provides constructors and methods to access and manipulate these attributes.
 */
public class Parts {
    private String psp_num;
    private String size;
    private Integer leadTime;
    private Double volume;

    /**
     * Constructs a new part with the given PSP number, size, lead time, and volume.
     * @param psp_num   The PSP (Part Specification) number of the part.
     * @param size      The size of the part.
     * @param leadTime  The lead time for ordering the part.
     * @param volume    The volume of the part.
     */
    public Parts(String psp_num, String size, Integer leadTime, Double volume) {
        this.psp_num = psp_num;
        this.size = size;
        this.leadTime = leadTime;
        this.volume = volume;
    }

    /**
     * Constructs a new part with the given PSP number, size, and lead time. Volume is set to 0.
     * @param psp_num   The PSP (Part Specification) number of the part.
     * @param size      The size of the part.
     * @param leadTime  The lead time for ordering the part.
     */
    public Parts(String psp_num, String size, Integer leadTime) {
        this.psp_num = psp_num;
        this.size = size;
        this.leadTime = leadTime;
        this.volume = Double.valueOf(0);
    }

    /**
     * Get the PSP number of the part.
     * @return The PSP number of the part.
     */
    public String getPsp_num() {
        return psp_num;
    }

    /**
     * Set the PSP number of the part.
     * @param psp_num The new PSP number for the part.
     */
    public void setPsp_num(String psp_num) {
        this.psp_num = psp_num;
    }

    /**
     * Get the lead time for ordering the part.
     * @return The lead time for ordering the part.
     */
    public Integer getLeadTime() {
        return leadTime;
    }

    /**
     * Set the lead time for ordering the part.
     * @param leadTime The new lead time for ordering the part.
     */
    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    /**
     * Get the volume of the part.
     * @return The volume of the part.
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * Set the volume of the part.
     * @param volume The new volume for the part.
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * Get the size of the part.
     * @return The size of the part.
     */
    public String getSize() {
        return size;
    }

    /**
     * Set the size of the part.
     * @param size The new size for the part.
     */
    public void setSize(String size) {
        this.size = size;
    }


}