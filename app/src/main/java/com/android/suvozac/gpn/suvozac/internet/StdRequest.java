package com.android.suvozac.gpn.suvozac.internet;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.android.suvozac.gpn.suvozac.internet.UrlData.PARAM_AUTH_TYPE;

public class StdRequest extends StringRequest {
    protected static final String TAG = StdRequest.class.getSimpleName();

    /** Key for error description object in JSON retrieved from the server */
    public static final String KEY_ERROR_DESC = "error_description";
    /** Key for error type object in JSON retrieved from the server */
    public static final String KEY_ERROR_TYPE = "error";
    /** Key for email object in JSON retrieved from the server */
    public static final String KEY_ERROR_EMAIL = "email";

    /** The types of error retrieved from the server */
    public interface ErrorType {
        /** Error type: merge_offer; when the account has already been created, merge proposition is presented */
        String MERGE = "merge_offer";
        /** When the account and facebook account has already been created, user can only login */
        String FULL_REGISTERED = "full_reg";
    }

    private Map<String, String> mParams;
    private Map<String, String> authHeader = new LinkedHashMap<>();
    private String mBody;

    public StdRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public void addParam(String key, String value) {
        if (mParams == null)
            mParams = new LinkedHashMap<>();
        mParams.put(key, value);
    }

    public void setAuthHeader(String key, String value) {
        authHeader.put(key, value);
    }

    public void setBody(String body){
        mBody = body;
    }

//    public void setBodyFromFollowedProfiles(ArrayList<UserProfile> list){
//        JSONArray jsonArray  = new JSONArray();
//
//        try {
//            Iterator i = list.iterator();
//            while (i.hasNext()) {
//                JSONObject object = new JSONObject();
//                object.put(UrlData.PARAM_FOLLOWED_USER_ID, ((UserProfile) i.next()).getUserId());
//                jsonArray.put(object);
//            }
//        } catch (JSONException e){
//            Log.e(TAG, e.getLocalizedMessage(), e);
//            mBody = null;
//        }
//
//        mBody = jsonArray.toString();
//    }
//
    public void setBodyFromComments(List list){
        JSONArray jsonArray  = new JSONArray();

//        try {
//            Iterator i = list.iterator();
//            while (i.hasNext()) {
//                JSONObject object = new JSONObject();
////                object.put(UrlData.PARAM_FOLLOWED_USER_ID, ((UserProfile) i.next()).getUserId());
//                jsonArray.put(object);
//            }
//        }
//        catch (JSONException e){
//            Log.e(TAG, e.getLocalizedMessage(), e);
//            mBody = null;
//        }

        mBody = jsonArray.toString();
    }

    public void setAuthHeader(String value) {
        authHeader.put(PARAM_AUTH_TYPE, String.format("Bearer %s", value));
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }

    @Override
    public String getBodyContentType() {
//        return super.getBodyContentType();
        return "application/x-www-form-urlencoded";
    }



    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return authHeader;
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        return mBody == null ? super.getBody() : mBody.getBytes();
    }

    protected boolean cacheHit;

    @Override
    public void addMarker(String tag) {
        super.addMarker(tag);
        cacheHit = false;
        if (tag.equals("cache-hit")){
            cacheHit = true;
        }
    }
}
