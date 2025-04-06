package org.number.repository;

import org.number.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {


}
