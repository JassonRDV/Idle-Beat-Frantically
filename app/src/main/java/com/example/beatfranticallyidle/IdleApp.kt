package com.example.beatfranticallyidle

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.beatfranticallyidle.ui.components.mainscreen.BottomBar
import com.example.beatfranticallyidle.ui.components.mainscreen.TopBar
import com.example.beatfranticallyidle.ui.screen.MainScreen
import com.example.beatfranticallyidle.ui.theme.BeatFranticallyIdleTheme
import com.example.beatfranticallyidle.viewmodel.HeroViewModel
import com.example.beatfranticallyidle.viewmodel.MonsterViewModel

sealed class HeroCardRoute(val route: String) {
    object FireHero : HeroCardRoute("FireHero")
    object LightningHero : HeroCardRoute("LightningHero")
    object PoisonHero : HeroCardRoute("PoisonHero")
}

@Composable
fun AppIdle(
    monsterViewModel: MonsterViewModel = viewModel(),
    heroViewModel: HeroViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val monsterUiState by monsterViewModel.uiState.collectAsState()
    val heroUiStage by heroViewModel.uiState.collectAsState()
    val navController = rememberNavController()
    Box() {
        Scaffold(
            topBar = {
                TopBar(
                    backgroundColor = Color(0x50000000),
                    modifier = Modifier
                )
            },
            bottomBar = {
                BottomBar(
                    backgroundColor = Color(0x50000000),
                    navController = navController,
                    heroViewModel = heroViewModel,
                    modifier = Modifier.height(92.dp)
                )
            },
            containerColor = Color.Transparent,
            contentColor = Color.Transparent,
            modifier = modifier
        ) { paddingValues ->
            MainScreen(
                monsterViewModel = monsterViewModel,
                monsterUiState = monsterUiState,
                heroViewModel = heroViewModel,
                heroUiStage = heroUiStage,
                navController = navController,
                modifier = Modifier,
                paddingValues = paddingValues
            )
        }
        AnimatedVisibility(
            visible = heroUiStage.showHeroDetails,
            enter = scaleIn(),
            exit = scaleOut(),
            modifier = Modifier.align(Alignment.Center)
        ) {
            UnitCardFullScreen(
                heroCard = heroUiStage.currentHero.image,
                modifier = Modifier.padding(40.dp),
                heroViewModel = heroViewModel,
                effectUiStage = heroUiStage.currentHero.effect,
                nameUiStage = heroUiStage.currentHero.name
            )
        }
    }
}

@Composable
fun UnitCardFullScreen(
    heroCard: Int,
    modifier: Modifier = Modifier,
    heroViewModel: HeroViewModel,
    effectUiStage: String,
    nameUiStage: String
) {
    Box(
        modifier = modifier
            .clickable(
            role = Role.Image,
            onClick = { heroViewModel.hideCardFullScreen() },
        ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(heroCard),
            contentDescription = null,
            modifier = Modifier
                .border(2.dp, Color.White)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {
            Text(
                text = nameUiStage,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                lineHeight = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .padding(top = 120.dp)
                    .align(alignment = Alignment.TopCenter)
                    .background(Color(0x90000000))
                    .wrapContentSize()
            )
            Text(
                text = effectUiStage,
                color = Color.White,
                fontSize = 28.sp,
                lineHeight = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 140.dp)
                    .align(alignment = Alignment.BottomCenter)
                    .background(Color(0x90000000))
                    .wrapContentSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MonsterZonePreview() {
    BeatFranticallyIdleTheme {
        AppIdle(modifier = Modifier.fillMaxSize())
    }
}