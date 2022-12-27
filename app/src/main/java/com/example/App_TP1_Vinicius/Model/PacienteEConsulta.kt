package com.example.App_TP1_Vinicius.Model

import androidx.room.Embedded
import androidx.room.Relation
import java.io.Serializable

class PacienteEConsulta(
    @Embedded val paciente: Paciente,
    @Relation(
        parentColumn = "id",
        entityColumn = "paciente_id"
    ) val consulta: Consulta?
) : Serializable {
    override fun toString(): String {
        if (consulta == null) {
            return "Resultado da consulta de (não informado) do paciente ${paciente.nome} com CPF ${paciente.cpf}: (não informado)"
        } else {
            return "Resultado da consulta de " +
                    "${consulta?.tipoConsulta} do paciente " +
                    "${paciente.nome} ${paciente.sobrenome} com CPF" +
                    "${paciente.cpf}: ${consulta?.resultadoConsulta}"
        }
    }
}

