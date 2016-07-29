package jp.shts.android.sample.parcelsample.models;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;


@Parcel
public class Member {
    String name;
    int age;

    @ParcelConstructor
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
