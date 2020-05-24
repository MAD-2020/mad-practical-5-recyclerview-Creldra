package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<myObject> list_checkbox;
    Context context;

    public Adaptor(ArrayList<myObject> obj, Context con){
        this.list_checkbox = obj;
        this.context = con;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder, final int position){
        myObject list_items = list_checkbox.get(position);
        holder.txt.setText(list_items.getMyText());
        final String itemText = holder.txt.getText().toString();

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View alert = LayoutInflater.from(v.getContext()).inflate(R.layout.alertdialog, null, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(alert);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list_checkbox.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setTitle("Delete");
                TextView displayMessage = alert.findViewById(R.id.alertText);
                displayMessage.setText("\nAre you sure you want to delete\n" + itemText + "?");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    public int  getItemCount(){
        return list_checkbox.size();
    }
}
