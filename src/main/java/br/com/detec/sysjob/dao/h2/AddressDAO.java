package br.com.detec.sysjob.dao.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.detec.sysjob.entity.AddressEntity;

@Repository
public interface AddressDAO extends JpaRepository<AddressEntity, Long> {

}
