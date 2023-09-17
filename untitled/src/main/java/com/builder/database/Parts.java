package com.builder.database;

public class Parts {
    private String psp_num;
    private String size;
    private Integer leadTime;
    private Double volume;

    public Parts(String psp_num, String size, Integer leadTime, Double volume) {
        this.psp_num = psp_num;
        this.size = size;
        this.leadTime = leadTime;
        this.volume = volume;
    }
    public Parts(String psp_num, String size, Integer leadTime) {
        this.psp_num = psp_num;
        this.size = size;
        this.leadTime = leadTime;
        this.volume = Double.valueOf(0);
    }

    public String getPsp_num() {
        return psp_num;
    }

    public void setPsp_num(String psp_num) {
        this.psp_num = psp_num;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }




}