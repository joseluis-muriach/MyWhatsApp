package com.example.mywhatsaap

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    //Necesitaremos siempre un Scafold y pondremos la típicas propiedades que ponemos siempre
    Scaffold(
        Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { MyTopAppBar()}
    ){
        Box(modifier =
        Modifier.padding(top = it.calculateTopPadding())) {
            //Esta variable para controlar en que ventana estamos de las 3 que tenemos
            var state by remember { mutableStateOf(0) }
            val texts = listOf("TextChats", "TextNovedades", "TextLlamadas")

            Column {
                TabRow(containerColor = Color.Green,
                    selectedTabIndex = state) {
                    texts.forEachIndexed{index, texts ->

                        Tab(selected = state == index,
                            onClick = { state == index },
                            text = {
                                Text(
                                    text = texts,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis)
                            }) {
                        }
                        if (state == 0) {
                            TextChats()
                        }

                        if (state == 1) {
                            TextNovedades()
                        }

                        if (state == 3) {
                            TextLlamadas()
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    //Creamos la topAppBar
    TopAppBar(
        title = { Text(text = "MyWhatsApp", color = Color.White)},
        colors =
        TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Green
        ),
        //En action metenmos los iconos
        actions = {
            IconButton(onClick = {}) { //No le pongo nada por que no es clickable
                //El icono de buscar y el numbre (que no haría falta)
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search",
                    tint = Color.White)
                //EL otro icono (el de buscar)
                Icon(imageVector = Icons.Filled.Share, contentDescription = "",
                    tint = Color.White)
            }
       }
    )
}

@Composable
fun TextChats() {
    Text(text = "Chat")
}

@Composable
fun TextNovedades() {
    Text(text = "Novedades")
}

@Composable
fun TextLlamadas() {
    Text(text = "Llamadas")
}