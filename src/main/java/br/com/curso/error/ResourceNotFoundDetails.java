package br.com.curso.error;

import java.time.LocalDateTime;

public class ResourceNotFoundDetails {

    private String title;
    private int status;
    private String detail;
    private LocalDateTime localDateTime;
    private String developerMessage;
    private String path;

    public ResourceNotFoundDetails() {

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

    public ResourceNotFoundDetails setTitle(String title) {
        this.title = title;
        return this;
    }

    public ResourceNotFoundDetails setStatus(int status) {
        this.status = status;
        return this;
    }

    public ResourceNotFoundDetails setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public ResourceNotFoundDetails setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public ResourceNotFoundDetails setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public ResourceNotFoundDetails setPath(String path) {
        this.path = path;
        return this;
    }
}
