package com.webu.urban.entities.repositories;

import com.webu.urban.entities.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo,Integer> {


}
