package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    CheckBox cBox;
    TextView txt;
    View v;

    public ViewHolder(View itemView){
        super(itemView);
        cBox = itemView.findViewById(R.id.checkBox);
        txt = itemView.findViewById(R.id.textView);
        v = itemView;
    }
}
