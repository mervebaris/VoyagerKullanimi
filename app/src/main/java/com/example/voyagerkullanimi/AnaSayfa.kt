package com.example.examplesayfagecis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class AnaSayfa: Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current

        // TextField'den alınan metni tutmak için durum
        val inputText = rememberSaveable { mutableStateOf("") }

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Kullanıcı girişi için TextField
            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                label = { Text("Metin girin") }
            )
            Button(onClick = {
                // Girilen metni SayfaA'ya ileterek SayfaA'ya geçiş yap
                navigator?.push(SayfaA(inputText.value))
            }) {
                Text(text = "Detay Sayfa")
            }
        }
    }
}

@Preview
@Composable
fun AnaSayfaPrew(){
    AnaSayfa().Content()
}
