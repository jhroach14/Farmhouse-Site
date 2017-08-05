package com.webu.urban.pages;

public abstract class Page {

    protected String title;
    protected String template; //url location under /resources/templates

    public Page(){
    }

    public Page(String title, String template){
        this.title = title;
        this.template = template;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
