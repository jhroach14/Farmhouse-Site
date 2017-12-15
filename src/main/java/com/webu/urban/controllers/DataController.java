package com.webu.urban.controllers;

import com.webu.urban.entities.*;
import com.webu.urban.entities.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.ConvertGroup;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegistryEntryRepository entryRepository;
    @Autowired
    private HomePhotoRepository homePhotoRepository;
    @Autowired
    private InspireRepository inspireRepository;
    @Autowired
    private GallerySectionGroupRepository gallerySectionGroupRepository;
    @Autowired
    private GallerySectionRepository gallerySectionRepository;


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

    //angular will hit this endpoint for editdata for about page
    @RequestMapping(value = "/admin/photoList", method = RequestMethod.GET)
    public Iterable<Photo> photoList(){
        log.debug("Received new photoList Request");
        Iterable<Photo> photos = photoRepository.findAll();
        log.debug("Returning photoList");
        return photos;
    }

    @RequestMapping(value = "/admin/aboutInfo", method = RequestMethod.GET)
    public AboutInfo aboutInfo(){

        log.debug("Received new aboutInfo Request");
        AboutInfo aboutInfo = aboutPageRepository.findOne(1);
        log.debug("Returning aboutInfo");
        return aboutInfo;
    }

    @RequestMapping(value = "/admin/aboutEdit", method = RequestMethod.POST)
    public AboutInfo aboutEdit(@RequestBody AboutInfo aboutInfo){

        log.debug("Received new aboutInfo to save");
        aboutPageRepository.save(aboutInfo);
        log.debug("Returning saved aboutInfo");
        return aboutInfo;
    }

    @RequestMapping(value = "/admin/registryInfo", method = RequestMethod.GET)
    public RegistryInfo registryInfo(){

        log.debug("Received new registryInfo Request");
        RegistryInfo registryInfo = registryPageRepository.findOne(1);
        log.debug("Returning registryInfo");
        return registryInfo;
    }

    @RequestMapping(value = "/admin/registryEdit", method = RequestMethod.POST)
    public RegistryInfo registryEdit(@RequestBody RegistryInfo registryInfo){

        log.debug("Received new regInfo to save");
        registryPageRepository.save(registryInfo);
        log.debug("Returning saved regInfo");
        return registryInfo;
    }

    @RequestMapping(value = "/admin/homePhotos", method = RequestMethod.GET)
    public Iterable<HomePhoto> homePhotos(){

        log.debug("Received new homePhotos request");
        Iterable<HomePhoto> photoLinks = homePhotoRepository.findAll();
        ArrayList<HomePhoto> photos = new ArrayList<HomePhoto>();
        for( HomePhoto hp : photoLinks){
            photos.add(hp);
        }
        log.debug("Returning homePhotos");
        return photos;
    }


    @RequestMapping(value = "/admin/homeEdit", method = RequestMethod.POST)
    public Iterable<HomePhoto> homePhotos(@RequestBody Iterable<HomePhoto> homePhotos){

        log.debug("Received new homePhotos edit submission to save");
        homePhotoRepository.save(homePhotos);
        log.debug("Returning saved homePhotos");
        return homePhotos;
    }

    @RequestMapping(value = "/admin/addNewHomePhoto", method = RequestMethod.POST)
    public HomePhoto homePhoto(@RequestBody Photo photo){

        log.debug("Received new homePhoto add");
        HomePhoto newPhoto = new HomePhoto(photo);
        homePhotoRepository.save(newPhoto);
        log.debug("Returning saved homePhotos");
        return newPhoto;
    }

    @RequestMapping(value = "/admin/deletePhoto", method = RequestMethod.GET)
    public void deletePhoto(@RequestBody HomePhoto photo){

        log.debug("received delete request for a homePhoto");
        homePhotoRepository.delete(photo);
        log.debug("deleted a homePhoto");
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

    @RequestMapping(value = "/admin/inspireInfo", method = RequestMethod.GET)
    public InspireInfo inspireInfo(){

        log.debug("Received new inspireInfo Request");
        InspireInfo inspireInfo = inspireRepository.findOne(1);
        log.debug("Returning inspireInfo");
        return inspireInfo;
    }

    @RequestMapping(value = "/admin/getPost", method = RequestMethod.GET)
    public BlogPost getPost(@RequestParam(value = "post") int id){

        log.debug("received request for post with id "+id);
        BlogPost post = blogPostRepository.findOne(id);
        log.debug("sent back post with id "+ id);
        return post;
    }

    @RequestMapping(value = "/admin/deletePost", method = RequestMethod.GET)
    public void deletePost(@RequestParam(value = "post") int id){

        log.debug("received delete request for post with id "+id);
        blogPostRepository.delete(id);
        log.debug("deleted post with id "+ id);
    }

    @RequestMapping(value = "/admin/inspireEdit", method = RequestMethod.POST)
    public InspireInfo inspireEdit(@RequestBody InspireInfo inspireInfo){

        log.debug("Received new inspireInfo to save");
        inspireRepository.save(inspireInfo);
        log.debug("Returning saved inspire info");
        return inspireInfo;
    }

    @RequestMapping(value = "/admin/postEdit", method = RequestMethod.POST)
    public BlogPost postEdit(@RequestBody BlogPost blogPost){

        log.debug("Received edited post to save");
        blogPostRepository.save(blogPost);
        log.debug("Returning saved post");
        return blogPost;
    }

    @RequestMapping(value = "/admin/newPost", method = RequestMethod.POST)
    public BlogPost newPost(@RequestBody BlogPost blogPost){

        log.debug("Received new post to save");
        blogPost.setPost_date(new Date());
        blogPostRepository.save(blogPost);
        log.debug("Returning saved post");
        return blogPost;
    }

    //start of interiors crud
    @RequestMapping(value = "/admin/Interiors", method = RequestMethod.GET)
    public Iterable<Interior> Interiors(){

        log.debug("Received new interiors request");
        Iterable<Interior> intLinks = interiorRepository.findAll();
        ArrayList<Interior> interiors = new ArrayList<Interior>();
        for( Interior i : intLinks){
            interiors.add(i);
        }
        log.debug("Returning Interiors");
        return interiors;
    }
    @RequestMapping(value = "/admin/deleteInterior", method = RequestMethod.GET)
    public Interior deleteInterior(@RequestBody Interior toDelete){

        log.debug("Received new interior delete request");
        interiorRepository.delete(toDelete);
        log.debug("Returning deleted Interior");
        return toDelete;
    }
    @RequestMapping(value = "/admin/addInterior", method = RequestMethod.GET)
    public Interior addInterior(@RequestBody String address){

        Interior toAdd = new Interior(address, new ArrayList<Photo>());
        log.debug("Received new interior add request");
        interiorRepository.save(toAdd);
        log.debug("Returning added Interior");
        return toAdd;
    }
    @RequestMapping(value = "/admin/deleteInteriorPhoto", method = RequestMethod.GET)
    public Interior deleteInteriorPhoto(@RequestBody Interior toUpdate, Photo toDelete) {

        log.debug("Received new interior photo delete request");
        Iterable<Photo> currentPhotos = toUpdate.getPhotos();
        ArrayList<Photo> nonDeletedPhotos = new ArrayList<Photo>();
        for (Photo p : currentPhotos) {
            if (p.equals(toDelete)) {
                continue;
            }
            nonDeletedPhotos.add(p);
        }
        toUpdate.setPhotos(nonDeletedPhotos);
        log.debug("Returning updated Interior");
        return toUpdate;
    }
    @RequestMapping(value = "/admin/addInteriorPhoto", method = RequestMethod.GET)
    public Interior addInteriorPhoto(@RequestBody Interior toUpdate, Photo toAdd){

        log.debug("Received new interior photo add request");
        Iterable<Photo> currentPhotos = toUpdate.getPhotos();
        ArrayList<Photo> appendedPhotos = new ArrayList<Photo>();
        for(Photo p : currentPhotos){
            appendedPhotos.add(p);
        }
        appendedPhotos.add(toAdd);
        toUpdate.setPhotos(appendedPhotos);
        log.debug("Returning updated Interior");
        return toUpdate;
    }


    //start of events crud
    @RequestMapping(value = "/admin/Events", method = RequestMethod.GET)
    public Iterable<Event> Events(){

        log.debug("Received new Events request");
        Iterable<Event> evLinks = eventRepository.findAll();
        ArrayList<Event> events = new ArrayList<Event>();
        for( Event e : evLinks){
            events.add(e);
        }
        log.debug("Returning Events");
        return events;
    }
    @RequestMapping(value = "/admin/deleteEvent", method = RequestMethod.GET)
    public Event deleteEvent(@RequestBody Event toDelete){

        log.debug("Received new event delete request");
        eventRepository.delete(toDelete);
        log.debug("Returning deleted event");
        return toDelete;
    }
    @RequestMapping(value = "/admin/addEvent", method = RequestMethod.GET)
    public Event addEvent(@RequestBody String name, String description){

        Event toAdd = new Event(name, description, new ArrayList<Photo>());
        log.debug("Received new event add request");
        eventRepository.delete(toAdd);
        log.debug("Returning added event");
        return toAdd;
    }
    @RequestMapping(value = "/admin/deleteEventPhoto", method = RequestMethod.GET)
    public Event deleteEventPhoto(@RequestBody Event toUpdate, Photo toDelete) {

        log.debug("Received new event photo delete request");
        Iterable<Photo> currentPhotos = toUpdate.getPhotos();
        ArrayList<Photo> nonDeletedPhotos = new ArrayList<Photo>();
        for (Photo p : currentPhotos) {
            if (p.equals(toDelete)) {
                continue;
            }
            nonDeletedPhotos.add(p);
        }
        toUpdate.setPhotos(nonDeletedPhotos);
        log.debug("Returning updated event");
        return toUpdate;
    }
    @RequestMapping(value = "/admin/addEventPhoto", method = RequestMethod.GET)
    public Event addEventPhoto(@RequestBody Event toUpdate, Photo toAdd){

        log.debug("Received new event photo add request");
        Iterable<Photo> currentPhotos = toUpdate.getPhotos();
        ArrayList<Photo> appendedPhotos = new ArrayList<Photo>();
        for(Photo p : currentPhotos){
            appendedPhotos.add(p);
        }
        appendedPhotos.add(toAdd);
        toUpdate.setPhotos(appendedPhotos);
        log.debug("Returning updated event");
        return toUpdate;
    }


    @RequestMapping(value = "/admin/galleryGroups", method = RequestMethod.GET)
    public Iterable<GallerySectionGroup> getGalleryGroups(){

        log.debug("Received new gallery groups request");
        Iterable<GallerySectionGroup> sectionGroups = gallerySectionGroupRepository.findAll();
        log.debug("Returning gallery groups");
        return sectionGroups;
    }

    @RequestMapping(value = "/admin/gallerySections", method = RequestMethod.GET)
    public Iterable<GallerySection> getGallerySection(){

        log.debug("Received new gallery sections request");
        Iterable<GallerySection> sectionGroups = gallerySectionRepository.findAll();
        log.debug("Returning gallery sections");
        return sectionGroups;
    }

    @RequestMapping(value = "/admin/deleteGroup", method = RequestMethod.GET)
    public void deleteGroup(@RequestParam(value = "group") int id){

        log.debug("received delete request for group with id "+id);
        gallerySectionGroupRepository.delete(id);
        log.debug("deleted post with id "+ id);
    }

    @RequestMapping(value = "/admin/newGroup", method = RequestMethod.GET)
    public GallerySectionGroup newGroup(){

        log.debug("Received new group to create");
        GallerySectionGroup newGroup = new GallerySectionGroup();
        gallerySectionGroupRepository.save(newGroup);
        log.debug("Returning saved group with id "+newGroup.getId());
        return newGroup;
    }

    @RequestMapping(value = "/admin/saveGroup", method = RequestMethod.POST)
    public GallerySectionGroup saveGroup(@RequestBody GallerySectionGroup gallerySectionGroup){

        log.debug("Received group to save");
        gallerySectionGroup =gallerySectionGroupRepository.save(gallerySectionGroup);
        log.debug("Returning saved group with id "+gallerySectionGroup.getId());
        return gallerySectionGroup;
    }

    @RequestMapping(value = "/admin/deleteSection", method = RequestMethod.GET)
    public void deleteSection(@RequestParam(value = "section") int id){

        log.debug("received delete request for group with id "+id);
        gallerySectionRepository.delete(id);
        log.debug("deleted post with id "+ id);
    }




    //TODO: Implment rest of crud API when more of frontend is finished


}
