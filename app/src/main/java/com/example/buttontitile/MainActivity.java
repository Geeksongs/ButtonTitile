package com.example.buttontitile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{






    LinearLayout homeLinear;

    LinearLayout listLinear;

    LinearLayout polyLinear;

    LinearLayout userLinear;

    Fragment1 fragmentHome;
    Fragment2 fragmentList;
    Fragment3 fragmentPoly;
    Fragment4 fragmentUser;
    private FragmentManager mfragmentManger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);













        homeLinear= (LinearLayout) findViewById(R.id.home);
        listLinear= (LinearLayout) findViewById(R.id.location);
        polyLinear= (LinearLayout) findViewById(R.id.linear_polymer);
        userLinear= (LinearLayout) findViewById(R.id.linear_user);
        homeLinear.setOnClickListener(this);
        listLinear.setOnClickListener(this);
        polyLinear.setOnClickListener(this);
        userLinear.setOnClickListener(this);
        mfragmentManger = getSupportFragmentManager();
        homeLinear.performClick();




    }
    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = mfragmentManger.beginTransaction();//只能是局部变量，不能为全局变量，否则不能重复commit
        //FragmentTransaction只能使用一次
        hideAllFragment(fragmentTransaction);
        switch (view.getId()){
            case R.id.home:
                setAllFalse();
                homeLinear.setSelected(true);
                if (fragmentHome==null){
                    fragmentHome=new Fragment1("Home");
                    fragmentTransaction.add(R.id.fragment_frame,fragmentHome);
                }else{
                    fragmentTransaction.show(fragmentHome);
                }
                break;
            case R.id.location:
                setAllFalse();
                listLinear.setSelected(true);
                if(fragmentList==null){
                    fragmentList=new Fragment2("List");
                    fragmentTransaction.add(R.id.fragment_frame,fragmentList);
                }else {
                    fragmentTransaction.show(fragmentList);
                }
                break;
            case R.id.linear_polymer:
                setAllFalse();
                polyLinear.setSelected(true);
                if(fragmentPoly==null){
                    fragmentPoly=new Fragment3("Polymer");
                    fragmentTransaction.add(R.id.fragment_frame,fragmentPoly);
                }else {
                    fragmentTransaction.show(fragmentPoly);
                }
                break;
            case R.id.linear_user:
                setAllFalse();
                userLinear.setSelected(true);
                if(fragmentUser==null){
                    fragmentUser=new Fragment4("User");
                    fragmentTransaction.add(R.id.fragment_frame,fragmentUser);
                }else {
                    fragmentTransaction.show(fragmentUser);
                }
                break;
        }
        fragmentTransaction.commit();//记得必须要commit,否则没有效果
}
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if(fragmentHome!=null){
            fragmentTransaction.hide(fragmentHome);
        }
        if(fragmentList!=null){
            fragmentTransaction.hide(fragmentList);
        }
        if(fragmentPoly!=null){
            fragmentTransaction.hide(fragmentPoly);
        }
        if(fragmentUser!=null){
            fragmentTransaction.hide(fragmentUser);
        }

    }
    private void setAllFalse() {
        homeLinear.setSelected(false);
        listLinear.setSelected(false);
        polyLinear.setSelected(false);
        userLinear.setSelected(false);
    }


}
