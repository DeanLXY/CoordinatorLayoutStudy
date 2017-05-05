package com.example.wangx.coordinatorlayoutstudy;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by wangx on 2017/5/5.
 */

public class MoveBehavior extends CoordinatorLayout.Behavior<Button> {
    public MoveBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        return dependency instanceof MoveView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {
        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = parent.getMeasuredWidth() - left - child.getWidth();
        int y = top;

        setChildPostion(child,x,y);
        return super.onDependentViewChanged(parent, child, dependency);
    }

    private void setChildPostion(View child, int x, int y) {
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.leftMargin = x;
        lp.topMargin = y;
    }
}
