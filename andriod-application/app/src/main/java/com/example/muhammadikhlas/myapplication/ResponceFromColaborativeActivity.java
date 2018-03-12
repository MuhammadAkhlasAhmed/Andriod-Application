package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

/**
 * Created by Muhammad IKHLAS on 9/24/2017.
 */
public class ResponceFromColaborativeActivity extends Activity {

    private ListView mListView1, mListView2;
    private String [] data1 ={"www.google.com", "www.youtube.com","dailymotion.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responce_from_colaborative);
        setTitle("Movies Recommendation System");
        Intent i=getIntent();
        List<String> movies=(List<String>) i.getSerializableExtra("Movies");
        List<String> links=(List<String>) i.getSerializableExtra("Links");
        String ns=i.getExtras().getString("Name");
        String count=i.getExtras().getString("Count");
        mListView1 = (ListView)findViewById(R.id.listView1);
        mListView2 = (ListView)findViewById(R.id.listView2);
        Toast.makeText(this,""+ns.toString()+" "+count+" People Wactch This Movie On Facebook",Toast.LENGTH_LONG).show();
        mListView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movies));
        mListView2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, links));
        ListUtils.setDynamicHeight(mListView1);
        ListUtils.setDynamicHeight(mListView2);
        mListView2.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse((String)parent.getItemAtPosition(position)));
                        startActivity(browserIntent);
                    }
                }
        );
    }

    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
            }
        }
    }