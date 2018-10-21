package com.muchael.freePA.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.muchael.freePA.domain.entity.Function;

public interface IFunctionRepository extends CrudRepository<Function, Long>{

	Page<Function> findByDocument_id(long documentId, Pageable pageable);

}
