
package com.uninorte.semana6;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LauryV on 05/03/2017.
 */

//modelo estandar de base de datos


public class DataEntry implements Serializable {

    int id;
    String field1,field2,texto ;
    //titulo = field1;
    //fecha = field2;
    //Date field2;

    //constructor sin parametro
    public DataEntry(){}

    //constructor con los parametros

    public DataEntry(int id,String field1, String field2,String field3){
        this.id = id;
        this.field1 = field1;
        this.field2 = field2;
        this.texto=field3;
    }


    //constructor con los dos campos de datos
    public DataEntry(String field1, String field2){
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.field1 = field1;
        this.field2 = format.format(curDate);
        this.texto=field2;
    }



}
