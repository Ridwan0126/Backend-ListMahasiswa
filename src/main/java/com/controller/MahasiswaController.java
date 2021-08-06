package com.controller;

import com.model.Mahasiswa;
import com.repository.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ResApi/")
public class MahasiswaController {
    @Autowired
    private MahasiswaRepo mahasiswaRepo;

    // Get All Data Mahasiswa
    @GetMapping("/Mahasiswa")
    public List<Mahasiswa> getAllMahasiswa(){return mahasiswaRepo.findAll();}
}
