package com.thewire.compose_experiments.presentation.ui.screens

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.thewire.compose_experiments.R
import com.google.android.youtube.player.YouTubePlayerSupportFragmentXKt

@Composable
fun Screen14() {
    val ctx = LocalContext.current
    AndroidView(factory = {
        val fm = (ctx as AppCompatActivity).supportFragmentManager
        val view = FragmentContainerView(it).apply {
            id = R.id.fragment_container_view_tag
        }
        val fragment = YouTubePlayerSupportFragmentXKt().apply {
            initialize("YoutubeApiKey",
                object : YouTubePlayer.OnInitializedListener {
                    override fun onInitializationFailure(
                        provider: YouTubePlayer.Provider,
                        result: YouTubeInitializationResult
                    ) {
                        Toast.makeText(
                            ctx,
                            "Error playing video",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onInitializationSuccess(
                        provider: YouTubePlayer.Provider,
                        player: YouTubePlayer,
                        wasRestored: Boolean
                    ) {
                        if (!wasRestored) {
                            player.cueVideo("mhJRzQsLZGg")
                        }
                    }
                })
        }
        fm.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view_tag, fragment)
        }
        view
    })
}