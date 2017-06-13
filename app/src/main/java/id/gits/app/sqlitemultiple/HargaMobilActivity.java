package id.gits.app.sqlitemultiple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.gits.app.sqlitemultiple.helper.DatabaseHelper;
import id.gits.app.sqlitemultiple.model.HargaMobil;
import id.gits.app.sqlitemultiple.model.ListAdapterHargaMobil;

/**
 * Created by Firman on 6/13/2017.
 */

public class HargaMobilActivity extends AppCompatActivity {

    DatabaseHelper db;
    //TableLayout tabelData;
    EditText HargaMobilText, HargaMobilUp, noUp, noDel;
    Button add, update, del, delAll;
    ListView listView;
    ListAdapterHargaMobil adp;
    List<HargaMobil> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harga_mobil);

        HargaMobilText = (EditText) findViewById(R.id.HargaMobil);
        add = (Button) findViewById(R.id.addHargaMobilBtn);
        noUp = (EditText) findViewById(R.id.noHargaMobilUpdate);
        HargaMobilUp = (EditText) findViewById(R.id.HargaMobilUpdate);
        update = (Button) findViewById(R.id.updateHargaMobilBtn);
        noDel = (EditText) findViewById(R.id.noHargaMobilDel);
        del = (Button) findViewById(R.id.delHargaMobilBtn);
        delAll = (Button) findViewById(R.id.delAllHargaMobilBtn);
        listView = (ListView) findViewById(R.id.listHargaMobil);

        db = new DatabaseHelper(getApplicationContext());

        tampilData();

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                simpanData();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                updateData();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                deleteData();
            }
        });

        delAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                deleteAllData();
            }
        });
    }

    private void tampilData() {
        HargaMobil jwb = null;
        list = new ArrayList<HargaMobil>();
        List<HargaMobil> all = db.getAllHargaMobil();
        for (HargaMobil jawab : all) {
            Log.d("Tag Name", jawab.getHargamobil());

            jwb = new HargaMobil();
            jwb.setId(jawab.getId());
            jwb.setHargamobil(jawab.getHargamobil());
            list.add(jwb);
        }
        adp = new ListAdapterHargaMobil(this, list);
        listView.setAdapter(adp);
    }

    public void simpanData(){
        try{
            db.insertHargaMobil(new HargaMobil(HargaMobilText.getText().toString()));
            Toast.makeText(getBaseContext(), "Data berhasil disimpan",
                    Toast.LENGTH_SHORT).show();
            tampilData();
            kosongkanField();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Gagal disimpan", Toast.LENGTH_LONG).show();
        }
    }

    private void updateData(){
        try{
            db.updateHargaMobil(new HargaMobil(Integer.parseInt(noUp.getText().toString()), HargaMobilUp.getText().toString()));
            Toast.makeText(getBaseContext(), "Data nomor " +noUp.getText().toString()+" berhasil diupdate",
                    Toast.LENGTH_SHORT).show();
            tampilData();
            kosongkanField();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Update gagal", Toast.LENGTH_LONG).show();
        }
    }

    private void deleteData(){
        try{
            db.deleteHargaMobil(Long.parseLong(noDel.getText().toString()));
            Toast.makeText(getBaseContext(), "Data nomor " +noDel.getText().toString()+" berhasil dihapus",
                    Toast.LENGTH_SHORT).show();
            tampilData();
            kosongkanField();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Gagal dihapus", Toast.LENGTH_LONG).show();
        }
    }

    private void deleteAllData(){
        try{
            db.deleteAllHargaMobil();
            Toast.makeText(getBaseContext(), "Data berhasil dihapus",
                    Toast.LENGTH_SHORT).show();
            tampilData();
            kosongkanField();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "data gagal dihapus", Toast.LENGTH_LONG).show();
        }
    }
    private void kosongkanField() {
        // TODO Auto-generated method stub
        HargaMobilText.setText("");
        noDel.setText("");
        noUp.setText("");
        HargaMobilUp.setText("");
    }
}
