package com.aprendiz.ragp.colorapp4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GestorDB extends SQLiteOpenHelper {
    public GestorDB(Context context) {
        super(context, "colorapp4.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SCORE (PUNTAJE INTEGER, INCORRECTAS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inputData(Score score){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("PUNTAJE",score.getPuntaje());
        values.put("INCORRECTAS",score.getIncorrectas());
        db.insert("SCORE",null,values);
        db.close();
    }

    public List<Score> scoreList(){
        List<Score> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SCORE ORDER BY PUNTAJES DESC, INCORRECTAS DESC",null);
        if (cursor.moveToFirst()){
            do {
                Score score = new Score();
                score.setPuntaje(cursor.getInt(0));
                score.setIncorrectas(cursor.getInt(1));
                results.add(score);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return  results;

    }



}
