package com.webu.urban.entities.repositories;

import com.webu.urban.entities.AboutInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutPageRepository extends CrudRepository<AboutInfo,Integer>{
    /*@Query("select e from about_pages e where e.id = 0")
    AboutInfo getAboutPage();*/

}
