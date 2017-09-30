package com.webu.urban.entities.repositories;

import com.webu.urban.entities.InspireInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspireRepository extends CrudRepository<InspireInfo, Integer> {
}
