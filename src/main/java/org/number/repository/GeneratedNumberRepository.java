package org.number.repository;

import org.number.entity.GeneratedNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneratedNumberRepository extends JpaRepository<GeneratedNumber, Long> {
}
