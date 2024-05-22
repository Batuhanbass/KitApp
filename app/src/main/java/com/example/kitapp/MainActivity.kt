package com.example.kitapp
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kitapp.ui.theme.KitAppTheme
import androidx.compose.material3.Card as Card

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    SayfaGecisler()
                }
            }
        }
    }
}


@Composable
fun SayfaGecisler(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            AnaSayfa(navController=navController)
        }
        composable("kataicerik"){
            SanatKataIcerik(navController=navController)
        }
    }


}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DiscouragedApi")
@Composable
fun SanatKataIcerik(navController: NavController) {
    val SanatIcerik = remember {
        mutableStateListOf<KataIcerikData>()
    }
    LaunchedEffect(Unit) {
        val s1 = KataIcerikData(1, "Sanat 1", "xxx", "soru")
        val s2 = KataIcerikData(2, "Sanat 2", "xxx", "soru")
        val s3 = KataIcerikData(3, "Sanat 3", "xxx", "soru")
        val s4 = KataIcerikData(4, "Sanat 4", "xxx", "soru")
        val s5 = KataIcerikData(5, "Sanat  5", "xxx", "soru")
        val s6 = KataIcerikData(6, "Sanat 6", "xxx", "soru")
        val s7 = KataIcerikData(7, "Sanat 7", "xxx", "soru")
        val s8 = KataIcerikData(8, "Sanat 8", "xxx", "soru")
        SanatIcerik.add(s1)
        SanatIcerik.add(s2)
        SanatIcerik.add(s3)
        SanatIcerik.add(s4)
        SanatIcerik.add(s5)
        SanatIcerik.add(s6)
        SanatIcerik.add(s7)
        SanatIcerik.add(s8)


    }
    Column(modifier = Modifier.background(Color(112, 4, 96))){
        LazyColumn {
            items(
                count = SanatIcerik.count(),
                itemContent = {val sk=SanatIcerik[it]
                    Card(modifier = Modifier
                        .padding(all = 5.dp)
                        .fillMaxWidth()){
                        Row(modifier = Modifier.clickable {  }){
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth()){
                                val activity= (LocalContext.current as Activity)
                                Image(bitmap = ImageBitmap.imageResource(id=activity.resources.getIdentifier(sk.resim_isim,"drawable",activity.packageName)),
                                    contentDescription = "",
                                    modifier =Modifier.size(100.dp) )
                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                                        .fillMaxHeight()
                                        .clipToBounds()) {
                                        Text(text = sk.Baslık, fontSize = 20.sp)
                                        Text(text = sk.ozet, fontSize = 12.sp, color = Color.Blue)


                                    }

                                }
                            }
                        }
                    }


                }

            )

        }
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KitAppTheme {

    }
}