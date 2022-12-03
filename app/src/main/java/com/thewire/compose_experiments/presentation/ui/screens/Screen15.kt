package com.thewire.compose_experiments.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController

@Composable
fun Screen15() {
    val fullscreen = remember { mutableStateOf(false)}
        Text("this is the video screen")
        val v = AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                val player = YouTubePlayerView(context)
                player.enableAutomaticInitialization = false
                val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
                player.initialize(getPlayer(player, fullscreen), options)
                player
            }
        )

        if(fullscreen.value) {
            Dialog(
                onDismissRequest = {
                    fullscreen.value = false
                    Log.d("DIALOG", "dialog dismissed")
                },
                properties = DialogProperties(dismissOnClickOutside = false, dismissOnBackPress = true)
            ) {
                Column() {
                    Text("dialog open")
                    v
                }
            }
        } else {
            v
        }


}

fun getPlayer(playerView: YouTubePlayerView, fullscreen: MutableState<Boolean>): YouTubePlayerListener {

    val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
        override fun onReady(youTubePlayer: YouTubePlayer) {
            // We're using pre-made custom ui
            val defaultPlayerUiController =
                DefaultPlayerUiController(playerView, youTubePlayer)
            defaultPlayerUiController.showFullscreenButton(true)

            // When the video is in full-screen, cover the entire screen
            defaultPlayerUiController.setFullScreenButtonClickListener {
                if (playerView.isFullScreen()) {
                    fullscreen.value = true
                    playerView.exitFullScreen()

                } else {
                    fullscreen.value = false
                    playerView.enterFullScreen()
                }
            }


            playerView.setCustomPlayerUi(defaultPlayerUiController.rootView)

            val videoId = "ZUs8oKa7fqw"
            youTubePlayer.cueVideo(videoId, 0f)
        }
    }
    return listener
}