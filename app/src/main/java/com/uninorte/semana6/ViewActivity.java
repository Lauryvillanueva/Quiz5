
package com.uninorte.semana6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewActivity extends Activity {
    EditText editText1,editText2,texto;
    public String TAG = Constants.TAG;
    DataEntry dataEntry;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        texto = (EditText) findViewById(R.id.editText5);

        bundle = getIntent().getExtras();

        if (bundle!=null){

            dataEntry= (DataEntry) bundle.getSerializable("Entryview");
            editText1.setText(dataEntry.field1);
            editText2.setText(dataEntry.field2);
            texto.setText(dataEntry.texto);
        }else{
            Date curDate = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            editText2.setText(format.format(curDate));

        }


    }
    //termine hasta el video 3 - creacion de la primera entrada---------------------------
    public void onClickAceptar(View view) {
        DataEntry de;
        if (TextUtils.isEmpty(editText1.getText().toString())){
            editText1.setError("No puede estar vacio");
        }else {
            if (TextUtils.isEmpty(editText2.getText().toString())){
                editText1.setError("No puede estar vacio");
            }else {
                if (bundle!=null){
                    de = new DataEntry(dataEntry.id, editText1.getText().toString() ,editText2.getText().toString(),texto.getText().toString());

                }else{

                    de = new DataEntry(editText1.getText().toString() ,texto.getText().toString());

                }


                Intent i = getIntent();
                i.putExtra("entry", de);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        }
    }
}
