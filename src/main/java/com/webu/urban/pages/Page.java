package com.webu.urban.pages;

public abstract class Page {

    protected String title;
    protected String template; //url location under /resources/templates
    protected String permissions;

    public Page(){
    }

    public Page(String title, String template,String permissions){
        this.title = title;
        this.template = template;
        this.permissions=permissions;
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

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
