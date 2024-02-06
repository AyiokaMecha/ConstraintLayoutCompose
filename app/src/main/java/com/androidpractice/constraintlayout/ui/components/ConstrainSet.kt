package com.androidpractice.constraintlayout.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

val constraints = ConstraintSet {
    val greenBox = createRefFor("greenBox")
    val redBox = createRefFor("redBox")
    val yellowBox = createRefFor("yellowBox")
    val barrier = createEndBarrier(greenBox, redBox, margin = 20.dp)
    val guideline = createGuidelineFromStart(30.dp)


    constrain(greenBox) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        

        width = Dimension.value(100.dp)
        height = Dimension.value(100.dp)
    }

    constrain(redBox) {
        top.linkTo(parent.top)
        start.linkTo(greenBox.end)
        end.linkTo(parent.end)

        width = Dimension.value(100.dp)
        height = Dimension.fillToConstraints
    }

    constrain(yellowBox) {
        linkTo(redBox.bottom, parent.bottom, bias = 0.8f)
        linkTo(parent.start, parent.end, bias = 0.9f)
        width = Dimension.value(100.dp)
        height = Dimension.value(100.dp)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable

fun ConstrainScreen() {
    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(androidx.compose.ui.graphics.Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .background(androidx.compose.ui.graphics.Color.Red)
                .layoutId("redBox")
        )
        Box(
            modifier = Modifier
                .background(androidx.compose.ui.graphics.Color.Yellow)
                .layoutId("yellowBox")
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConstrainScreenPreview() {
    ConstrainScreen()
}