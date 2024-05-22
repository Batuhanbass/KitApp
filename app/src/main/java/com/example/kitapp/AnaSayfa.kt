package com.example.kitapp

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DiscouragedApi")
@Composable
fun AnaSayfa(navController: NavController) {
    val kata = remember {
        mutableStateListOf<HomePageData>()
    }
    val kata2= remember {
        mutableStateListOf<HomePageData>()
    }

    LaunchedEffect(Unit) {
        val h1 = HomePageData(1, "a1", "Sanat")
        val h2 = HomePageData(2, "a1", "XXX")
        val h3 = HomePageData(3, "a1", "XXX")
        val h4 = HomePageData(4, "a1", "XXX")
        val h5 = HomePageData(5, "a1", "XXXX")
        val h6 = HomePageData(6, "a1", "XXX")
        val h7 = HomePageData(7, "a1", "XXXX")
        val h8 = HomePageData(8, "a1", "xxx")
        val h9 = HomePageData(9, "a1", "xxx")
        val h10 = HomePageData(10, "a1", "xxx")

        kata.add(h1)
        kata.add(h2)
        kata.add(h3)
        kata.add(h4)
        kata.add(h5)
        kata2.add(h6)
        kata2.add(h7)
        kata2.add(h8)
        kata2.add(h9)
        kata2.add(h10)

    }

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.background(Color(112, 4, 96))) {
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
        ) {
            items(
                count = kata.count() ,
                itemContent = {
                    val ax = kata[it]
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(bottom = 20.dp)
                    ) {
                        Card(modifier = Modifier.size(126.dp, 90.dp), onClick = {navController.navigate("kataicerik")}) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(10.dp)
                            ) {

                                val activity = (LocalContext.current as Activity)
                                Text(text = ax.resim_isim)
                                Spacer(modifier = Modifier.padding(bottom = 5.dp))
                                Image(
                                    painter = painterResource(
                                        id = activity.resources.getIdentifier(
                                            ax.resim_ad,
                                            "drawable",
                                            activity.packageName
                                        )
                                    ), contentDescription = null,
                                    modifier = Modifier.size(100.dp, 75.dp)
                                )
                            }
                        }

                    }


                }
            )
        }
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
        ) {
            items(
                count = kata2.count() ,
                itemContent = {
                    val ax = kata2[it]
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(bottom = 20.dp)
                    ) {
                        Card(modifier = Modifier.size(126.dp, 90.dp), onClick = {navController.navigate("kataicerik")}) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(10.dp)
                            ) {

                                val activity = (LocalContext.current as Activity)
                                Text(text = ax.resim_isim)
                                Spacer(modifier = Modifier.padding(bottom = 5.dp))
                                Image(
                                    bitmap = ImageBitmap.imageResource(
                                        id = activity.resources.getIdentifier(
                                            ax.resim_ad,
                                            "drawable",
                                            activity.packageName
                                        )
                                    ), contentDescription = null,
                                    modifier = Modifier.size(100.dp, 75.dp)
                                )
                            }
                        }

                    }


                }
            )
        }
    }
}