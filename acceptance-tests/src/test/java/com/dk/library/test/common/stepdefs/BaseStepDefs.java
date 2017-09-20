package com.dk.library.test.common.stepdefs;

import com.dk.library.test.utils.ContextAttributes;
import com.jayway.restassured.response.Response;

public class BaseStepDefs {

    public static Object getAttribute(String attributeName) {
        return context().getAttribute(attributeName);
    }

    private static ContextAttributes context() {
        return com.dk.library.test.utils.ContextAttributes.getInstance();
    }

    public static void setAttribute(String attributeName, Object value) {
        context().setAttribute(attributeName, value);
    }

    public static void clear() {
        context().clear();
    }

    public static Response getResponse() {
        return (Response) context().getAttribute("response");
    }

    public static String getUsername() {
        return (String) context().getAttribute(CommonStepDefs.USERNAME_ATTR);
    }

    public static String getPassword() {
        return (String) context().getAttribute(CommonStepDefs.PASSWORD_ATTR);
    }

}
