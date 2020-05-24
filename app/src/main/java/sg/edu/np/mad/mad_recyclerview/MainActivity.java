package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Week_5";
    private EditText addText;
    private Button addBox;
    ArrayList<myObject> list_data = new ArrayList<>();
    Adaptor mAdaptor;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBox = findViewById(R.id.button2);
        addText = findViewById(R.id.editText);
        context = MainActivity.this;

        myObject obj1 = new myObject("Buy milk");
        myObject obj2 = new myObject("Send postage");
        myObject obj3 = new myObject("Buy Android development book");
        list_data.add(obj1);
        list_data.add(obj2);
        list_data.add(obj3);

        //Recycler View Part
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCustom);
        mAdaptor = new Adaptor(list_data, context);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdaptor);

        //on click listener
        addBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myObject obj = new myObject(addText.getText().toString());
                list_data.add(obj);
                mAdaptor.notifyDataSetChanged();
                Log.v(TAG, "WHY NOT WORKING");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }
}
