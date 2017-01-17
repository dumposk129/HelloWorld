package com.dump129.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dump129 on 1/17/2017.
 */

public class CoordinateParcelable implements Parcelable{
    public int x, y, z;

    public CoordinateParcelable() {
    }

    // Convert data to object, sequential variable
    protected CoordinateParcelable(Parcel in) {
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
    }

    public static final Creator<CoordinateParcelable> CREATOR = new Creator<CoordinateParcelable>() {
        @Override
        public CoordinateParcelable createFromParcel(Parcel in) {
            return new CoordinateParcelable(in);
        }

        @Override
        public CoordinateParcelable[] newArray(int size) {
            return new CoordinateParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // Convert object to data, sequential variable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeInt(z);
    }
}
