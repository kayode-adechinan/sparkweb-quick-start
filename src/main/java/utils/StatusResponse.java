package utils;

/**
 * Created by atsk1618 on 6/12/2017.
 */
public enum StatusResponse {
    SUCCESS("Success"), ERROR("Error");

    final private String status;

    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
