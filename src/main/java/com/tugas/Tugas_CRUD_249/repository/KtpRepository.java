package com.tugas.Tugas_CRUD_249.repository;

import com.tugas.Tugas_CRUD_249.model.KtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KtpRepository extends JpaRepository<KtpEntity, Integer> {
    // Tambahan method untuk validasi nomor KTP unik
    Optional<KtpEntity> findByNomorKtp(String nomorKtp);
}