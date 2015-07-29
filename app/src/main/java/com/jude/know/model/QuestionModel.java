package com.jude.know.model;

import android.content.Context;

import com.jude.beam.model.AbsModel;
import com.jude.http.RequestManager;
import com.jude.http.RequestMap;
import com.jude.know.app.APP;
import com.jude.know.config.API;
import com.jude.know.model.bean.AnswerResult;
import com.jude.know.model.bean.QuestionResult;
import com.jude.know.model.callback.DataCallback;
import com.jude.know.model.callback.StatusCallback;
import com.jude.utils.JUtils;

/**
 * Created by zhuchenxi on 15/6/7.
 */
public class QuestionModel extends AbsModel {
    private static final QuestionModel model = new QuestionModel();
    public static QuestionModel getInstance(){
        return model;
    }
    @Override
    protected void onAppCreate(Context ctx) {
        JUtils.Log("knowLog", "QuestionModel begin");
    }

    public void getQuestionsFromServer(int page,DataCallback<QuestionResult> callback){
        RequestManager.getInstance().post(API.URL.GetQuestionList, new RequestMap("page", page + ""), callback);
    }

    public void publicQuestion(String title,String content,StatusCallback callback){
        RequestMap params = new RequestMap();
        params.put("title",title);
        params.put("content",content);
        params.put("token", APP.getInstance().getToken());
        RequestManager.getInstance().post(API.URL.PublicQuestion,params,callback);
    }

    public void getAnswerFromServer(int page,String questionId,boolean desc,DataCallback<AnswerResult> callback){
        RequestMap params = new RequestMap();
        params.put("page",page+"");
        params.put("questionId",questionId);
        params.put("desc", desc?"true":"false");
        RequestManager.getInstance().post(API.URL.GetAnswerList,params,callback);
    }

    public void publicAnswer(String questionId,String answer,StatusCallback callback){
        RequestMap params = new RequestMap();
        params.put("questionId",questionId);
        params.put("content",answer);
        params.put("token", APP.getInstance().getToken());
        RequestManager.getInstance().post(API.URL.PublicAnswer,params,callback);
    }
}
