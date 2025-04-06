package org.number.repository;

import org.number.entity.NumberingCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface CriteriaRepository extends JpaRepository<NumberingCriteria, Long> {
}
