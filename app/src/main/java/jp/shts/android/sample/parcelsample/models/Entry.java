package jp.shts.android.sample.parcelsample.models;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Entry {
    Member member;
    String title;

    @ParcelConstructor
    public Entry(String title, Member member) {
        this.title = title;
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public String getTitle() {
        return title;
    }
}
