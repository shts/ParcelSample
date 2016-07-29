package jp.shts.android.sample.mylibrary;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Result {
    String message;
    boolean success;

    @ParcelConstructor
    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
