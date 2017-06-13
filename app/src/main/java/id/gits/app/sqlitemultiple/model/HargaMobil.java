package id.gits.app.sqlitemultiple.model;

/**
 * Created by Firman on 6/13/2017.
 */

public class HargaMobil {

    Integer id;
    String hargamobil;

    public HargaMobil(Integer id, String hargamobil) {
        this.id = id;
        this.hargamobil = hargamobil;
    }

    public HargaMobil(String hargamobil) {
        this.hargamobil = hargamobil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHargamobil() {
        return hargamobil;
    }

    public void setHargamobil(String hargamobil) {
        this.hargamobil = hargamobil;
    }

    public HargaMobil() {

    }


}
