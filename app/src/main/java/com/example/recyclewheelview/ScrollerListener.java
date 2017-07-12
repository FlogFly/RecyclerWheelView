package com.example.recyclewheelview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

/**
 * Project:RecycleWheelView
 * Author:dyping
 * Date:2017/7/11 13:48
 */

public class ScrollerListener extends RecyclerView.OnScrollListener {

    Context mContext;
    int itemHeight;

    public ScrollerListener(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        itemHeight = (int) TypedValue.applyDimension(COMPLEX_UNIT_DIP, 70, mContext.getResources().getDisplayMetrics());
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        switch (newState) {

            case RecyclerView.SCROLL_STATE_IDLE:

                int scrollY = getScollYDistance(recyclerView);
                int divider = scrollY / itemHeight;
                int remainder = scrollY % itemHeight;
                if (remainder != 0) {
                    if (remainder > itemHeight / 2) {
                        smoothMoveToPosition(divider + 1, recyclerView, (LinearLayoutManager) recyclerView.getLayoutManager());
                    } else {
                        smoothMoveToPosition(divider, recyclerView, (LinearLayoutManager) recyclerView.getLayoutManager());
                    }
                }
                break;
        }
    }

    public int getScollYDistance(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int position = layoutManager.findFirstVisibleItemPosition();
        View firstVisiableChildView = layoutManager.findViewByPosition(position);
        int itemHeight = firstVisiableChildView.getHeight();
        return (position) * itemHeight - firstVisiableChildView.getTop();
    }

    private void smoothMoveToPosition(int n, RecyclerView mRecyclerView, LinearLayoutManager mLinearLayoutManager) {
        int firstItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        if (firstItem == n) {
            int top = mRecyclerView.getChildAt(n - firstItem + 1).getTop();
            mRecyclerView.smoothScrollBy(0, -(itemHeight - top));

        } else {
            int top = mRecyclerView.getChildAt(n - firstItem).getTop();
            mRecyclerView.smoothScrollBy(0, top);
        }
    }
}
