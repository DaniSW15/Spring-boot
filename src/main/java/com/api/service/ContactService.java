package com.api.service;

import com.api.dto.ContactDTO;
import com.api.entity.Contact;
import com.api.exception.ResourceNotFound;
import com.api.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> finAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElseThrow(ResourceNotFound::new);
    }

    public Contact create(ContactDTO contactDTO) {
        Contact contact = mapper.map(contactDTO, Contact.class);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO) {
        Contact contactFromDB = findById(id);
        mapper.map(contactDTO, contactFromDB);
        return contactRepository.save(contactFromDB);
    }

    public void delete(Integer id) {
        Contact contactFormDB = findById(id);
        contactRepository.delete(contactFormDB);
    }
}
