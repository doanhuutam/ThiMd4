package com.baithi.baithimd4.model;

import javax.persistence.*;

@Entity
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long dientich;
    private long danso;
    private long jdp;
    private String mota;
    @OneToOne
    private QuocGia quocGia;

    public ThanhPho() {
    }

    public ThanhPho(long id, String name, long dientich, long danso, long jdp, String mota, QuocGia quocGia) {
        this.id = id;
        this.name = name;
        this.dientich = dientich;
        this.danso = danso;
        this.jdp = jdp;
        this.mota = mota;
        this.quocGia = quocGia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDientich() {
        return dientich;
    }

    public void setDientich(long dientich) {
        this.dientich = dientich;
    }

    public long getDanso() {
        return danso;
    }

    public void setDanso(long danso) {
        this.danso = danso;
    }

    public long getJdp() {
        return jdp;
    }

    public void setJdp(long jdp) {
        this.jdp = jdp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }
}
