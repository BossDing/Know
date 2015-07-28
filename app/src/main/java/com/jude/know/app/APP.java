package com.jude.know.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jude.beam.Beam;
import com.jude.http.RequestManager;
import com.jude.know.BuildConfig;
import com.jude.utils.JUtils;

/**
 * Created by zhuchenxi on 15/6/7.
 */
public class APP extends Application {
    private static APP instance;
    public static APP getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RequestManager.getInstance().init(this);
        RequestManager.getInstance().setDebugMode(true, "knowNet");
        Fresco.initialize(this);
        JUtils.initialize(this);
        JUtils.setDebug(BuildConfig.DEBUG,"knowDefault");
        Beam.init(this);
    }

    public String getToken(){
        return JUtils.getSharedPreference().getString("token","6043706ee3285eac33dcfaee9e32e576aed75948");
    }

    public void setToken(String token){
        JUtils.getSharedPreference().edit().putString("token", token).commit();
    }
}
