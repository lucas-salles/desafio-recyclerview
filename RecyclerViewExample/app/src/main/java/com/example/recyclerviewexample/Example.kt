package com.example.recyclerviewexample

import java.io.Serializable

class Example(var nome: String): Serializable {
    override fun toString(): String {
        return "Nome: ${nome}"
    }
}