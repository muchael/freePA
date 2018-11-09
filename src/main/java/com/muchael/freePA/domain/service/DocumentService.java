package com.muchael.freePA.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.muchael.freePA.domain.entity.Document;
import com.muchael.freePA.domain.repository.IDocumentRepository;
import com.muchael.freePA.domain.repository.IFunctionRepository;

@Service
public class DocumentService {

	@Autowired
	private IFunctionRepository functionRepository;
	
	@Autowired
	private IDocumentRepository documentRepository;

	/**
	 * Inserts a document
	 * 
	 * @param document
	 * @return
	 */
	Document insertDocument(Document document) {

		return documentRepository.save(document);
	}

	/**
	 * Updates a document
	 * 
	 * @param document
	 * @return
	 */
	Document updateDocument(Document document) {

		return documentRepository.save(document);
	}

	/**
	 * Removes a document point
	 * @param id
	 */
	void deleteDocument(Long id) {
		this.documentRepository.deleteById(id);
	}
	
	/**
	 * Lists the documents of a project
	 * @param documentId
	 * @return
	 */
	public Page<Document> listDocumentByProjectId( long projectId, PageRequest pageRequest ) {
		return this.documentRepository.findByProject_id( projectId, pageRequest );
	}

	public Document findDocumentById( long id ) {
		Document document = this.documentRepository.findById( id ).orElseThrow( () -> new IllegalArgumentException("Document not found"));
		
		document.setFunctions(this.functionRepository.findByDocument_id(document.getId(), null).getContent());
		
		return document;
	}
}
