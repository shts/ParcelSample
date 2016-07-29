package jp.shts.android.sample.parcelsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.parceler.Parcels;

import java.util.List;

import jp.shts.android.sample.mylibrary.Result;
import jp.shts.android.sample.parcelsample.models.Entry;
import jp.shts.android.sample.parcelsample.models.Member;
import jp.shts.android.sample.parcelsample.models.Report;

/**
 *
 */
public class NextActivity extends AppCompatActivity {

    private static final String TAG = NextActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        return new Intent(context, NextActivity.class);
    }

    private static final String EXTRA_MEMBER = "extra_member";
    private static final String EXTRA_ENTRY = "extra_entry";
    private static final String EXTRA_MEMBER_LIST = "extra_member_list";
    private static final String EXTRA_REPORT = "extra_report";
    private static final String EXTRA_RESULT = "extra_result";

    @NonNull
    public static Intent getStartIntent(Context context, Member member) {
        return getStartIntent(context).putExtra(EXTRA_MEMBER, Parcels.wrap(member));
    }

    @NonNull
    public static Intent getStartIntent(Context context, Entry entry) {
        return getStartIntent(context).putExtra(EXTRA_ENTRY, Parcels.wrap(entry));
    }

    @NonNull
    public static Intent getStartIntent(Context context, List<Member> memberList) {
        return getStartIntent(context).putExtra(EXTRA_MEMBER_LIST, Parcels.wrap(memberList));
    }

    @NonNull
    public static Intent getStartIntent(Context context, Report report) {
        return getStartIntent(context).putExtra(EXTRA_REPORT, Parcels.wrap(report));
    }

    @NonNull
    public static Intent getStartIntent(Context context, Result result) {
        return getStartIntent(context).putExtra(EXTRA_RESULT, Parcels.wrap(result));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        if (Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_MEMBER)) != null) {
            Member member = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_MEMBER));
            Log.d(TAG, "onCreate: member name(" + member.getName() + ") age(" + member.getAge() + ")");

        } else if (Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_ENTRY)) != null) {
            Entry entry = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_ENTRY));
            Log.d(TAG, "onCreate: entry title(" + entry.getTitle() + ") member name(" + entry.getMember().getName() + ")");

        } else if (Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_MEMBER_LIST)) != null) {
            List<Member> memberList = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_MEMBER_LIST));
            Log.d(TAG, "onCreate: memberList");
            for (Member member : memberList) {
                Log.d(TAG, "onCreate: member(" + member.getName() + ")");
            }

        } else if (Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_REPORT)) != null) {
            Report report = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_REPORT));
            Log.d(TAG, "onCreate: report title(" + report.getTitle() + ")");
            for (Member member : report.getMemberList()) {
                Log.d(TAG, "onCreate: report-member(" + member.getName() + ")");
            }
        } else if (Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_RESULT)) != null) {
            Result result = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_RESULT));
            Log.d(TAG, "onCreate: result(" + result.getMessage() + ")");
        }
    }
}
