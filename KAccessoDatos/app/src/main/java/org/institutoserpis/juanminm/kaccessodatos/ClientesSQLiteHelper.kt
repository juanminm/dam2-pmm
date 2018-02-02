package org.institutoserpis.juanminm.kaccessodatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by juamar on 16/01/18.
 */

class ClientesSQLiteHelper(
        context: Context?,
        name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    private val cadSQL: String = "CREATE TABLE Clientes (codigo INTEGER, nombre TEXt, telefono TEXT)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(cadSQL);
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Clientes")
        db.execSQL(cadSQL);
    }

}