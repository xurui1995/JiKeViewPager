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
    private ArrayList<Item> list2;
    private Button changeButton;
    private  VerticalViewPager viewPager;
    private  VerticalViewPager viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        list2=new ArrayList<>();
        changeButton= (Button) findViewById(R.id.change_btn);
        viewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);
        viewPager2= (VerticalViewPager) findViewById(R.id.vertical_viewpager2);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    viewPager.setCurrentItem((viewPager.getCurrentItem()-1));
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem()-1);
            }
        });
        initSpeed();
        initViewPager();
    }

    private void initSpeed() {
        FixedSpeedScroller scroller=new FixedSpeedScroller(this);
        scroller.setmDuration(2500);
        scroller.initViewPagerScroll(viewPager);

        FixedSpeedScroller scroller2=new FixedSpeedScroller(this);
        scroller2.setmDuration(1500);
        scroller2.initViewPagerScroll(viewPager2);
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

        int[] ims2={R.drawable.qinnv,R.drawable.yasuo,R.drawable.timo};
        String[] text2={
            "为什么哑巴琴女会说话?",
            "死亡如风,常伴吾身",
                "timo队长，正在送命"
        };
        for (int i = 0; i <ims2.length ; i++) {
            Item item=new Item(ims2[i],text2[i]);
            list2.add(item);
        }

        viewPager.setPageTransformer(true, new ZoomOutTransformer());
        viewPager2.setPageTransformer(true,new ZoomOutTransformer());

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

        viewPager2.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Item item=list2.get(position);
                return MyFragment.newInstance(item.getImageId(),item.getText());
            }

            @Override
            public int getCount() {
                return list2.size();
            }
        });

        viewPager2.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPager2.setCurrentItem(list.size()-1);
    }
}