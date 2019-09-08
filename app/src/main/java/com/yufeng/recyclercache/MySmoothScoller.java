package com.yufeng.recyclercache;

import android.content.Context;
import android.support.v7.widget.LinearSmoothScroller;

/**
 * Created by yufeng on 2019/9/7.
 */

public class MySmoothScoller extends LinearSmoothScroller{
    public MySmoothScoller(Context context){
        super(context);
    }

    @Override
    protected int calculateTimeForDeceleration(int dx) {
        return 0;
    }
}
