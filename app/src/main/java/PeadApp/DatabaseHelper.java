package PeadApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    static String name = "pead.db";
    static int version = 1;

    String createTableUser = "CREATE TABLE if not exists \"details\" (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `fathers_name` TEXT,`mothers_name` TEXT,`childs_name` TEXT, " +
            "`dob` TEXT, `placeofBirth` TEXT, `gender` TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTableUser);
    }

    public void  insertUser(ContentValues contentValues){
        getWritableDatabase().insert("details","",contentValues);
    }

    public boolean isLoginValid(String username,String password){
        String sql = "select count(*) from user where username= '" + username + "' and password= '" + password + "'";
        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
        long l = statement.simpleQueryForLong();
        statement.close();

        if (l == 1){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}

