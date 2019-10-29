package com.example.wechatview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyRecyclerView mRv;
    private RecyclerView rvinside;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> entities2 = new ArrayList<>();
    private MyAdapter myAdapter;
    private LinearLayout mLayoutTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }



    private void initView() {

        mRv = (MyRecyclerView) findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
        for (int i = 0; i < 100; i++) {
            entities.add(new Entity());
        }
        myAdapter = new MyAdapter(entities);
        mRv.setAdapter(myAdapter);
        View view = LayoutInflater.from(this).inflate(R.layout.headview, null);
        myAdapter.addHeaderView(view);
        mRv.setHeadView(view);
        mRv.setMoveListener(new MyRecyclerView.MoveCallback() {
            @Override
            public void onMove(boolean isMove) {
                if (isMove) {
                    mLayoutTitle.setVisibility(View.GONE);
                } else {
                    mLayoutTitle.setVisibility(View.VISIBLE);
                }
            }
        });
        mLayoutTitle =  findViewById(R.id.layout_title);
        rvinside = view.findViewById(R.id.rv_inside);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        rvinside.setLayoutManager(gridLayoutManager);
        rvinside.setItemViewCacheSize(50);
        for (int i = 0; i < 50; i++) {
            entities2.add(new Entity());
        }
        rvinside.setAdapter(new MyAdapter_inside(entities2));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.layout_title:
                break;
        }
    }


    class MyAdapter extends BaseQuickAdapter<Entity, BaseViewHolder> {

        public MyAdapter(@Nullable List<Entity> data) {
            super(R.layout.item_rv, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Entity item) {
        }
    }

    class MyAdapter_inside extends BaseQuickAdapter<Entity, BaseViewHolder> {

        public MyAdapter_inside(@Nullable List<Entity> data) {
            super(R.layout.item_rv2, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Entity item) {

        }
    }
}
