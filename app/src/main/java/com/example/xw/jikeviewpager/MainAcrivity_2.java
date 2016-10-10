package com.example.xw.jikeviewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import Transformer.ZoomOutTransformer;

/**
 * Created by xw on 2016/10/10.
 */
public class MainAcrivity_2 extends AppCompatActivity {
    private ArrayList<RoundRectImageView> list;
    private ArrayList<TextView> list2;
    private Button changeButton;
    private  VerticalViewPager viewPager3;
    private  VerticalViewPager viewPager4;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        list=new ArrayList<>();
        list2=new ArrayList<>();
        changeButton= (Button) findViewById(R.id.change_btn2);
        viewPager3 = (VerticalViewPager) findViewById(R.id.vertical_viewpager3);
        viewPager4= (VerticalViewPager) findViewById(R.id.vertical_viewpager4);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager3.setCurrentItem((viewPager3.getCurrentItem()-1));
                viewPager4.setCurrentItem(viewPager4.getCurrentItem()-1);
            }
        });
        initSpeed();
        initViewPager();
    }

    private void initViewPager() {
        final int[] ims={R.drawable.kenan,R.drawable.mingren,R.drawable.lufei};
        String[] text={"身体虽然变小，但头脑依然灵活",
                "卡 给 分 新 诺 句 子 ！！！",
                "我是要成为海贼王的男人!"};
        for (int i = 0; i <ims.length ; i++) {
           RoundRectImageView roundRectImageView=new RoundRectImageView(this);
            roundRectImageView.setImageResource(ims[i]);
            roundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            list.add(roundRectImageView);

            TextView textView=new TextView(this);
            textView.setText(text[i]);

            list2.add(textView);
            

        }
        viewPager3.setPageTransformer(true, new ZoomOutTransformer());
        viewPager3.setPageTransformer(true,new ZoomOutTransformer());
        viewPager3.setAdapter(new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
               container.removeView(list.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list.get(position));
                return list.get(position);
            }

            @Override
            public int getCount() {
                return ims.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });

        viewPager3.setCurrentItem(list.size()-1);


        viewPager4.setAdapter(new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list2.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list2.get(position));
                return list2.get(position);
            }
            @Override
            public int getCount() {
                return list2.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });

        viewPager4.setCurrentItem(list2.size()-1);
    }

    private void initSpeed() {
        FixedSpeedScroller scroller=new FixedSpeedScroller(this);
        scroller.setmDuration(2000);
        scroller.initViewPagerScroll(viewPager3);

        FixedSpeedScroller scroller2=new FixedSpeedScroller(this);
        scroller2.setmDuration(1000);
        scroller2.initViewPagerScroll(viewPager4);
    }
}
