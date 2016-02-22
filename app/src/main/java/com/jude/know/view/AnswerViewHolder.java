package com.jude.know.view;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.know.R;
import com.jude.know.bean.Answer;
import com.jude.know.util.RecentDateFormat;
import com.jude.utils.JTimeTransform;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by zhuchenxi on 15/6/8.
 */
public class AnswerViewHolder extends BaseViewHolder<Answer> {
    private TextView name;
    private ImageView face;
    private TextView date;
    private TextView content;

    public AnswerViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_answer);
        name = $(R.id.name);
        face = $(R.id.face);
        date = $(R.id.date);
        content = $(R.id.content);
    }

    @Override
    public void setData(Answer data) {
        name.setText(data.getAuthorName());
        Glide.with(getContext())
                .load(data.getAuthorFace())
                .error(R.drawable.ic_person_gray)
                .placeholder(R.drawable.ic_person_gray)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(face);
        date.setText(new JTimeTransform().parse("yyyy-MM-dd HH:mm:ss",data.getDate()).toString(new RecentDateFormat()));
        content.setText(data.getContent());
    }
}
