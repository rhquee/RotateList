package pl.kfrak.rotatelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity {

    private ListView listView;
    private String[] androidVersions;
    private ArrayList<String> stringList;
    private Random random;
    private TextView emptyListTextView;

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyListTextView = (TextView) findViewById(R.id.EmptyListText);
        listView = (ListView) findViewById(R.id.listView);
        androidVersions = getResources().getStringArray(R.array.wersje_androida);
        stringList = new ArrayList<>();
        random = new Random();
        initAdapter();
        refreshList();

    }

    private void initAdapter() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
    }

    public void addItemToList(View view) {
        String randomString = getRandomVersion();
        stringList.add(randomString);
        refreshList();
    }

    private void refreshList() {
        adapter.notifyDataSetChanged();
        if(adapter.getCount() == 0){
            showEmptyListText();
        }else{showListView();}
    }

    private void showEmptyListText() {
        emptyListTextView.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    private void showListView() {
        emptyListTextView.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    private String getRandomVersion() {
        int randomIndex = random.nextInt(androidVersions.length);
        return androidVersions[randomIndex];
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("lista", stringList);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ArrayList<String> savedList = savedInstanceState.getStringArrayList("lista");
        if (savedList != null)
            stringList.addAll(savedList);
        refreshList();
    }
}
