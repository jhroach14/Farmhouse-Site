package com.webu.urban.entities.repositories;

import com.webu.urban.entities.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends CrudRepository<Service,Integer> {
}
