package com.example.beatfranticallyidle.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beatfranticallyidle.R
import com.example.beatfranticallyidle.ui.theme.BeatFranticallyIdleTheme

@Composable
fun AppIdle(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
        ) {
            MonsterBoard(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.error)
            )
            CardBoard(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.onSurface)
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(
                text = stringResource(R.string.app_name),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun BottomAppBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun MonsterBoard(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.padding(32.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.monster),
            contentDescription = null
        )
    }
}

@Composable
fun CardBoard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = modifier.weight(1f)
            ) {
                UnitCard(modifier = modifier)
                UnitCard(modifier = modifier)
                UnitCard(modifier = modifier)
            }
            Row(
                modifier = modifier.weight(1f)
            ) {
                UnitCard(modifier = modifier)
                UnitCard(modifier = modifier)
                UnitCard(modifier = modifier)
            }
        }
    }
}

@Composable
fun UnitCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.padding(4.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.guardian),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppIdle() {
    BeatFranticallyIdleTheme {
        Scaffold(
            topBar = {
                TopAppBar(modifier = Modifier.height(70.dp))
            },
            bottomBar = {
                BottomAppBar(modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth())
            },
        ) { paddingValues ->
            AppIdle(modifier = Modifier.padding(paddingValues))
        }
    }
}
