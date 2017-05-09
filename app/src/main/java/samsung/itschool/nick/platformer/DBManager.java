package samsung.itschool.nick.platformer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by kolya on 05.05.2017.
 */

public class DBManager {
    private Context context;
    private String DB_NAME = "game.db";

    private SQLiteDatabase db;

    protected static DBManager dbManager;

    public static DBManager getInstance(Context context) {
        if (dbManager == null) {
            dbManager = new DBManager(context);
        }
        return dbManager;
    }

    private DBManager(Context context) {
        this.context = context;
        db = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        createTablesIfNeedBe();
    }

    void addResult(int level, int ruby, int mob) {
        db.execSQL("INSERT INTO RESULTS VALUES (" + level + ", " + ruby
                + ", " + mob + ");");
    }

    ArrayList<Result> getAllResults() {

        ArrayList<Result> data = new ArrayList<Result>();
        Cursor cursor = db.rawQuery("SELECT * FROM RESULTS;", null);
        boolean hasMoreData = cursor.moveToFirst();

        while (hasMoreData) {
            int level = Integer.parseInt(cursor.getString(cursor
                    .getColumnIndex("LEVEL")));
            int ruby = Integer.parseInt(cursor.getString(cursor
                    .getColumnIndex("RUBY")));
            int mob = Integer.parseInt(cursor.getString(cursor
                    .getColumnIndex("MOB")));
            data.add(new Result(level, ruby, mob));

            hasMoreData = cursor.moveToNext();
        }

        return data;
    }

    int getNgames(){
        Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM RESULTS;",null);
        cursor.moveToFirst();
        int res = cursor.getInt(0);

        return res;
    }

    private void createTablesIfNeedBe() {
        db.execSQL("CREATE TABLE IF NOT EXISTS RESULTS (LEVEL INTEGER, RUBY INTEGER, MOB INTEGER);");
    }

    private boolean dbExist() {
        File dbFile = context.getDatabasePath(DB_NAME);
        return dbFile.exists();
    }
}
