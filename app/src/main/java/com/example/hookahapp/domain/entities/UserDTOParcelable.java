package com.example.hookahapp.domain.entities;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class UserDTOParcelable implements Parcelable {

    private UserDTO userDTO;

    public UserDTOParcelable(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public static final Creator<UserDTOParcelable> CREATOR = new Creator<UserDTOParcelable>() {
        @Override
        public UserDTOParcelable createFromParcel(Parcel in) {
            String name = in.readString();
            String surname = in.readString();
            String phone = in.readString();
            String email = in.readString();
            List<Integer> birth = new ArrayList<>();
            in.readList(birth, Intent.class.getClassLoader());
            String password = in.readString();
            String photo = in.readString();
            int status = in.readInt();
            UserDTO userDTO = new UserDTO(name, surname, phone, email,
                    birth, password, photo, status);
            return new UserDTOParcelable(userDTO);
        }

        @Override
        public UserDTOParcelable[] newArray(int size) {
            return new UserDTOParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userDTO.getName());
        dest.writeString(userDTO.getSurname());
        dest.writeString(userDTO.getPhone());
        dest.writeString(userDTO.getEmail());
        dest.writeList(userDTO.getBirth());
        dest.writeString(userDTO.getPassword());
        dest.writeString(userDTO.getPhoto());
        dest.writeInt(userDTO.getStatus());
    }
}
