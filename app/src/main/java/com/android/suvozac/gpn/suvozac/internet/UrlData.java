package com.android.suvozac.gpn.suvozac.internet;

public class UrlData {

    public static final String BASE_URL = "https://beta-suvozac-markossify95.c9users.io/";

    public static final String PARAM_CLIENT_ID = "client_id";
    public static final String PARAM_CLIENT_ID_VALUE = "G390fOyQ9SOuCaJlV3Czli0ImzyiARtttZXtUTIr";
    public static final String PARAM_CLIENT_SECRET = "client_secret";
    public static final String PARAM_CLIENT_SECRET_VALUE = "RnJLTZw2x3Q1OyKPthSnmMJebOypxuX54oQb7xYzEB7W5pYWlpCM8jXJLWwRMhvjsl5lmTwI9TWRw1HJ4EbC5pKZlrzPcQsCXgzN72rAtprjxscfBR4SXs4iuVmCjACz";
    public static final String PARAM_AUTH_TYPE = "Authorization";

    /** Sign up endpoint **/
    public static final String SIGN_UP_URL = BASE_URL.concat("signup/");
    /** Token endpoint **/
    public static final String TOKEN_URL = BASE_URL.concat("o/token/");

    /** Getting users endpoint **/
    public static final String GET_USERS_URL = BASE_URL.concat("users/");

    public static final String PARAM_USERNAME = "username";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_FIRST_NAME = "first_name";
    public static final String PARAM_LAST_NAME = "last_name";
    public static final String PARAM_EMAIL = "email";

    /** User type can be: 'D' - driver; 'S' - service **/
    public static final String PARAM_USER_TYPE = "user_type";
}
