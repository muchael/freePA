package com.muchael.freePA.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muchael.freePA.domain.entity.Function;
import com.muchael.freePA.domain.repository.IFunctionRepository;

@Service
public class FunctionService {

	@Autowired
	private IFunctionRepository functionRepository;

	/**
	 * Inserts a function
	 * 
	 * @param function
	 * @return
	 */
	Function insertFunction(Function function) {

		return functionRepository.save(function);
	}

	/**
	 * Updates a function
	 * 
	 * @param function
	 * @return
	 */
	Function updateFunction(Function function) {

		return functionRepository.save(function);
	}

	/**
	 * Removes a function point
	 * @param id
	 */
	void deleteFunction(Long id) {
		this.functionRepository.deleteById(id);
	}
	
	/**
	 * Lists the functions of a document
	 * @param documentId
	 * @return
	 */
	List<Function> listFunctionsByDocument( Long documentId ) {
		return null;
	}

	public Optional<Function> findFunctionById(long id) {
		return this.functionRepository.findById( id );
	}
}
