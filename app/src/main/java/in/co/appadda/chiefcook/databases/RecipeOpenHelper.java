package in.co.appadda.chiefcook.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by HP on 22-12-2015.
 */
public class RecipeOpenHelper extends SQLiteOpenHelper{
    private static String DB_PATH = "/data/data/in.co.appadda.chiefcook/databases/";
    private static final String DATABASE_NAME = "recipe.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME_1 = "carrot_pickle";

    public static final String UID = "_id";
    public static final String Ingredients = "ingredients";
    public static final String Steps = "steps";

    private static final String DROP_TABLE_1 = "DROP TABLE IF EXISTS " + TABLE_NAME_1;
    private SQLiteDatabase  myDataBase;
    private Context myContext;

    public RecipeOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }

    public void createDataBase() throws IOException{

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DATABASE_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException{

        //Open the database
        String myPath = DB_PATH + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            onCreate(db);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Cursor getAllRow(String TABLE_NAME,String COL_NAME) {

        Cursor c =     myDataBase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COL_NAME+" IS NOT NULL",null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public byte[] getImages(String i){
        Cursor c = myDataBase.rawQuery("SELECT image FROM images where name = '"+i+"'",null);
        byte[] img = null;
        if (c != null) {
            c.moveToFirst();
            do{
                img=c.getBlob(c.getColumnIndex("image"));
            }while(c.moveToNext());
        }
        return img;
    }


}
