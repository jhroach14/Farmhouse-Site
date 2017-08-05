package com.webu.urban.entities.repositories;

import com.webu.urban.entities.HomePhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomePhotoRepository extends CrudRepository<HomePhoto,Integer> {

}
