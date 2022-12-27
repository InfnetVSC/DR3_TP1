package com.example.App_TP1_Vinicius.DAO

import androidx.room.*
import com.example.App_TP1_Vinicius.Model.Paciente
import com.example.App_TP1_Vinicius.Model.PacienteEConsulta

@Dao
interface PacienteDAO {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun armazenar (paciente: Paciente)

    @Update
    fun atualizar (paciente: Paciente)

    @Delete
    fun apagar (paciente: Paciente)

    @Query ("SELECT * FROM Paciente")
    fun all (): Array<Paciente>

    @Transaction
    @Query("SELECT * FROM Paciente")
    fun getPacienteEConsulta(): List<PacienteEConsulta>

//    @Transaction
//    @Query("SELECT * FROM Paciente WHERE id = :indicador")
//    fun show (indicador: Int): List<Paciente>
}