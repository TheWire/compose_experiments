package com.thewire.compose_experiments.presentation.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController

@Composable
fun Screen15() {

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val player = YouTubePlayerView(context)
            player.enableAutomaticInitialization = false
            val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
            player.initialize(getPlayer(player), options)
            player
        }
    )
}

fun getPlayer(playerView: YouTubePlayerView): YouTubePlayerListener {

    val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
        override fun onReady(youTubePlayer: YouTubePlayer) {
            // We're using pre-made custom ui
            val defaultPlayerUiController =
                DefaultPlayerUiController(playerView, youTubePlayer)
            defaultPlayerUiController.showFullscreenButton(true)

            // When the video is in full-screen, cover the entire screen
            defaultPlayerUiController.setFullScreenButtonClickListener {
                if (playerView.isFullScreen()) {
                    playerView.exitFullScreen()

                } else {
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