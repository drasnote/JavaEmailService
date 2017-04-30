package com.mrcooper.mailsender.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrcooper.mailsender.mail.EmailService;
import com.mrcooper.mailsender.web.domain.MailObject;
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { GET, PUT, POST, DELETE })
@RequestMapping("/mail")
public class MailController {

    @Autowired
    public EmailService emailService;

    @RequestMapping(value = "/send", method = POST)
    public void createMail(@RequestBody MailObject mailObject) {


        System.out.println(mailObject);
        emailService.sendSimpleMessage(mailObject.getTo(), mailObject.getSubject(), mailObject.getMailBody());
    }

    /*
     * @RequestMapping(value = "/sendHtml", method = POST) public void
     * createHTMLMail(@RequestBody MailObject mailObject) {
     *
     * emailService.sendHtmlMessage(mailObject.getTo(), mailObject.getSubject(),
     * new HashMap<>()); }
     */
    public static void main(String[] args) {



    }