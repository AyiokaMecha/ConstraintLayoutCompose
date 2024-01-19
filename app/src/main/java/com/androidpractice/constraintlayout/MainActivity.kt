package com.androidpractice.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidpractice.constraintlayout.ui.components.MyButton
import com.androidpractice.constraintlayout.ui.theme.ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    ConstraintLayout(Modifier.size(width = 200.dp, height = 200.dp)) {
        val (b1, b2, b3) = createRefs()
        MyButton(text = "Button1", Modifier.constrainAs(b1){
            top.linkTo(parent.top, margin = 60.dp)
//            start.linkTo(parent.start)
//            end.linkTo(parent.end) declare concisely as shown below
            linkTo(parent.start, parent.end, bias = 0.75f)
        })
        MyButton(text = "Button2", Modifier.constrainAs(b2) {
            centerHorizontallyTo(parent)
            top.linkTo(b1.bottom)
            bottom.linkTo(parent.bottom)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutTheme {
       MainScreen()
    }
}