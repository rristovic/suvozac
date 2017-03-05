package com.android.suvozac.gpn.suvozac.internet;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonRequest;

/**
 * Created by Sarma on 3/3/2017.
 */

public class JSONReq extends JsonRequest {


    public JSONReq(int method, String url, String requestBody, Response.Listener listener, Response.ErrorListener errorListener) {
        super(method, url, requestBody, listener, errorListener);
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String getBodyContentType() {
        return super.getBodyContentType();
    }
}
