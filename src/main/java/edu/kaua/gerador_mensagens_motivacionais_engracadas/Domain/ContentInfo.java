package edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain;

public class ContentInfo {

    private String contentPath;
    private String textPath;
    private int contentX;
    private int contentY;
    private int textX;
    private int textY;

    public ContentInfo(String contentPath, String textPath) {
        this.contentPath = contentPath;
        this.textPath = textPath;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public String getTextPath() {
        return textPath;
    }

    public void setTextPath(String textPath) {
        this.textPath = textPath;
    }

    public int getContentX() {
        return contentX;
    }

    public void setContentX(int contentX) {
        this.contentX = contentX;
    }

    public int getContentY() {
        return contentY;
    }

    public void setContentY(int contentY) {
        this.contentY = contentY;
    }

    public int getTextX() {
        return textX;
    }

    public void setTextX(int textX) {
        this.textX = textX;
    }

    public int getTextY() {
        return textY;
    }

    public void setTextY(int textY) {
        this.textY = textY;
    }
}
