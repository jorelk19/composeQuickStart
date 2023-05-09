package com.composequickstart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composequickstart.entities.User
import com.composequickstart.mocks.userList
import com.composequickstart.ui.theme.ComposeQuickStartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppStart()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppStart(){
    ComposeQuickStartTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Row(modifier = Modifier.height(200.dp).fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {
                TextViewExample("Android")
                EditTextExample()
                IconExample()
            }
            Row(modifier = Modifier.padding(0.dp, 60.dp,0.dp,0.dp) ) {
                ListExample()
            }
        }
    }
}

@Composable
fun TextViewExample(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.wrapContentWidth())
}

@Preview(showBackground = true)
@Composable
fun IconExample(){
    Image(
        painter = painterResource(id = R.drawable.ic_android_icon),
        contentDescription = stringResource(id = R.string.app_name),
        modifier = Modifier.width(30.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun EditTextExample(){
    var input by remember { mutableStateOf(TextFieldValue()) }
    TextField(
      enabled = true,
        value = input,
        onValueChange = {
            input = it
        },
        modifier = Modifier.width(200.dp)
    )
}

@Composable
fun ListExample() {
    val users = remember { userList() }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(users) {
            UserItem(it)
        }
    }
}

@Composable
fun UserItem(user : User){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row(modifier = Modifier.padding(20.dp)) {
            Column(
                modifier = Modifier.weight(1f),
                Arrangement.Center
            ) {
                Text(
                    text = "Name : " + user.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "LastName : " + user.lastName,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = "Address : " + user.address,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )

                Text(
                    text = "email : " + user.email,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
            }

        }
    }
}
