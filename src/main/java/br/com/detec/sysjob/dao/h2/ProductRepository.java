package br.com.detec.sysjob.dao.h2;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.detec.sysjob.entity.ProductEntity;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long> {

	Page<ProductEntity> findByName(@Param("name") String name, Pageable pageable);

	ProductEntity getOne(Long id);

	List<ProductEntity> findAll();

}
