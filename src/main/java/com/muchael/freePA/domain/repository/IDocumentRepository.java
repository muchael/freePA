package com.muchael.freePA.domain.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.muchael.freePA.domain.entity.Document;

public interface IDocumentRepository extends CrudRepository<Document, Long>{

	Page<Document> findByProject_id(long projectId, Pageable pageable);

	@Modifying
    @Transactional
	void deleteByProject_id( long projectId );
}
