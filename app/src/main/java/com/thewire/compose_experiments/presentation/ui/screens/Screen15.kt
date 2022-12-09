package com.thewire.compose_experiments.presentation.ui.screens

import android.util.Log
import android.view.LayoutInflater
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController
import com.thewire.compose_experiments.presentation.ui.experiemental15.ExperimentalViewModel15
import com.thewire.compose_experiments.presentation.ui.experiemental15.ExperimentalViewModel15Event.*


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Screen15(viewModel: ExperimentalViewModel15) {
    LaunchedEffect(key1 = viewModel) {
        Log.i("YOUTUBE", "launch")
        viewModel.onEvent(OnLifeCycleChange(true))
    }

    val configuration = LocalConfiguration.current
    val width = (configuration.screenHeightDp / 9) * 16
    val fullscreen = remember { mutableStateOf(false) }
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val youtubeplayer = remember {
        movableContentOf {
            AndroidView(
                modifier = Modifier
                    .width(width.dp)
                    .height(configuration.screenHeightDp.dp)
                    .background(color = Color.Green)
                    .border(BorderStroke(2.dp, Color.Magenta)),
                factory = { context ->
                    val view = LayoutInflater.from(context).inflate(com.thewire.compose_experiments.R.layout.youtubelayout, null, false)
                    val player = view.findViewById<YouTubePlayerView>(com.thewire.compose_experiments.R.id.youtube_player_view)
                    player.enableAutomaticInitialization = false
                    val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
                    lifecycle.addObserver(player)
                    player.initialize(getPlayerListener(player, fullscreen, viewModel), options)
                    view
                }
            )
        }
    }
    DisposableEffect(key1 = viewModel) {
        onDispose {
            viewModel.onEvent(OnLifeCycleChange(false))
            Log.i("YOUTUBE", "dispose")
        }
    }
        if(fullscreen.value) {
            Dialog(
                onDismissRequest = {
                    fullscreen.value = false
                    Log.d("DIALOG", "dialog dismissed")
                },
                properties = DialogProperties(dismissOnClickOutside = false, dismissOnBackPress = true, usePlatformDefaultWidth = false)
            ) {
                    youtubeplayer()
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Button(
                    onClick = {fullscreen.value = !fullscreen.value}
                ) {
                    Text("Toggle Fullscreen")
                }
                Text("non fullscreen")
                youtubeplayer()
            }
        }


}

fun getPlayerListener(
    playerView: YouTubePlayerView, fullscreen: MutableState<Boolean>,
    viewModel: ExperimentalViewModel15
): YouTubePlayerListener {

    val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
        override fun onReady(youTubePlayer: YouTubePlayer) {
            // We're using pre-made custom ui
            val defaultPlayerUiController =
                DefaultPlayerUiController(playerView, youTubePlayer)
            defaultPlayerUiController.showFullscreenButton(true)

            // When the video is in full-screen, cover the entire screen
            defaultPlayerUiController.setFullScreenButtonClickListener {
                fullscreen.value = !fullscreen.value
            }


            playerView.setCustomPlayerUi(defaultPlayerUiController.rootView)

            val videoId = "ZUs8oKa7fqw"
            when (viewModel.videoState) {
                "UNSTARTED" -> {
                    youTubePlayer.cueVideo(videoId, 0f)
                }
                "PAUSED" -> {
                    youTubePlayer.cueVideo(videoId, viewModel.videoSeconds)
                }
                "PLAYING", "BUFFERING" -> {
                    youTubePlayer.loadVideo(videoId, viewModel.videoSeconds)
                }
                else -> {}
            }
        }

        override fun onStateChange(
            youTubePlayer: YouTubePlayer,
            state: PlayerConstants.PlayerState
        ) {
            super.onStateChange(youTubePlayer, state)
            Log.i("YOUTUBE", state.toString())
            viewModel.onEvent(OnStateChange(state.toString()))
        }

        override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {
            super.onCurrentSecond(youTubePlayer, second)
            viewModel.onEvent(OnSecondChange(second))
        }

    }
    return listener
}