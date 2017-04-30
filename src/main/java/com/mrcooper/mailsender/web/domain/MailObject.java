package com.mrcooper.mailsender.web.domain;

public class MailObject {


    private String to;

    private String subject;

    private String mailBody;

    private String mailType;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMailBody() {

        return mailBody;
    }

    public void setMailBody(String mailBody) {

        this.mailBody = mailBody;
    }

    public String getMailType() {

        return mailType;
    }

    public void setMailType(String mailType) {

        this.mailType = mailType;
    }

    @Override
    public String toString() {

        return "MailObject [to=" + to + ", subject=" + subject + ", mailBody=" + mailBody + ", mailType=" + mailType
                + "]";
    }

}
