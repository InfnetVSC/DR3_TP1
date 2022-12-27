@file:Suppress("DEPRECATION")

package com.example.App_TP1_Vinicius.Activities

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.App_TP1_Vinicius.Database.AppDatabaseService
import com.example.App_TP1_Vinicius.Model.Consulta
import com.example.App_TP1_Vinicius.Model.Paciente
import com.example.App_TP1_Vinicius.R
import kotlinx.android.synthetic.main.activity_cadastro_pacientes.*
import java.lang.Exception

class CadastroPacientes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_pacientes)

        btnCadastrar.setOnClickListener {
            ListaPacientesTask().execute()
        }
    }

    @SuppressLint("StaticFieldLeak")
    inner class ListaPacientesTask: AsyncTask <Unit, Unit, Unit>(){
        @Deprecated("Deprecated in Java")
        @SuppressLint("WrongThread")
        override fun doInBackground(vararg params: Unit?) {
            try {
                val nome = txtNome.text.toString()
                val sobrenome = txtSobrenome.text.toString()
                val cpf = txtCpf.text.toString()
                val tipoConsulta = txtTipoConsulta.text.toString()
                val resultadoConsulta = txtResultadoConsulta.text.toString()

                val paciente = Paciente (nome, sobrenome, cpf.toInt())

                val appDatabase = AppDatabaseService.getInstance(applicationContext)

                appDatabase.pacienteDao().armazenar(paciente)
                val todosPacientes = appDatabase.pacienteDao().all()
                val pacienteId = todosPacientes[todosPacientes.lastIndex].id
                val consulta = Consulta (tipoConsulta, resultadoConsulta, pacienteId)
                appDatabase.consultaDAO().armazenar(consulta)

                finish()

            }catch (e:Exception){
                e.message?.let { Log.e("Erro na Database", it) }
            }
        }
    }
}


