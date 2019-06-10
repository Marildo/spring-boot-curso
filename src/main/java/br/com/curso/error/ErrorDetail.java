package br.com.curso.error;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ErrorDetail {

    private String title;
    private int status;
    private String detail;
    private String developerMessage;
    private String path;
    private final LocalDateTime localDateTime;

    public ErrorDetail() {
        localDateTime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getPath(){return this.path;}

    public ErrorDetail setTitle(String title) {
        this.title = title;
        return this;
    }

    public ErrorDetail setStatus(int status) {
        this.status = status;
        return this;
    }

    public ErrorDetail setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public ErrorDetail setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public ErrorDetail setPath(String path) {
        this.path = path;
        return this;
    }
}
