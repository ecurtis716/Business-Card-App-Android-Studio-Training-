package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF073042)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.align(Alignment.Center)
            ) {
                MainTitle()
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
            ) {
                ContactDetails()
            }
        }
    }
}

@Composable
fun MainTitle() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_android_logo),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 48.sp,
            color = Color.White
        )
        Text(
            text = stringResource(R.string.title),
            fontSize = 32.sp,
            color = Color.White
        )
    }
}

@Composable
fun ContactDetails() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.Start
    ) {
        ContactDetailItem(Icons.Rounded.Phone, "Phone Icon", stringResource(R.string.phone_number))
        ContactDetailItem(Icons.Rounded.Share, "Share Icon", stringResource(R.string.instagram))
        ContactDetailItem(Icons.Rounded.Email, "Email Icon", stringResource(R.string.email_address))
    }
}

@Composable
fun ContactDetailItem(icon: ImageVector, contentDesc: String, text: String) {
    Row(modifier = Modifier.padding(top = 10.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = contentDesc,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.padding(end = 10.dp)
            )
        Text(
            text = text,
            color = Color(0xFF3ddc84),
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}