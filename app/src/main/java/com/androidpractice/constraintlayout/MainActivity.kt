package com.androidpractice.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.androidpractice.constraintlayout.ui.components.MyButton
import com.androidpractice.constraintlayout.ui.components.MyTextField
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
    var textState by remember {
        mutableStateOf("")
    }
    val onTextChange = { text: String ->
        textState = text

    }
    Column(Modifier.width(200.dp).padding(5.dp)) {
        Column(Modifier.width(IntrinsicSize.Max)) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = textState
            )
            Box(
                Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(Color.Blue))
        }
        MyTextField(text = textState, onTextChange = onTextChange)
    }


//    ConstraintLayout(Modifier.size(width = 200.dp, height = 200.dp)) {
//        val (b1, b2, b3) = createRefs()
//        MyButton(text = "Button1", Modifier.constrainAs(b1){
//            top.linkTo(parent.top, margin = 60.dp)
////            start.linkTo(parent.start)
////            end.linkTo(parent.end) declare concisely as shown below
//            linkTo(parent.start, parent.end, bias = 0.75f)
//        })
//        MyButton(text = "Button2", Modifier.constrainAs(b2) {
//            centerHorizontallyTo(parent)
//            top.linkTo(b1.bottom)
//            bottom.linkTo(parent.bottom)
//        })
//
//        val (button1, button2, button3) = createRefs()
//        val barrier = createEndBarrier(button1, button2)
//        MyButton(text = "Button1",
//            Modifier
//                .width(100.dp)
//                .constrainAs(button1) {
//                    top.linkTo(parent.top, margin = 30.dp)
//                    start.linkTo(parent.start, margin = 8.dp)
//                })
//        MyButton(text = "Button2",
//            Modifier
//                .width(100.dp)
//                .constrainAs(button2) {
//                    top.linkTo(button1.bottom, margin = 20.dp)
//                    start.linkTo(parent.start, margin = 8.dp)
//                })
//        MyButton(text = "Button3", Modifier.constrainAs(button3) {
//            linkTo(parent.top, parent.bottom,
//                topMargin = 8.dp, bottomMargin = 8.dp)
//            linkTo(barrier, parent.end, startMargin = 30.dp, endMargin =
//            8.dp)
//            width = Dimension.fillToConstraints
//            height = Dimension.fillToConstraints
//        })
//
//        //using the constraint set
//        MyButton(text = "button 4",
//            Modifier
//                .size(200.dp)
//                .layoutId("button4"))
//
//
//    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutTheme {
       MainScreen()
    }
}

//constraint sets

private fun myConstraintSet(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button1 = createRefFor("button4")
        constrain(button1){
            linkTo(parent.top, parent.bottom, topMargin = margin,
                bottomMargin = margin)
            linkTo(parent.start, parent.end, startMargin = margin,
                endMargin = margin)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
}