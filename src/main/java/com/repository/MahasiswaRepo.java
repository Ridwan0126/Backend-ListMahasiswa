package com.repository;

import com.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Long> {
}
