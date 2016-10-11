package qx.com.swiperefreshlayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> datas=new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        myAdapter=new MyAdapter(datas);
        mRecyclerView.setAdapter(myAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));


        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnClick(View v, int position, String city) {
                Toast.makeText(MainActivity.this,"City:"+city+"Position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDatas(){
        datas.add("New York");
        datas.add("Boston");
        datas.add("Washington");
        datas.add("San Francisco");
        datas.add("California");
        datas.add("Chigaco");
        datas.add("Houston");
        datas.add("Phoneix");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_action_add:
                myAdapter.addData(0,"new City");
                break;
            case R.id.id_action_delete:
                myAdapter.removeData(1);
                break;
            case R.id.id_action_girdview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
                break;
            case R.id.id_action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.id_action_staview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                break;
        }
        return true;
    }
}
