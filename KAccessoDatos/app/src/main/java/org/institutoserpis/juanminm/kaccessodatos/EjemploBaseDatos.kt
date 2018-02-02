package org.institutoserpis.juanminm.kaccessodatos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ejemplo_base_datos.*

class EjemploBaseDatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_base_datos)

        val cliBDh = ClientesSQLiteHelper(this, "DBClientes", null, 1)
        val db = cliBDh.writableDatabase

        if (db != null) {
            for (cont in 1..3) {
                val nombre = "Cliente" + cont
                val telefono = cont.toString() + "XXXXXXX"

                db.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) "
                        + "VALUES ('" + cont + "', '" + nombre + "', '" + telefono + "')")
            }

            val campos = arrayOf("nombre", "telefono")
            val args4 = arrayOf("cli1")
            val c = db.query("Clientes", campos, null, null, null, null, null)

            val clientes = ArrayList<Cliente>()

            if (c.moveToFirst())
                do {
                    clientes.add(Cliente(c.getString(0), c.getString(1)))
                } while (c.moveToNext())

            c.close()

            activity_ejemplo_base_datos_sp_clientes.adapter = ClienteAdapter(
                    this, clientes.toTypedArray()
            )

            activity_ejemplo_base_datos_sp_clientes.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long) {
                    Toast.makeText(
                            this@EjemploBaseDatos,
                            "Item clicked => " + clientes.get(position),
                            Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

            db.close()
        }

    }
}
