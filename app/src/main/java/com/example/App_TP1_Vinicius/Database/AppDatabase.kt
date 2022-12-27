package com.example.App_TP1_Vinicius.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.App_TP1_Vinicius.DAO.ConsultaDAO
import com.example.App_TP1_Vinicius.DAO.PacienteDAO
import com.example.App_TP1_Vinicius.Model.Consulta
import com.example.App_TP1_Vinicius.Model.Paciente

@Database
    (
    entities = arrayOf(
        Paciente::class,
        Consulta::class),
    version = 1
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun pacienteDao(): PacienteDAO
    abstract fun consultaDAO(): ConsultaDAO
}