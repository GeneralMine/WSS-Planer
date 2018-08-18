package ml.metalogie.generalmine.wss_planner;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class grades_settings extends AppCompatActivity {

    private ArrayList<example_item> mExampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_settings);

        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);

            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });

    }

    public void insertItem(int position) {

        if (position>mExampleList.size()) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.grades_settings_layout), "Error: No such position", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else {
            mExampleList.add(position, new example_item(R.drawable.ic_menu_gallery, "New item at position" + position, "Line2"));
            mAdapter.notifyItemInserted(position);
        }
    }

    public void removeItem(int position) {
        if (position>mExampleList.size()) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.grades_settings_layout), "Error: No such position", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if(position<mExampleList.size()) {
            mExampleList.remove(position);
            mAdapter.notifyItemRemoved(position);
        }
        else if(position==mExampleList.size()){
            Log.d("test","TestCase");
        }
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new example_item(R.drawable.ic_menu_camera, "Line1", "Line2"));
        mExampleList.add(new example_item(R.drawable.ic_menu_gallery, "Line3", "Line4"));
        mExampleList.add(new example_item(R.drawable.ic_menu_manage, "Line5", "Line6"));

    }

    public void buildRecyclerView() {
        mRecyclerView  = findViewById(R.id.recyclerview_grades_settings);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}

