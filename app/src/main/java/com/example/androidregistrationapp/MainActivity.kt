package com.example.androidregistrationapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidregistrationapp.ui.theme.AndroidRegistrationAppTheme
import com.example.androidregistrationapp.ui.theme.ButtonBrown
import com.example.androidregistrationapp.ui.theme.LinkBlack
import com.example.androidregistrationapp.ui.theme.TitleOrange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRegistrationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Register()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){

        var context = LocalContext.current

        Text(
            text = "Register Here",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = TitleOrange,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 20.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.school),
            contentDescription = null)

        Spacer(modifier = Modifier.height(16.dp))

        var name by remember{ mutableStateOf(TextFieldValue(  ""))}


        OutlinedTextField(
            value = name,
            onValueChange ={name = it},
        label ={Text(text = "Enter name...")},
        )
        Spacer(modifier = Modifier.height(16.dp))

        var email by remember{ mutableStateOf(TextFieldValue(  ""))}


        OutlinedTextField(
            value = email,
            onValueChange ={email = it},
            label ={Text(text = "Enter email...")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        var idNumber by remember{ mutableStateOf(TextFieldValue(  ""))}


        OutlinedTextField(
            value = idNumber,
            onValueChange ={idNumber = it},
            label ={Text(text = "Enter Id Number...")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        var password by remember{ mutableStateOf(TextFieldValue(  ""))}


        OutlinedTextField(
            value = password,
            onValueChange ={password = it},
            label ={Text(text = "Enter password...")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                Toast.makeText(context, "You have registered as ${name.text}", Toast.LENGTH_SHORT).show() },
            colors = ButtonDefaults.buttonColors(ButtonBrown),
            shape = CutCornerShape(10.dp)
            ) {
            Text(text = "Register")

        }

        Spacer(modifier = Modifier.height(16.dp))

        ClickableText(
            text = AnnotatedString("Login instead"),
            onClick = {
               context.startActivity(
                   Intent(context, SecondActivity::class.java)
               )
            },
            style = TextStyle(
                color = LinkBlack,
                fontSize = 25.sp,
                fontFamily = FontFamily.Cursive
            )
        )


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidRegistrationAppTheme {
//        Greeting("Android")
        Register()
    }
}