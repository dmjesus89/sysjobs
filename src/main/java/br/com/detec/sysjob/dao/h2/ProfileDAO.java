package br.com.detec.sysjob.dao.h2;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.detec.sysjob.entity.ProfileEntity;

public interface ProfileDAO extends JpaRepository<ProfileEntity, Long> {

}
