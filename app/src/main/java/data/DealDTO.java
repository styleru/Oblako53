package data;

public class DealDTO {
    private int picUrl;
    private String dealName;
    private String dealDescription;

    public DealDTO(){
        this.picUrl = 0;
        this.dealName = "";
        this.dealDescription = "";
    }

    public DealDTO(int picUrl, String dealName, String dealDescription){
        this.picUrl = picUrl;
        this.dealName = dealName;
        this.dealDescription = dealDescription;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public int getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(int picUrl) {
        this.picUrl = picUrl;
    }

    public String getDealDescription() {
        return dealDescription;
    }

    public void setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
    }
}
