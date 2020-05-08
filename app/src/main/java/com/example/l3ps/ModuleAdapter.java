package com.example.l3ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {
    private ArrayList<Module> modules;
    private Context context;
    private TextView tvCode;
    private TextView tvName;
    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        modules = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.moduletype, parent, false);

        // Get the TextView object
        tvCode = (TextView) rowView.findViewById(R.id.tvModule);
        tvName = (TextView) rowView.findViewById(R.id.tvTitle);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Module currentType = modules.get(position);
        // Set the TextView to show the food

        tvCode.setText(currentType.getModuleCode());
        tvName.setText(currentType.getModuleName());


        return rowView;
    }
}
