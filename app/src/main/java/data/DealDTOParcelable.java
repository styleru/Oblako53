package data;

import android.os.Parcel;
import android.os.Parcelable;

public class DealDTOParcelable implements Parcelable {

    private DealDTO deal;

    public DealDTOParcelable(DealDTO deal) {
        this.deal = deal;
    }

    public static final Creator<DealDTOParcelable> CREATOR = new Creator<DealDTOParcelable>() {
        @Override
        public DealDTOParcelable createFromParcel(Parcel in) {
            String picUrl = in.readString();
            String dealName = in.readString();
            String dealDescription = in.readString();
            DealDTO deal = new DealDTO(Integer.valueOf(picUrl), dealName, dealDescription);
            return new DealDTOParcelable(deal);
        }

        @Override
        public DealDTOParcelable[] newArray(int size) {
            return new DealDTOParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(deal.getPicUrl()));
        dest.writeString(deal.getDealName());
        dest.writeString(deal.getDealDescription());
    }

    public DealDTO getDeal() {
        return deal;
    }
}
