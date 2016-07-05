package mx.com.unam.listamascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mx.com.unam.listamascotas.adapter.*;
import mx.com.unam.listamascotas.fragment.DetailFragment;
import mx.com.unam.listamascotas.fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch(item.getItemId()){
            case R.id.mcontact:
                intent = new Intent(this,Contacto.class);
                startActivity(intent);
                break;
            case R.id.macerca:
                intent = new Intent(this,Acerca.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = (Toolbar)findViewById(R.id.primaryActionBar);
        this.tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        this.viewPager = (ViewPager)findViewById(R.id.viewPager);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        this.setupViewPager();

        TextView starAction = (TextView) findViewById(R.id.starAction);

        starAction.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                siguiente();
            }
        });


    }

    private List<Fragment> agregarFragments(){
        List<Fragment> fragments = new ArrayList<Fragment>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new DetailFragment());

        return fragments;
    }

    public void setupViewPager(){
        this.viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        this.tabLayout.setupWithViewPager(this.viewPager);

        this.tabLayout.getTabAt(0).setIcon(R.drawable.home_512);
        this.tabLayout.getTabAt(1).setIcon(R.drawable.dog_icon_87373);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    public void siguiente(){
        Intent i = new Intent(MainActivity.this,RatingActivity.class);
        startActivity(i);
        //finish();
    }
}
