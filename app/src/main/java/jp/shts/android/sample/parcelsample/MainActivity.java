package jp.shts.android.sample.parcelsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import jp.shts.android.sample.mylibrary.Result;
import jp.shts.android.sample.parcelsample.models.Entry;
import jp.shts.android.sample.parcelsample.models.Member;
import jp.shts.android.sample.parcelsample.models.Report;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View m = findViewById(R.id.to_member);
        if (m != null) m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(NextActivity.getStartIntent(MainActivity.this, new Member("hoge", 10)));
                //memberList = Arrays.asList(new Member("hoge10", 10), new Member("hoge11", 11), new Member("hoge12", 12), new Member("hoge13", 12));
                //startActivity(NextActivity.getStartIntent(MainActivity.this, createReport()));
                startActivity(NextActivity.getStartIntent(MainActivity.this, new Result("OK!!!", false)));
            }
        });

        View e = findViewById(R.id.to_entry);
        if (e != null) e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NextActivity.getStartIntent(MainActivity.this, new Entry("title", new Member("hoge", 10))));
            }
        });
    }

    private List<Member> createMemberList() {
        return Arrays.asList(new Member("hoge10", 10), new Member("hoge11", 11), new Member("hoge12", 12), new Member("hoge13", 12));
    }

    private Report createReport() {
        return new Report("otameshi", Arrays.asList(new Member("hoge10", 10), new Member("hoge11", 11), new Member("hoge12", 12), new Member("hoge13", 12)));
    }
}

