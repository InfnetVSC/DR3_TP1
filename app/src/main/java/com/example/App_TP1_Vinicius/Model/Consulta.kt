package com.example.App_TP1_Vinicius.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Consulta (
    var tipoConsulta: String,
    var resultadoConsulta: String,
    var paciente_id: Int?,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
) : Serializable


