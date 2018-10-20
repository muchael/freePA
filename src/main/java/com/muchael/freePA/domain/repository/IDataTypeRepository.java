package com.muchael.freePA.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muchael.freePA.domain.entity.DataType;

public interface IDataTypeRepository extends CrudRepository<DataType, Long>{

	List<DataType> findByFunction_id( long id );
}
