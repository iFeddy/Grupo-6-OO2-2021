package com.unla.app.models;

import java.util.Objects;

public class RESTErrorModel {
    private int status;
    private String statusText;

    public RESTErrorModel() {
    }

    public RESTErrorModel(int status, String statusText) {
        this.status = status;
        this.statusText = statusText;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public RESTErrorModel status(int status) {
        setStatus(status);
        return this;
    }

    public RESTErrorModel statusText(String statusText) {
        setStatusText(statusText);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RESTErrorModel)) {
            return false;
        }
        RESTErrorModel rESTErrorModel = (RESTErrorModel) o;
        return status == rESTErrorModel.status && Objects.equals(statusText, rESTErrorModel.statusText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, statusText);
    }

    @Override
    public String toString() {
        return "{" +
            " status='" + getStatus() + "'" +
            ", statusText='" + getStatusText() + "'" +
            "}";
    }

}
