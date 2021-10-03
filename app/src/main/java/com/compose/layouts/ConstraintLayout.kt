package com.compose.layouts

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.layouts.ui.theme.ComposeLayoutsTheme

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {

        // Create references for the composables to constrain
        val (button1, button2, text) = createRefs()

        Button(
            onClick = { /*Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button 1")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            // Centers Text horizontally in the ConstraintLayout
            centerHorizontallyTo(parent)
        })

        val barrier = createEndBarrier(button1, text)
        Button(
            onClick = { /* Do Something */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }
        ) {
            Text("Button 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContentPreview() {
    ComposeLayoutsTheme {
        ConstraintLayoutContent()
    }
}
