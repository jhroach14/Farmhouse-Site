package com.webu.urban.controllers;

import com.webu.urban.entities.RegistryEntry;
import com.webu.urban.entities.User;
import com.webu.urban.entities.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//This spring controller class handles all data requests
public class DataController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AboutPageRepository aboutPageRepository;
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private GallerySectionRepository sectionRepository;
    @Autowired
    private InteriorRepository interiorRepository;
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private RegistryPageRepository registryPageRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegistryEntryRepository entryRepository;

    //only users are admins
    @RequestMapping(value = "/admin/saveAdmin", method = RequestMethod.POST)
    public User saveAdmin(@RequestBody User user){

        log.debug("Received new user entity with name "+user.getUsername());
        user = userRepository.save(user);
        log.debug("Returning saved highlight entity with id "+user.getId());

        return user;
    }

    @RequestMapping(value = "/admin/deleteAdmin", method = RequestMethod.POST)
    public User deleteAdmin(@RequestBody User user){

        log.debug("Deleting user entity with id "+user.getId());
        userRepository.delete(user);
        log.debug("Returning successful user entity delete");

        return null;
    }

    @RequestMapping(value = "/validateCode", method = RequestMethod.GET)
    public RegistryEntry validateCode(@RequestParam(value = "code") String code){

        RegistryEntry entry = entryRepository.findByCode(code);

        if(entry!=null){
            log.debug("valid code recieved sending registry entry for "+ entry.getRecipient());
            return entry;
        }else{
            log.debug("invalid code received");
            return null;
        }
    }

    //TODO: Implment rest of crud API when more of frontend is finished


}
