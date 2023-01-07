package com.barrista.jdm.forum.controller;

import com.barrista.jdm.forum.domain.Message;
import com.barrista.jdm.forum.domain.Views;
import com.barrista.jdm.forum.repo.MessageRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo)
    {
        this.messageRepo = messageRepo;
    }

//  private int counter = 4;
//
//  private List<Map<String, String>> messages =
//      new ArrayList<Map<String, String>>() {{
//          add(
//              new HashMap<>() {
//                {
//                  put("id", "1");
//                  put("text", "First message");
//                }
//              });
//          add(
//              new HashMap<>() {
//                {
//                  put("id", "2");
//                  put("text", "Second message");
//                }
//              });
//          add(
//              new HashMap<>() {
//                {
//                  put("id", "3");
//                  put("text", "Third message");
//                }
//              });
//        }};

  @GetMapping
  @JsonView(Views.IdName.class)
  public List<Message> list() {
    return messageRepo.findAll();
  }

  @GetMapping("{id}")
  @JsonView(Views.FullMessage.class)
  public Message getOne(@PathVariable("id") Message message) {
    return message;
  }

  @PostMapping
  public Message create(@RequestBody Message message) {
        message.setCreated(LocalDateTime.now());
    return messageRepo.save(message);
  }

  @PutMapping("{id}")
  public Message update(
          @PathVariable("id") Message messageFromDb,
          @RequestBody Message message) {
      BeanUtils.copyProperties(message, messageFromDb, "id");
      return messageRepo.save(messageFromDb);
  }

  @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
      messageRepo.delete(message);
  }
}
