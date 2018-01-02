package com.webu.urban.entities.repositories;

import com.webu.urban.entities.GallerySection;
import com.webu.urban.entities.GallerySectionGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GallerySectionGroupRepository extends CrudRepository<GallerySectionGroup,Integer> {

}
