package com.example.formulario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import com.example.formulario.ui.theme.FormularioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormularioTheme {
                FormularioClasico()
            }
        }
    }
}

@Composable
fun FormularioClasico() {
    var nameState by remember { mutableStateOf("") }
    var phoneState by remember { mutableStateOf("") }
    var telcelNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSendHEEnabled by remember { mutableStateOf(false) } // Estado para el Switch
    val telcelBlue = Color(0xFF0033A0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(telcelBlue)
                .padding(8.dp)
        ) {
            Text(
                text = "CONFIGURACIÓN PARA ANDROID",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(4.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Sección "Enviar HE" movida aquí
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Enviar HE",
                fontSize = 16.sp
            )
            Switch(
                checked = isSendHEEnabled,
                onCheckedChange = { isSendHEEnabled = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = telcelBlue,
                    checkedTrackColor = telcelBlue.copy(alpha = 0.5f)
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Resto del formulario
        OutlinedTextField(
            value = phoneState,
            onValueChange = { if (it.length <= 10) phoneState = it },
            label = { Text("Número para consulta anónima") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Acción del botón OK */ },
            colors = ButtonDefaults.buttonColors(containerColor = telcelBlue),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("OK", fontSize = 18.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { /* Acción de borrar token anónimo */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Borrar Token Anónimo", fontSize = 18.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Credenciales para iniciar rápido", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = telcelNumber,
            onValueChange = { if (it.length <= 10) telcelNumber = it },
            label = { Text("Número Telcel") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = VisualTransformation.None,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Acción de guardar credenciales */ },
            colors = ButtonDefaults.buttonColors(containerColor = telcelBlue),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Credenciales", fontSize = 18.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { /* Acción de borrar credenciales */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Borrar Credenciales", fontSize = 18.sp, color = Color.White)
        }
    }
}