package com.google.android.topbardemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by passionli on 2015/3/25.
 */
public class TopBar extends RelativeLayout {

    private TextView mTitleTextView;
    private Button mLeftButton;
    private Button mRightButton;

    private String mTitleText;
    private int mTitleColor;
    private float mTitleSize;

    private String mLeftText;
    private int mLeftColor;
    private float mLeftSize;

    private String mRightText;
    private int mRightColor;
    private float mRightSize;


    private OnClickListener listener;

    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        mTitleText = typedArray.getString(R.styleable.TopBar_titleText);
        mTitleColor = typedArray.getColor(R.styleable.TopBar_titleColor, 0);
        mTitleSize = typedArray.getDimension(R.styleable.TopBar_titleSize, 0);

        mLeftText = typedArray.getString(R.styleable.TopBar_leftText);
        mLeftColor = typedArray.getColor(R.styleable.TopBar_leftColor, 0);
        mLeftSize = typedArray.getDimension(R.styleable.TopBar_leftSize, 0);

        mRightText = typedArray.getString(R.styleable.TopBar_rightText);
        mRightColor = typedArray.getColor(R.styleable.TopBar_rightColor, 0);
        mRightSize = typedArray.getDimension(R.styleable.TopBar_rightSize, 0);

        mTitleTextView = new TextView(context);
        mTitleTextView.setText(mTitleText);
        mTitleTextView.setTextSize(mTitleSize);
        mTitleTextView.setTextColor(mTitleColor);
        mTitleTextView.setGravity(Gravity.CENTER);
        mTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onMiddleClick(view);
            }
        });

        mLeftButton = new Button(context);
        mLeftButton.setText(mLeftText);
        mLeftButton.setTextSize(mLeftSize);
        mLeftButton.setTextColor(mLeftColor);
        mLeftButton.setGravity(Gravity.CENTER);
        mLeftButton.setBackgroundDrawable(typedArray.getDrawable(R.styleable.TopBar_leftBackground));
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onLeftClick(view);
            }
        });

        mRightButton = new Button(context);
        mRightButton.setText(mRightText);
        mRightButton.setTextSize(mRightSize);
        mRightButton.setTextColor(mRightColor);
        mRightButton.setGravity(Gravity.CENTER);
        mRightButton.setBackgroundDrawable(typedArray.getDrawable(R.styleable.TopBar_rightBackground));
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onRightClick(view);
            }
        });


        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleTextView, params);

        LayoutParams leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton, leftParams);

        LayoutParams rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, rightParams);

        typedArray.recycle();
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void setVisibility(TOP_BAR_POSITION index, int flag) {
        switch (index) {
            case LEFT:
                mLeftButton.setVisibility(flag);
                break;
            case RIGHT:
                mRightButton.setVisibility(flag);
                break;
            case MIDDLE:
                mTitleTextView.setVisibility(flag);
                break;
        }
    }

    public void setText(TOP_BAR_POSITION index, String text) {
        switch (index) {
            case LEFT:
                mLeftButton.setText(text);
                break;
            case RIGHT:
                mRightButton.setText(text);
                break;
            case MIDDLE:
                mTitleTextView.setText(text);
                break;
        }
    }

    public enum TOP_BAR_POSITION {
        LEFT, MIDDLE, RIGHT
    }

    public interface OnClickListener {
        void onLeftClick(View view);

        void onMiddleClick(View view);

        void onRightClick(View view);
    }
}
