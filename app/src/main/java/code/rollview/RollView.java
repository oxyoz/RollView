package code.rollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;

import android.os.Handler;

import java.util.List;

/**
 * Created by blue on 2015/7/19.
 */
public class RollView extends ViewFlipper implements Runnable
{

    public RollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init();

    }

    public RollView(Context context)
    {
        super(context);

        init();
    }

    private void init()
    {

        mHandler = new Handler();

        setEnterAndExitAnimation();

    }


    /*
    *
    * 设置淡入淡出动画
    *
    * */
    public void setEnterAndExitAnimation()
    {

        setInAnimation(getContext(), R.anim.abc_slide_in_bottom);

        setOutAnimation(getContext(), R.anim.abc_slide_out_top);

    }

    public RollView setAdapter(List<View> views)
    {

        if (mViews == null) mViews = views;

        for (View v : mViews)
        {
            addView(v);
        }

        return this;

    }

    public RollView setDelayed(int delayed)
    {

        mDelayed = delayed;

        return this;

    }

    public void start()
    {

        isStart = !isStart;

        mHandler.postDelayed(this, mDelayed);

    }


    public void stop()
    {

        isStart = !isStart;

    }

    /**
     * Starts executing the active part of the class' code. This method is
     * called when a thread is started that has been created with a class which
     * implements {@code Runnable}.
     */
    @Override
    public void run()
    {

        showNext();

        if (isStart) mHandler.postDelayed(this, mDelayed);

    }


    private int mDelayed;//每次滚动的时间间隔

    private boolean isStart;//判断滚动是否结束

    private List<View> mViews;//需要滚动的View集合

    private Handler mHandler;//处理View滚动刷新

}
