package com.webu.urban.entities.repositories;

import com.webu.urban.entities.RegistryEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegistryEntryRepository extends CrudRepository<RegistryEntry, Integer> {

    RegistryEntry findByCode(String code);
}
