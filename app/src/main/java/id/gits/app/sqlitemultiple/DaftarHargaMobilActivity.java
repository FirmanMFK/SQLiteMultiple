package id.gits.app.sqlitemultiple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.gits.app.sqlitemultiple.helper.DatabaseHelper;
import id.gits.app.sqlitemultiple.model.DaftarHargaMobil;
import id.gits.app.sqlitemultiple.model.ListAdapterDaftarHargaMobil;

/**
 * Created by Firman on 6/13/2017.
 */


public class DaftarHargaMobilActivity extends AppCompatActivity{

    DatabaseHelper db;
    ListAdapterDaftarHargaMobil adp;
    List<DaftarHargaMobil> list;
    ListView listView;
    AutoCompleteTextView autoSpesifikasiMobil, autoHargaMobil;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_harga_mobil);

        listView = (ListView) findViewById(R.id.listDaftarHargaMobil);
        autoSpesifikasiMobil = (AutoCompleteTextView) findViewById(R.id.autoSpesifikasiMobil);
        autoHargaMobil = (AutoCompleteTextView) findViewById(R.id.autoHargaMobil);
        add = (Button) findViewById(R.id.addDaftarHargaMobil);


        db = new DatabaseHelper(getApplicationContext());

        Integer[] id_SpesifikasiMobil = db.getAllIdSpesifikasiMobil();
        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>(this, android.R.layout.simple_dropdown_item_1line, id_SpesifikasiMobil);
        autoSpesifikasiMobil.setAdapter(adapter1);

        Integer[] id_HargaMobil = db.getAllIdHargaMobil();
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_dropdown_item_1line, id_HargaMobil);
        autoHargaMobil.setAdapter(adapter2);

        tampilkanData();

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                simpanData();
            }
        });
    }



    private void tampilkanData() {
        // TODO Auto-generated method stub

        DaftarHargaMobil per = null;
        list = new ArrayList<DaftarHargaMobil>();
        List<DaftarHargaMobil> all = db.getAllDaftarHargaMobil();
        for (DaftarHargaMobil daftarhargamobil : all) {
            Log.d("Tag Name", daftarhargamobil.getHargamobil());

            per = new DaftarHargaMobil();
            per.setId(daftarhargamobil.getId());
            per.setDaftarhargamobil(daftarhargamobil.getDaftarhargamobil());
            per.setHargamobil(daftarhargamobil.getHargamobil());
            list.add(per);
        }
        adp = new ListAdapterDaftarHargaMobil(this, list);
        listView.setAdapter(adp);
    }

    private void simpanData() {
        // TODO Auto-generated method stub
        try{
            db.insertDaftarHargaMobil(new DaftarHargaMobil(Integer.parseInt(autoSpesifikasiMobil.getText().toString()), Integer.parseInt(autoHargaMobil.getText().toString())));
            Toast.makeText(getBaseContext(), "Data berhasil disimpan",
                    Toast.LENGTH_SHORT).show();
            tampilkanData();
            kosongkanField();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Gagal disimpan", Toast.LENGTH_LONG).show();
        }
    }

    private void kosongkanField() {
        // TODO Auto-generated method stub
        autoSpesifikasiMobil.setText("");
        autoHargaMobil.setText("");
    }

}