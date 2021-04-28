package com.gm.asm.dto;

public class CsvDTO {

    private String asms_nbr;
    private String DPG_Groups;
    private String usr_id;

    public String getAsms_nbr() {
        return asms_nbr;
    }

    public void setAsms_nbr(String asms_nbr) {
        this.asms_nbr = asms_nbr;
    }

    public String getDPG_Groups() {
        return DPG_Groups;
    }

    public void setDPG_Groups(String DPG_Groups) {
        this.DPG_Groups = DPG_Groups;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public CsvDTO(String asms_nbr, String DPG_Groups, String usr_id) {
        this.asms_nbr = asms_nbr;
        this.DPG_Groups = DPG_Groups;
        this.usr_id = usr_id;
    }
}
