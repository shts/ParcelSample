package jp.shts.android.sample.parcelsample;

import android.app.Application;

import org.parceler.ParcelClass;
import org.parceler.ParcelClasses;

import jp.shts.android.sample.mylibrary.Result;
import jp.shts.android.sample.parcelsample.models.Entry;
import jp.shts.android.sample.parcelsample.models.Member;
import jp.shts.android.sample.parcelsample.models.Report;

/**
 */
@ParcelClasses({
        @ParcelClass(Entry.class),
        @ParcelClass(Member.class),
        @ParcelClass(Report.class),
        @ParcelClass(Result.class)
})
public class MyApplication extends Application {
}
