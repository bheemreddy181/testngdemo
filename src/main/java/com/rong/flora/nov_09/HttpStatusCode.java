package com.rong.flora.nov_09;

/**
 * Created by lafengnan on 2016/11/10.
 */
public enum HttpStatusCode {
    OK(200, "ok"),
    CREATED(201, "created"),
    FOUND(301, "found"),
    BAD_REQUEST(400, "bad request"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "forbidden"){
        public String toString(){
            return "403";
        }
    },
    NOT_FOUND(404, "not found"),
    INTERNAL_SERVER_ERROR(500, "internal server error"),
    BAD_GATEWAY(502, "bad gateway"),
    SERVICE_UNAVAILABLE(504, "service unavailable");

    private Integer code;
    private String reason;

    private HttpStatusCode(Integer code, String reason){
        this.code = code;
        this.reason = reason;
    }
}
