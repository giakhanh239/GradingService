package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;
import com.example.demo.model.MessageResponse;
import com.example.demo.response.Response;
import com.example.demo.service.NotificationService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("utility")
public class NotificationContronller {

    @PostMapping("/notify")
    public ResponseEntity postMethodName(@RequestBody Message message) {

        boolean isOk = NotificationService.sendNotification(message.getMessage());
        if(isOk)
            return ResponseEntity.ok(new MessageResponse("success", 200, " Gửi thông báo thành công", ""));
        return new ResponseEntity<Response>(new Response("failed", "Đã xảy ra lỗi khi gửi thông báo!"), HttpStatus.EXPECTATION_FAILED);
    }
    
}
