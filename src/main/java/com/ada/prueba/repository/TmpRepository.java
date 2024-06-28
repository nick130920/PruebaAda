package com.ada.prueba.repository;

import com.ada.prueba.entity.TmpLlenarCampos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmpRepository extends JpaRepository<TmpLlenarCampos, Long> {

    @Query("SELECT DISTINCT t.codigoCompany FROM TmpLlenarCampos t")
    List<String> findDistinctCodigoCompany();
}
