package com.example.demo.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Option;

public interface OptionRepository extends JpaRepository<Option, Long>{

}
