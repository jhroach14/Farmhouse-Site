package com.webu.urban.entities.repositories;

import com.webu.urban.entities.RegistryInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryPageRepository extends CrudRepository<RegistryInfo,Integer> {
    /*@Query("select e from registry_pages e where e.id = 0")
    AboutInfo getAboutPage();*/
}
