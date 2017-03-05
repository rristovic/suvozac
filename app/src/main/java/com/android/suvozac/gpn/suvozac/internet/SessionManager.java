package com.android.suvozac.gpn.suvozac.internet;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.android.suvozac.gpn.suvozac.internet.UrlData.PARAM_CLIENT_ID;
import static com.android.suvozac.gpn.suvozac.internet.UrlData.PARAM_CLIENT_ID_VALUE;
import static com.android.suvozac.gpn.suvozac.internet.UrlData.PARAM_CLIENT_SECRET;
import static com.android.suvozac.gpn.suvozac.internet.UrlData.PARAM_CLIENT_SECRET_VALUE;
import static com.android.suvozac.gpn.suvozac.internet.UrlData.PARAM_PASSWORD;
import static com.android.suvozac.gpn.suvozac.internet.UrlData.PARAM_USERNAME;

/**
 * Class for managing user session and authorisation with the server;
 * It is used for logging in, signing up, logging out and device authorisation;
 * Session variables will be stored in {@link com.android.suvozac.gpn.suvozac.MyApplication};
 */
public class SessionManager {

    private static SessionManager mInstance;
    private Context mAppContext;

    public static SessionManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SessionManager(context);
        }

        return mInstance;
    }

    private SessionManager(Context context) {
        mAppContext = context.getApplicationContext();
    }

    private RequestQueue mRequestQueue;


    /**
     * Helper method for registering new user with the server.
     * Send standard request with given params and authorisation header.
     *
     * @param userName  user's username
     * @param pass      user's password
     * @param firstName user's first name
     * @param lastName  user's last name
     */
    public void registerUser(String userName, String pass, String firstName, String lastName) {
        JSONObject object = new JSONObject();

        try {
//            object.put(PARAM_USERNAME, userName);
//            object.put(PARAM_PASSWORD, pass);
//            object.put(PARAM_FIRST_NAME, firstName);
//            object.put(PARAM_LAST_NAME, lastName);
//            object.put(PARAM_PASSWORD, pass);
            object.put(PARAM_CLIENT_ID, PARAM_CLIENT_ID_VALUE);
            object.put(PARAM_CLIENT_SECRET, PARAM_CLIENT_SECRET_VALUE);
            object.put("grant_type", "password");
            object.put(PARAM_USERNAME,"milos");
            object.put(PARAM_PASSWORD,"ljilja");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        StdRequest request = new StdRequest(Request.Method.GET, UrlData.GET_USERS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Parsing an error
//                        NetworkResponse response = error.networkResponse;
//                        String errorData = new String(response.data);
                    }
                });
//        request.setBody(object.toString());
//        request.addParam(""
        request.setAuthHeader("uikOOpQPc817aCcxZqT700LcGcEN1d");

        sendRequest(request);
    }

    private void sendRequest(Request request) {
        getReqQueue().add(request);
    }

    private RequestQueue getReqQueue(){
        if (mRequestQueue == null)
            mRequestQueue = Volley.newRequestQueue(mAppContext);

        return mRequestQueue;
    }
}
