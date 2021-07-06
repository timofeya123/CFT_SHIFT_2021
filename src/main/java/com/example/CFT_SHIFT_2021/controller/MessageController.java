package com.example.CFT_SHIFT_2021.controller;

import com.example.CFT_SHIFT_2021.entity.MessageEntity;
import com.example.CFT_SHIFT_2021.entity.UserEntity;
import com.example.CFT_SHIFT_2021.exception.UserExistsException;
import com.example.CFT_SHIFT_2021.repository.MessageCRUD;
import com.example.CFT_SHIFT_2021.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;

@RestController
@RequestMapping
public class MessageController {


    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageCRUD messageCRUD; // создаём интерфейс для взаимодействия с бд

    @PostMapping("/message") // создать
    public ResponseEntity registration(@RequestBody MessageEntity message) throws Exception {
        try {
            messageService.registration(message);
            return ResponseEntity.ok(message);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("code: USER_NOT_FOUND_ERROR_MESSAGE");
        }
    }

    @GetMapping("/messages") // взять
    public ResponseEntity getMessages(){
        try {
            return ResponseEntity.ok(messageCRUD.findAll());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("code: MESSAGE_NOT_FOUND");
        }
    }
}
