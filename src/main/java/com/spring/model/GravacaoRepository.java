package com.spring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GravacaoRepository extends JpaRepository<Gravacao, Long> {

}
