package com.brainacad.passwordReminder;

import java.util.Date;
import java.util.Objects;

public class Record {
    private String site;
    private String login;
    private String password;
    private Date recordDate = new Date();
    public Record(){
    }
    public Record(String site, String login, String password){
        this.site=site;
        this.login=login;
        this.password=password;
    }

    public Date getRecordDate(){
        return recordDate;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String toString(){
        StringBuffer sb=new StringBuffer(100);

        return (sb.append("Site: ").append(site).append(" login: ").append(login).append(" password=").append(password).append(" created: ").append(recordDate).toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(site, login, password, recordDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return site.equals(record.site) &&
                login.equals(record.login) &&
                password.equals(record.password) &&
                recordDate.equals(record.recordDate);
    }
}
