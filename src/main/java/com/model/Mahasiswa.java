package com.model;

import javax.persistence.*;

@Entity
@Table(name = "Mahasiswa")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nameMahasiswa")
    private String nameMahasiswa;

    @Column(name = "nim")
    private long nim;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameMahasiswa() {
        return nameMahasiswa;
    }

    public void setNameMahasiswa(String nameMahasiswa) {
        this.nameMahasiswa = nameMahasiswa;
    }

    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public Mahasiswa(){

    }

    public Mahasiswa(String nameProduct, int nim){
        super();
        this.nameMahasiswa = nameProduct;
        this.nim = nim;
    }
}
