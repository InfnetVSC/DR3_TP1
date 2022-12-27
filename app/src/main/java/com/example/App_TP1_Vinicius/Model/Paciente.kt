package com.example.App_TP1_Vinicius.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Paciente (
    var nome: String,
    var sobrenome: String,
    var cpf: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
) : Serializable