package com.example.beatfranticallyidle.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beatfranticallyidle.AppIdle
import com.example.beatfranticallyidle.data.IdleStage
import com.example.beatfranticallyidle.data.card.HeroInfo
import com.example.beatfranticallyidle.ui.theme.BeatFranticallyIdleTheme
import com.example.beatfranticallyidle.viewmodel.IdleViewModel

@Composable
fun HeroesZone(
    modifier: Modifier = Modifier,
    background: Int,
    paddingValues: PaddingValues,
    typeHero: Int,
    idleViewModel: IdleViewModel,
    idleUiState: IdleStage,
) {
    val bottomPadding = paddingValues.calculateBottomPadding()
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painterResource(background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = bottomPadding)
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                UnitCard(
                    modifier = modifier,
                    currentHero = idleUiState.allListHero[typeHero][0],
                    idleViewModel = idleViewModel,
                )
                UnitCard(
                    modifier = modifier,
                    currentHero = idleUiState.allListHero[typeHero][1],
                    idleViewModel = idleViewModel,
                )
                UnitCard(
                    modifier = modifier,
                    currentHero = idleUiState.allListHero[typeHero][2],
                    idleViewModel = idleViewModel,
                )
            }
            Row(
                modifier = Modifier.weight(1f)
            ) {
                UnitCard(
                    modifier = modifier,
                    currentHero = idleUiState.allListHero[typeHero][3],
                    idleViewModel = idleViewModel,
                )
                UnitCard(
                    modifier = modifier,
                    currentHero = idleUiState.allListHero[typeHero][4],
                    idleViewModel = idleViewModel,
                )
                UnitCard(
                    modifier = modifier,
                    currentHero = idleUiState.allListHero[typeHero][5],
                    idleViewModel = idleViewModel,
                )
            }
        }
    }
}

@Composable
fun UnitCard(
    modifier: Modifier = Modifier,
    currentHero: HeroInfo.Hero,
    idleViewModel: IdleViewModel,
) {
    when {
        currentHero.discovered -> HeroRevealed(
            idleViewModel = idleViewModel,
            monsterUiState = currentHero,
            modifier = modifier.fillMaxSize(),
        )

        else -> HeroHidden(
            currentHero = currentHero,
            modifier = modifier
        )
    }
}

@Composable
private fun HeroRevealed(
    modifier: Modifier = Modifier,
    idleViewModel: IdleViewModel,
    monsterUiState: HeroInfo.Hero,
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable(
                role = Role.Image,
                onClick = { idleViewModel.showingCardFullScreen(monsterUiState) },
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(monsterUiState.imageHero),
            contentDescription = null,
            modifier = Modifier
                .border(2.dp, Color.White)
        )
        Box(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
        ) {
            Text(
                text = monsterUiState.name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp,
                lineHeight = 8.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    )
                    .clip(RoundedCornerShape(4.dp))
                    .align(alignment = Alignment.TopCenter)
                    .background(Color(0x90000000))
                    .wrapContentSize()
            )
            Text(
                text = monsterUiState.effect,
                color = Color.White,
                fontSize = 8.sp,
                lineHeight = 8.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    )
                    .clip(RoundedCornerShape(4.dp))
                    .align(alignment = Alignment.BottomCenter)
                    .background(Color(0x90000000))
                    .wrapContentSize()
            )
        }
    }
}

@Composable
private fun HeroHidden(modifier: Modifier = Modifier, currentHero: HeroInfo.Hero) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(currentHero.imageNull),
            contentDescription = null,
            modifier = Modifier
                .border(2.dp, Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesZonePreview() {
    BeatFranticallyIdleTheme {
        AppIdle(modifier = Modifier.fillMaxSize())
    }
}