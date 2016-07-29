package jp.shts.android.sample.parcelsample.models;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;
import org.parceler.ParcelConverter;
import org.parceler.ParcelPropertyConverter;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Report {

    String title;

    @ParcelPropertyConverter(MemberListConverter.class)
    List<Member> memberList;

    @ParcelConstructor
    public Report(String title, List<Member> memberList) {
        this.title = title;
        this.memberList = memberList;
    }

    // 不要なコンストラクタ
    public Report(String dummy) {
    }

    public String getTitle() {
        return title;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public class MemberListConverter implements ParcelConverter<List<Member>> {

        @Override
        public void toParcel(List<Member> input, android.os.Parcel parcel) {
            if (input == null) {
                parcel.writeInt(-1);
            } else {
                parcel.writeInt(input.size());
                for (Member item : input) {
                    parcel.writeParcelable(Parcels.wrap(item), 0);
                }
            }
        }

        @Override
        public List<Member> fromParcel(android.os.Parcel parcel) {
            int size = parcel.readInt();
            if (size < 0) return null;
            List<Member> items = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                items.add((Member) Parcels.unwrap(parcel.readParcelable(Member.class.getClassLoader())));
            }
            return items;
        }
    }
}
