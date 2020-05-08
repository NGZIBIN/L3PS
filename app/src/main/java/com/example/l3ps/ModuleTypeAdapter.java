package com.example.l3ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleTypeAdapter extends ArrayAdapter<Add> {

    private ArrayList<Add> moduleTypes;
    private Context context;
    private TextView tvWeek;
    private TextView tvGrade;

    public ModuleTypeAdapter(Context context, int resource, ArrayList<Add> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        moduleTypes = objects;
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
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvWeek = (TextView) rowView.findViewById(R.id.tvWeek);
        tvGrade = (TextView) rowView.findViewById(R.id.tvGrade);
        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Add currentType = moduleTypes.get(position);
        // Set the TextView to show the food


        tvWeek.setText("Week " + currentType.getWeek());
        tvGrade.setText(currentType.getDgGrade());

        return rowView;
    }
}
