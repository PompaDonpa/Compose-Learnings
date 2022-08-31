package com.state.basicstatecodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(count = count, onIncrement = {count++}, onResetCount = {count = 0}, modifier = modifier)
}

@Composable
private fun StatelessCounter(count: Int, onIncrement: () -> Unit, onResetCount: () -> Unit, modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {
        Text(if (count > 0) "You've had $count glasses." else "")

        Row {
            Button(
                onClick = onIncrement,
                enabled = count < 10,
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Add one")
            }
            Spacer(modifier = modifier.padding(4.dp))
            Button(
                onClick = onResetCount,
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Clear Water Count")
            }
        }
    }
}

