package id.gits.app.sqlitemultiple.model;

/**
 * Created by Firman on 6/13/2017.
 */

public class DaftarHargaMobil {

    Integer id, daftarhargamobilId, hargamobilId;
    String daftarhargamobil, hargamobil;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDaftarhargamobilId() {
        return daftarhargamobilId;
    }

    public void setDaftarhargamobilId(Integer daftarhargamobilId) {
        this.daftarhargamobilId = daftarhargamobilId;
    }

    public Integer getHargamobilId() {
        return hargamobilId;
    }

    public void setHargamobilId(Integer hargamobilId) {
        this.hargamobilId = hargamobilId;
    }

    public String getDaftarhargamobil() {
        return daftarhargamobil;
    }

    public void setDaftarhargamobil(String daftarhargamobil) {
        this.daftarhargamobil = daftarhargamobil;
    }

    public String getHargamobil() {
        return hargamobil;
    }

    public void setHargamobil(String hargamobil) {
        this.hargamobil = hargamobil;
    }

    public DaftarHargaMobil() {

    }

    public DaftarHargaMobil(int daftarhargamobilId, int hargamobilId) {
        this.daftarhargamobilId = daftarhargamobilId;
        this.hargamobilId = hargamobilId;
    }

    public DaftarHargaMobil(int id, String daftarhargamobil, String hargamobil) {
        this.id = id;
        this.daftarhargamobil = daftarhargamobil;
        this.hargamobil = hargamobil;
    }
}
