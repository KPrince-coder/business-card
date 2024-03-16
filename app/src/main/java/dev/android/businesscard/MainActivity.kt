/**
 * @date Friday, March 15, 2024
 */

package dev.android.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.android.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        image = painterResource(R.drawable.android_developer_card),
                        name = stringResource(R.string.user_name),
                        title = stringResource(R.string.user_title),
                        imageDesc = "android developer card image",
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = colorResource(R.color.background_color))
                    )
                }
            }
        }
    }
}

@Composable
private fun PersonalInfo(
    title: String,
    name: String,
    image: Painter,
    imageDesc: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = imageDesc,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(120.dp)
                .height(150.dp)
        )
        Text(
            name,
            fontSize = 26.sp,
            color = colorResource(R.color.black_100),
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            title,
            color = colorResource(R.color.brown),
            fontWeight = FontWeight.W600,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun ContactDetails(modifier: Modifier = Modifier) {
    @Composable
    fun ContactDetail(
        modifier: Modifier = Modifier,
        iconDesc: String,
        iconName: ImageVector,
        contactText: String
    ) {
        Row(modifier) {
            Icon(
                iconName,
                contentDescription = iconDesc,
                tint = colorResource(R.color.brown)
            )
            Spacer(modifier = Modifier.size(28.dp))
            Text(text = contactText, color = colorResource(R.color.black_100))
        }
    }

    Column(modifier) {
        ContactDetail(
            iconDesc = "call icon",
            iconName = Icons.Filled.Call,
            contactText = "+233 550 977 064",
            modifier = Modifier.padding(8.dp)
        )
        ContactDetail(
            iconDesc = "share icon",
            iconName = Icons.Filled.Share,
            contactText = "@AnointingOne",
            modifier = Modifier.padding(8.dp)
        )
        ContactDetail(
            iconDesc = "email icon",
            iconName = Icons.Filled.Email,
            contactText = "anoint.aniointing1@gmail.com",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier,
    title: String,
    name: String,
    image: Painter,
    imageDesc: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            PersonalInfo(
                title = title,
                name = name,
                image = image,
                imageDesc = imageDesc
            )
        }
        Box(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            ContactDetails(modifier = Modifier.padding(horizontal = 12.dp, 24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            image = painterResource(R.drawable.android_developer_card),
            name = stringResource(R.string.user_name),
            title = stringResource(R.string.user_title),
            imageDesc = "android developer card image"
        )
    }
}

