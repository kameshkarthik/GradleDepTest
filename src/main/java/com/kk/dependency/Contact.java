package com.kk.dependency;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable{

    private String _name, _phone, _email, _address;
    private Uri _imageURI;
    private int _id;

    public Contact (int id, String name, String phone, String email, String address, Uri imageURI) {
        _id = id;
        _name = name;
        _phone = phone;
        _email = email;
        _address = address;
        _imageURI = imageURI;
    }


    public Contact(Parcel in){
        this._id = in.readInt();
        this._name = in.readString();
        this._phone = in.readString();
        this._email = in.readString();
        this._address = in.readString();
        this._imageURI = Uri.parse(in.readString());
    }

    public int getId() { return _id; }

    public String getName() {
        return _name;
    }

    public String getPhone() {
        return _phone;
    }

    public String getEmail() {
        return _email;
    }

    public String getAddress() {
        return _address;
    }

    public Uri getImageURI() { return _imageURI; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(_name);
        dest.writeString(_phone);
        dest.writeString(_email);
        dest.writeString(_address);
        dest.writeString(_imageURI.getPath());

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };


}
