package data;

public class DealDTO {
    private String picAdress;
    private String dealName;

    public DealDTO(){
        this.picAdress = "";
        this.dealName = "";
    }

    public DealDTO(String picAdress, String dealName){
        this.picAdress = picAdress;
        this.dealName = dealName;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getPicAdress() {
        return picAdress;
    }

    public void setPicAdress(String picAdress) {
        this.picAdress = picAdress;
    }
}
