package com.webu.urban.controllers;


import com.webu.urban.entities.*;
import com.webu.urban.entities.repositories.*;
import com.webu.urban.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

//This class handles all page/page fragment url requests
@Controller
public class PageController {

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
    private HomePhotoRepository homePhotoRepository;
    @Autowired
    private RegistryPageRepository registryPageRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private InspireRepository inspireRepository;

    @RequestMapping(value ={"/","/home"})//root handled by this controller
    public String index(Model model, @RequestParam(value = "flag", required = false) String flag){ //model is spring data object accessible from thymeleaf
                                                                                                // flag used to indicate angularJS made request
        Iterable<HomePhoto> photoLinks = homePhotoRepository.findAll();
        ArrayList<Photo> photos = new ArrayList<Photo>();
        for( HomePhoto hp : photoLinks){
            photos.add(hp.getPhoto());
        }

        HomePage homePage = new HomePage( "Home", photos);//add data to model

        model.addAttribute("page", homePage); //allows home page fields to be accessed from templates
        log.debug("Serving home page...");

        if(flag != null && flag.equals("js")){ //If hit from external link serve home + template. If internal serve just template
            return "home";                     //spring controllers return string referring to template to load
        }else{
            return "index";

        }

    }
    @RequestMapping("/about")
    public String about(Model model, @RequestParam(value = "flag", required = false) String flag) {
        AboutPage aboutPage;
        AboutInfo aboutInfo = aboutPageRepository.findOne(1);
        if(aboutInfo != null){
            aboutPage = new AboutPage("About", aboutInfo.getStore_season(), aboutInfo.getStore_days(), aboutInfo.getStore_hours(),aboutInfo.getCompany_bio(),aboutInfo.getPhone_number(),aboutInfo.getAddress(),aboutInfo.getEmail(),aboutInfo.getPrimary_photo(),aboutInfo.getSecondary_photo());
        }
        else{
            aboutPage = new AboutPage();

        }

        model.addAttribute("page", aboutPage);
        log.debug("Serving about page...");

        if(flag != null && flag.equals("js")){
            return "about";
        }else{
            return "index";

        }
    }

    @RequestMapping("/gallery")
    public String gallery(Model model, @RequestParam(value = "flag", required = false) String flag) {

        Iterable<GallerySection> gallerySections = sectionRepository.findAll();
        GalleryPage galleryPage = new GalleryPage("Gallery", gallerySections);

        model.addAttribute("page", galleryPage);
        log.debug("Serving gallery page...");

        if(flag != null && flag.equals("js")){
            return "gallery";
        }else{
            return "index";

        }
    }

    @RequestMapping("/registry")
    public String registry(Model model, @RequestParam(value = "flag", required = false) String flag) {

        RegistryPage registryPage;
        RegistryInfo registryInfo = registryPageRepository.findOne(1);
        if(registryInfo != null){
            registryPage = new RegistryPage("Registry",registryInfo.getIntro_text(),registryInfo.getMain_photo());
            log.debug("generating registry page");
        }
        else{
            registryPage = new RegistryPage();
            log.debug("No registry page found");

        }
        model.addAttribute("page", registryPage);
        log.debug("Serving registry page...");

        if(flag != null && flag.equals("js")){
            return "registry";
        }else{
            return "index";

        }
    }

    @RequestMapping("/inspire")
    public String inspire(Model model, @RequestParam(value = "flag", required = false) String flag) {

        Iterable<BlogPost> blogPosts = blogPostRepository.findAll();
        InspireInfo inspireInfo = inspireRepository.findOne(1);
        InspirePage inspirePage = new InspirePage("Inspire", blogPosts,inspireInfo.getSide_title(),inspireInfo.getSide_text());

        model.addAttribute("page", inspirePage);
        log.debug("Serving inspire page...");

        if(flag != null && flag.equals("js")){
            return "inspire";
        }else{
            return "index";
        }
    }

    @RequestMapping("/interiors")
    public String interiors(Model model, @RequestParam(value = "flag", required = false) String flag) {

        Iterable<Interior> interiors = interiorRepository.findAll();
        InteriorPage interiorPage = new InteriorPage("Interiors",interiors);
        model.addAttribute("page", interiorPage);
        log.debug("Serving interior page...");

        if(flag != null && flag.equals("js")){
            return "interior";
        }else{
            return "index";
        }
    }
    /*
    //more use of spring's context objects
    protected User getUser(){
        return usersRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }*/

}
