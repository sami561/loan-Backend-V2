package com.sami.microservice.notifsevice.email;

import lombok.Getter;

public enum EmailTemplates {

    ORDER_CONFIRMATION("order-confirmation.html", "Order confirmation")
    ;

    @Getter
    private final String template;
    @Getter
    private final String subject;


    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
