package com.example.App_TP1_Vinicius.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.App_TP1_Vinicius.Adapter.PacientesAdapter
import com.example.App_TP1_Vinicius.Database.AppDatabaseService
import com.example.App_TP1_Vinicius.Model.PacienteEConsulta
import com.example.App_TP1_Vinicius.R
import kotlinx.android.synthetic.main.activity_lista_pacientes.*


class ListaPacientes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista_pacientes)

        btnAddPacientes.setOnClickListener{
            startActivity(Intent(this, CadastroPacientes::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        ListaPacientesTask().execute()

    }

    @SuppressLint("StaticFieldLeak")
    inner class ListaPacientesTask : AsyncTask <
            Unit, Unit, List<PacienteEConsulta>
            >() {

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(
                applicationContext,
                "A lista de pacientes está sendo carregada",
                Toast.LENGTH_SHORT)
                .show()
        }

        override fun doInBackground(vararg params: Unit?): List<PacienteEConsulta>{
            var appDatabase = AppDatabaseService.getInstance(applicationContext)
            var pacientes = appDatabase.pacienteDao().getPacienteEConsulta()
//            val retornar = mutableListOf<String>()
//            pacientes.forEach {
//                retornar.add(it.toString())
//            }
            return pacientes.toList()
        }

        override fun onPostExecute(result: List<PacienteEConsulta>?) {
            Toast.makeText(
                applicationContext,
                "Lista carregada",
                Toast.LENGTH_SHORT)
                .show()
            recyclerVwPacientes.adapter = PacientesAdapter(result!!, applicationContext, this@ListaPacientes::startActivity)
            recyclerVwPacientes.layoutManager = LinearLayoutManager(applicationContext)
         //   (recyclerVwPacientes.adapter as PacientesAdapter).notifyItemChanged(result!!.lastIndex)

        }
    }
}
