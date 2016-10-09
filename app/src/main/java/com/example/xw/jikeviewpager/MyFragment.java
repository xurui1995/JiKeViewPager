package com.example.xw.jikeviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xw on 2016/10/9.
 */
public class MyFragment extends Fragment {
    private static final String ARG_IMG_ID="image_id";
    private static final String ARG_TEXT="text";
    private int imageId;
    private String text;
    private ImageView iv;
    private TextView tv;
    public static MyFragment newInstance(int imgId,String text){
        Bundle args=new Bundle();
        args.putSerializable(ARG_IMG_ID,imgId);
        args.putSerializable(ARG_TEXT,text);

        MyFragment fragment=new MyFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageId= (int) getArguments().getSerializable(ARG_IMG_ID);
        text= (String) getArguments().getSerializable(ARG_TEXT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_item,container,false);
        iv= (ImageView) v.findViewById(R.id.iv);
        tv= (TextView) v.findViewById(R.id.tv);
        iv.setImageResource(imageId);
        tv.setText(text);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
            }
        });
        return v;

    }
}
