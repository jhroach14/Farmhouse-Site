package com.webu.urban.entities.repositories;

import com.webu.urban.entities.Interior;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorRepository extends CrudRepository<Interior,Integer> {
}
