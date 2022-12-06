package com.thewire.compose_experiments.presentation.ui.screens

import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Screen15() {
    val configuration = LocalConfiguration.current
    Log.i("YOUTUBE", configuration.screenHeightDp.toString())
    val fullscreen = remember { mutableStateOf(false)}
        if(fullscreen.value) {
            Dialog(
                onDismissRequest = {
                    fullscreen.value = false
                    Log.d("DIALOG", "dialog dismissed")
                },
                properties = DialogProperties(dismissOnClickOutside = false, dismissOnBackPress = true, usePlatformDefaultWidth = false)
            ) {
                    val width = (configuration.screenHeightDp / 9) * 16
                    AndroidView(
                        modifier = Modifier
                            .width(width.dp)
                            .height(configuration.screenHeightDp.dp)
                            .background(color= Color.Green)
                            .border(BorderStroke(2.dp, Color.Magenta)),
                        factory = { context ->
                            val view = LayoutInflater.from(context).inflate(com.thewire.compose_experiments.R.layout.youtubelayout, null, false)
                            val player = view.findViewById<YouTubePlayerView>(com.thewire.compose_experiments.R.id.youtube_player_view)
                            player.enableAutomaticInitialization = false
                            val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
                            player.initialize(getPlayer(player, fullscreen), options)
                            view
                        }
                    )
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
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(color = Color.Yellow)
//                ) {}
                AndroidView(
                    modifier = Modifier
                        .background(color= Color.Green),
                    factory = { context ->
                        val layout = LinearLayout(context)
                        val player = YouTubePlayerView(context)
                        layout.addView(player)
                        player.enableAutomaticInitialization = false
                        val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
                        player.initialize(getPlayer(player, fullscreen), options)
                        layout
                    }
                )
            }
        }


}

fun getPlayer(playerView: YouTubePlayerView, fullscreen: MutableState<Boolean>): YouTubePlayerListener {

    val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
        override fun onReady(youTubePlayer: YouTubePlayer) {
            val tracker = YouTubePlayerTracker()
            youTubePlayer.addListener(tracker)
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
            youTubePlayer.cueVideo(videoId, 0f)
        }
    }
    return listener
}