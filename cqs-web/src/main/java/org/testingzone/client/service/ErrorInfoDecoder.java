package org.testingzone.client.service;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import org.testingzone.vo.error.ErrorInfo;

public class ErrorInfoDecoder {

    public static ErrorInfo decode(String text) {
        if (text == null) {
            return ErrorInfo.EMPTY;
        }

        JavaScriptObject jsObject = JsonUtils.safeEval(text);
        JSONObject jsonObject = new JSONObject(jsObject);
        JSONValue errorValue = jsonObject.get("error");
        JSONValue messageValue = jsonObject.get("message");
        JSONValue detailsValue = jsonObject.get("details");

        return new ErrorInfo(errorValue.toString(), messageValue.toString(), detailsValue.toString());
    }
}
