package com.example.App_TP1_Vinicius.DAO

import androidx.room.*
import com.example.App_TP1_Vinicius.Model.Consulta

@Dao
interface ConsultaDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun armazenar (consulta: Consulta)
    @Update
    fun atualizar (consulta: Consulta)
    @Delete
    fun apagar (consulta: Consulta)
}