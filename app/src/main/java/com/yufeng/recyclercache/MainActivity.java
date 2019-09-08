package com.yufeng.recyclercache;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ModelAdapter adapter;

    private boolean isNight = false;

    private boolean isLoading = false;
    private int index = 0;
    private int moreIndex = 0;
    private boolean isLoadingMore = false;

    private LinearLayoutManager manager;
    private int size;
    private int statusBarHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_recycler_view);
        recyclerView.getItemAnimator().setChangeDuration(0);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new ModelAdapter();
        adapter.setNight(isNight);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(scrollChangeListener);

        statusBarHeight = getStatusBarHeight(this);

        initData();
        findViewById(R.id.main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchDayNight();
            }
        });
        findViewById(R.id.main_btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.scrollToPosition(size + 1);
            }
        });
    }

    private void initData() {
        List<Model> list = new ArrayList<>();

        Model model0 = new Model(1, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_5077146_1_fa4824964905472daa7ea90fbe459e0b.jpg?imageView2/1/w/2664/h/1665/format/jpg");
        list.add(model0);

        Model model1 = new Model(2, Model.TYPE_2, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_1_8abb2bfa23b146ce98f907133677f07a.jpg?imageView2/1/w/2664/h/3330/format/jpg");
        list.add(model1);

        Model model2 = new Model(3, Model.TYPE_0, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_2_5b56bba63c1b45029976dc7e3d8dd59a.jpg?imageView2/1/w/2664/h/3330/format/jpg");
        list.add(model2);

//        Model model3 = new Model(4, Model.TYPE_2, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_3_c3afcbfb08c446d88ce4271f85b52d79.jpg?imageView2/1/w/2664/h/3867/format/jpg");
//        list.add(model3);

//        Model model4 = new Model(5, Model.TYPE_2, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_3_c3afcbfb08c446d88ce4271f85b52d79.jpg?imageView2/1/w/2664/h/3867/format/jpg");
//        list.add(model4);

//        Model model5 = new Model(6, Model.TYPE_1, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_4_5fbc397e3c2345e0bbe53b61c993c8d8.jpg?imageView2/1/w/2664/h/6061/format/jpg");
//        list.add(model5);

//        Model model6 = new Model(7, Model.TYPE_1, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_5_a1e1a13229bb4841aa376c1bbc84f3de.jpg?imageView2/1/w/2664/h/3330/format/jpg");
//        list.add(model6);

//        Model model7 = new Model(8, Model.TYPE_1, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_6_946726be943e4b4a9bcb072bdd566cf4.jpg?imageView2/1/w/2664/h/3330/format/jpg");
//        list.add(model7);

        Model model8 = new Model(9, Model.TYPE_2, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_7_a080d65950d94e3ebe0f06fd43b0d8a4.jpg?imageView2/1/w/2664/h/4384/format/jpg");
        list.add(model8);

        Model model9 = new Model(10, Model.TYPE_2, "chapter 1", "http://dnc.chumanapp.com/app/comics/titles/title_5077146_8_04adc18f99294b51a3a72a8ee14fbc3f.jpg?imageView2/1/w/2664/h/6240/format/jpg");
        list.add(model9);


        adapter.setData(list);
    }

    private void addData() {
        List<Model> list = new ArrayList<>();

        Model model0 = new Model(11, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_1_feef7f288a384b06bd07a160f3fff9db.jpg?imageView2/1/w/2664/h/1665/format/jpg");
        list.add(model0);

        Model model1 = new Model(12, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_2_2566c07f31d84b0f8057ca7c6e33906a.jpg?imageView2/1/w/2664/h/5466/format/jpg");
        list.add(model1);

        Model model2 = new Model(13, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_3_8a29b64f400745009f29d2f2f348d960.jpg?imageView2/1/w/2664/h/3501/format/jpg");
        list.add(model2);

        Model model3 = new Model(14, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_4_d8fdf72e12764548bf78d1436463c948.jpg?imageView2/1/w/2664/h/4517/format/jpg");
        list.add(model3);

        Model model4 = new Model(15, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_5_5756ec60455b425893e5931f4d3cb933.jpg?imageView2/1/w/2664/h/4126/format/jpg");
        list.add(model4);

        Model model5 = new Model(16, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_5_5756ec60455b425893e5931f4d3cb933.jpg?imageView2/1/w/2664/h/4126/format/jpg");
        list.add(model5);

        Model model6 = new Model(17, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_6_f4012914258943dd88ba323a1293e180.jpg?imageView2/1/w/2664/h/5291/format/jpg");
        list.add(model6);

        adapter.getData().addAll(0, list);
        adapter.notifyItemRangeInserted(1, list.size());
//        adapter.notifyDataSetChanged();
//        recyclerView.smoothScrollToPosition(list.size());

//        MySmoothScoller linearSmoothScroller = new MySmoothScoller(recyclerView.getContext());
//        linearSmoothScroller.setTargetPosition(list.size());
//        recyclerView.getLayoutManager().startSmoothScroll(linearSmoothScroller);
        moveToPosition(manager, list.size() + 1);

        index++;
        isLoading = false;
    }

    private void addMoreData() {
        List<Model> list = new ArrayList<>();

        Model model0 = new Model(1 + (moreIndex + 1) * 10, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_1_ac028b3da6ed4d16abd65d00e6b73b93.jpg?imageView2/1/w/2664/h/1665/format/jpg");
        list.add(model0);

        Model model1 = new Model(2 + (moreIndex + 1) * 10, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_2_d2f9c3ff951c46038cada4892219a383.jpg?imageView2/1/w/2664/h/6660/format/jpg");
        list.add(model1);

        Model model2 = new Model(3 + (moreIndex + 1) * 10, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_3_dbd8ea426f924a5abcffff5a3225a329.jpg?imageView2/1/w/2664/h/6136/format/jpg");
        list.add(model2);

        Model model4 = new Model(5 + (moreIndex + 1) * 10, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_4_516ac29e5c6c4a88ac640138fa343937.jpg?imageView2/1/w/2664/h/3056/format/jpg");
        list.add(model4);

        Model model5 = new Model(6 + (moreIndex + 1) * 10, Model.TYPE_2, "chapter 1", "https://dnc.chumanapp.com/app/comics/titles/title_2290251_5_8d5d25d7a16345b2a40857f9693da002.jpg?imageView2/1/w/2664/h/5104/format/jpg");
        list.add(model5);


        int size = adapter.getData().size();

        View view = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
        int top = view.getTop();
        android.util.Log.e("MainActivity", "top=" + top);

        adapter.getData().addAll(list);
        this.size = size;
        adapter.notifyItemRangeInserted(size + 1, list.size());

//        manager.scrollToPositionWithOffset(size, -dip2px(MainActivity.this, 50));

        manager.setStackFromEnd(false);
        manager.scrollToPositionWithOffset(size + 1, getResources().getDisplayMetrics().heightPixels - dip2px(MainActivity.this, 50) );
//        adapter.notifyDataSetChanged();
//        recyclerView.smoothScrollToPosition(list.size());


        moreIndex++;
        isLoadingMore = false;

        index = 0;
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }
    public void moveToPosition(LinearLayoutManager manager, int n) {
        manager.scrollToPositionWithOffset(n, dip2px(MainActivity.this, 50));
        manager.setStackFromEnd(true);
    }


    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private RecyclerView.OnScrollListener scrollChangeListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE && !recyclerView.canScrollVertically(-1) && !isLoading && index < 1) {

                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isLoading = true;
                        addData();
                    }
                }, 200);
            } else if (newState == RecyclerView.SCROLL_STATE_IDLE && !recyclerView.canScrollVertically(-1) && index >= 1) {
                Toast.makeText(MainActivity.this, "第一页了", Toast.LENGTH_LONG).show();
            } else if (newState == RecyclerView.SCROLL_STATE_IDLE && !recyclerView.canScrollVertically(1) && !isLoadingMore && moreIndex <= 4) {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isLoadingMore = true;
                        addMoreData();
                    }
                }, 200);
            } else if (newState == RecyclerView.SCROLL_STATE_IDLE && !recyclerView.canScrollVertically(1) && !isLoadingMore && moreIndex > 4) {
                Toast.makeText(MainActivity.this, "最后一页了", Toast.LENGTH_LONG).show();
            }
        }
    };

    private void switchDayNight() {
        isNight = !isNight;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int start = linearLayoutManager.findFirstVisibleItemPosition();
        int end = linearLayoutManager.findLastVisibleItemPosition();
        adapter.setNight(isNight);
        long startTime = System.currentTimeMillis();
        Log.e("MainActivity", "switchDayNight time:" + startTime);
        for (int i = start - 3; i < end + 4; i++) {
            if (i < 0 || i >= adapter.getItemCount() || adapter.getData().get(i).getType() == Model.TYPE_2) {
                continue;
            }
            final int pos = i;
            recyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyItemChanged(pos);
                }
            }, 1500);

        }
        long endTime = System.currentTimeMillis();
        Log.e("MainActivity", "switchDayNight End time:" + endTime + ",cost=" + (endTime - startTime));
    }
}
