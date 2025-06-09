package com.kodilla.spring.basic.spring_dependency_injection;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import javax.annotation.Resource;

@Component
public class SimpleApplication {

    //3 sposob

    //komantarze tuz ponizej na potrzeby 9.3
    @Autowired

    public void setMessageService(SkypeMessageService messageService) {
        this.messageService = messageService;
    }

    @Autowired
    private SkypeMessageService messageService;

    //@Resource(name = "skypeMessageService")
    // private MessageService messageService;

   /* public SimpleApplication(MessageService messageService) {
        this.messageService = messageService;
    }*/
    //public SimpleApplication(SkypeMessageService messageService) {
    //   this.messageService = messageService;
    // }

    // zamiast konstruktora powyzej autowired w celu wstrzykiwania zaleznosci do pola a nie wstrzykiwanie przez konstruktor

    public String processMessage(String message, String receiver) {
        if (checkReceiver(receiver)) {
            return this.messageService.send(message, receiver);
        }
        return null;
    }

    private boolean checkReceiver(String receiver) {
        return receiver != null && !receiver.isEmpty();
    }
}
