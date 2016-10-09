package com.example.xw.jikeviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import Transformer.ZoomOutTransformer;


public class MainActivity extends FragmentActivity {

    private ArrayList<Item> list;
    private Button changeButton;
    private  VerticalViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        changeButton= (Button) findViewById(R.id.change_btn);
        viewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    viewPager.setCurrentItem((viewPager.getCurrentItem()-1));
            }
        });
        initSpeed();
        initViewPager();
    }

    private void initSpeed() {
        FixedSpeedScroller scroller=new FixedSpeedScroller(this);
        scroller.setmDuration(2000);
        scroller.initViewPagerScroll(viewPager);
    }

    private void initViewPager() {


       int[] ims={R.drawable.kenan,R.drawable.mingren,R.drawable.lufei};
        String[] text={"身体虽然变小，但头脑依然灵活",
                "卡 给 分 新 诺 句 子 ！！！",
                "我是要成为海贼王的男人!"};
        for (int i = 0; i <ims.length ; i++) {
            Item item=new Item(ims[i],text[i]);
            list.add(item);
        }
        viewPager.setPageTransformer(true, new ZoomOutTransformer());
        //viewPager.setPageTransformer(true, new StackTransformer());

        FragmentManager fm=getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Item item=list.get(position);
                return MyFragment.newInstance(item.getImageId(),item.getText());
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPager.setCurrentItem(list.size()-1);
    }
}