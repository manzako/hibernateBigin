package com.desktoptry.stage.controller;

import com.desktoptry.stage.data.MessageDAO;
import com.desktoptry.stage.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Messagecontroller {

    @Autowired
    private MessageDAO messageDAO;

    @GetMapping("/msg")
    public String showMessage(Model model){


        model.addAttribute("msglist",messageDAO.findAll());
        model.addAttribute("newMessage",new Message());
        return "MesPage";
    }

    @PostMapping("/msg")
    public String postMessage(@ModelAttribute Message newMessage){
        Message msg=new Message(newMessage.getAuthor(),newMessage.getMessage());
        messageDAO.save(msg);
        return "redirect:msg";
    }
}
