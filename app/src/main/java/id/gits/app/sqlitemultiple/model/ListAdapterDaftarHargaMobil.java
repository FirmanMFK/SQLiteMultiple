package id.gits.app.sqlitemultiple.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import id.gits.app.sqlitemultiple.R;

/**
 * Created by Firman on 6/13/2017.
 */

public class ListAdapterDaftarHargaMobil extends BaseAdapter{


    private List<DaftarHargaMobil> list, filterd;
    Activity activity;
    private static LayoutInflater inflater=null;

    public ListAdapterDaftarHargaMobil(Activity a, List<DaftarHargaMobil> list){
        this.activity = a;
        this.list = list;
        this.filterd = this.list;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return filterd.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return filterd.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item_daftarharga, null);
        }
        DaftarHargaMobil pty = filterd.get(position);
        TextView no = (TextView) convertView.findViewById(R.id.noDaftarHargaMobil);
        TextView nama = (TextView) convertView.findViewById(R.id.stringDaftarHargaMobil);
        TextView jawab = (TextView) convertView.findViewById(R.id.jawabanDaftarHargaMobil);

        no.setText(pty.getId().toString());
        nama.setText(pty.getDaftarhargamobil());
        jawab.setText(pty.getHargamobil());

        return convertView;
    }
}

