package data;

public class DealDTO {
    private int picUrl;
    private String dealName;

    public DealDTO(){
        this.picUrl = 0;
        this.dealName = "";
    }

    public DealDTO(int picUrl, String dealName){
        this.picUrl = picUrl;
        this.dealName = dealName;
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
}
