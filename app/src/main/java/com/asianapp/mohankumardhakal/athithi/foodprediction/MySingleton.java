package com.asianapp.mohankumardhakal.athithi.foodprediction;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton minstance;
    private RequestQueue requestQueue;
    private static Context context;

    private MySingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getinstance(Context context) {
        if (minstance == null) {
            minstance = new MySingleton(context);
        }
        return minstance;
    }

    public void addToRequestQueue(Request request) {
        requestQueue.add(request);
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }

}
