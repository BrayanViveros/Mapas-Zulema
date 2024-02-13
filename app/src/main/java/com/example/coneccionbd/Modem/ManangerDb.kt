/*package com.example.coneccionbd.Modem

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase


data class ManangerDb(val context: Context) {

    lateinit var bd:SQLiteDatabase

    val  bdHelper = BdHelper(context)//llamado a mi conexion

    //metodo para abrir bd en modo escritura
    fun openBdWr(){

        bd= bdHelper.writableDatabase
    }
    //abre base de datos modo lectura
    fun openBdRd(){

        bd=bdHelper.readableDatabase

    }

//    fun  inserData(code:Int,ciudad:String,codep:Int):Long{
//
//        openBdWr() // abrir bd en modo escritura
//
//        //creo contenedor de valores para insertar data
//        val  contenedor =ContentValues()
//        contenedor.put("cod",code)
//        contenedor.put("nombre",ciudad)
//        contenedor.put("coddep",codep
//        )
//        //llamo metodo insert
//
//        val resul = bd.insert("ciudad",null,contenedor)
//        return  resul
//
//
//
//    }

//        fun  inserData():Long{
//
//            openBdWr() // abrir bd en modo escritura
//
//            //creo contenedor de valores para insertar data
//            val  contenedor =ContentValues()
//            contenedor.put("cod",1)
//            contenedor.put("nombre","cali")
//            contenedor.put("coddep",25)
//            //llamo metodo insert
//
//            val resul = bd.insert("ciudad",null,contenedor)
//            return  resul
//
//
//
//        }

    fun inserData(codd:Int, nombred:String, apellidod: Int, telefonod:Int, direcciond:String, ciudadd:String): Long {
        openBdWr() // abrir bd en modo escritura

        //creo contenedor de valores para insertar data
        val contenedor = ContentValues()
        contenedor.put("codigo", codd)
        contenedor.put("nombre", nombred)
        contenedor.put("apellido", apellidod)
        contenedor.put("telefono", telefonod)
        contenedor.put("direccion", direcciond)
        contenedor.put("ciudad", ciudadd)

        //llamo metodo insert
        val resul = bd.insert("datos", null, contenedor)
        return resul
    }


}*/

package com.example.coneccionbd.Modem

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

data class ManangerDb(val context: Context) {

    lateinit var bd: SQLiteDatabase

    val bdHelper = BdHelper(context)

    fun openBdWr() {
        bd = bdHelper.writableDatabase
    }

    fun inserData(): Long {

      openBdWr() // abrir bd en modo escritura

        //creo contenedor de valores para insertar data
    val contenedor = ContentValues()
   // contenedor.put("titulo", titulo)
    //contenedor.put("latitud", latitud)
    //contenedor.put("longitud", longitud)

    contenedor.put("cod",1)
    contenedor.put("nombre", "cali")
    contenedor.put("coddep", 25)


        //llamo metodo insert

     val  resul = bd.insert ("ciudad", null, contenedor)

      return resul

    }

    fun  getData (): ArrayList <Ciudad> {

        openBdWr()

        val ciudadList = ArrayList <Ciudad>()

        val cursor = bd.rawQuery(Constantes.consulta,null)

        if (cursor.moveToFirst() ){
            //se verifica si hay datos en la primera posicion del cursor
            do {
                val idCiudad = cursor.getColumnIndex("cod") //se almacena en las variables lo que tiene el cursor en la columna 0
                val  nombreCiudad = cursor.getColumnIndex("nombre")
                val coddepCiudad = cursor.getColumnIndex("coddep")

                val ciudad = Ciudad(idCiudad,nombreCiudad.toString(),coddepCiudad)//paso los valores optenidos del cursor a mi objeto ciudad

                ciudadList.add(ciudad)  //agrego mi objeto ciudad al arraylist

            } while (cursor.moveToNext()) // el ciclo se hace hasta que el cursor se mueva hasta la siguiente posicion



            }
        return  ciudadList
    }
}