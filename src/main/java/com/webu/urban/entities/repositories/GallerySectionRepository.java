package com.webu.urban.entities.repositories;

import com.webu.urban.entities.GallerySection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GallerySectionRepository extends CrudRepository<GallerySection,Integer> {

}
