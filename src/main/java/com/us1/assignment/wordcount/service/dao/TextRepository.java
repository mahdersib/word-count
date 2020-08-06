package com.us1.assignment.wordcount.service.dao;

import com.us1.assignment.wordcount.model.Text;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends CrudRepository<Text, Long> {
}
