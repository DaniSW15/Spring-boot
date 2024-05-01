package com.api.controller;

import com.api.dto.ContactDTO;
import com.api.entity.Contact;
import com.api.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    Iterable<Contact> list() {
        return contactService.finAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Contact create(@Validated @RequestBody ContactDTO contactDTO) {
        return contactService.create(contactDTO);
    }

    @PutMapping("/update/{id}")
    public Contact update(@PathVariable Integer id,@Validated @RequestBody ContactDTO contactDTO) {
        return contactService.update(id, contactDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/list/{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }
}
