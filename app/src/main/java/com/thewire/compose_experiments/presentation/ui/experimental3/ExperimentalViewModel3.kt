package com.thewire.compose_experiments.presentation.ui.experimental3

import androidx.compose.ui.graphics.painter.Painter
import androidx.lifecycle.ViewModel
import com.thewire.compose_experiments.backend.getImages
import kotlinx.coroutines.flow.Flow

class ExperimentalViewModel3 : ViewModel() {
    val list = mutableListOf<ExampleListThing>(
        ExampleListThing(
            "this is heading 1",
            "When the ego of"
        ),
        ExampleListThing(
            "this is heading 2",
            "When the ego of awareness facilitates the graces of the thing," +
                    " the conclusion will know teacher." +
                    "Navis resisteres, tanquam primus ionicis tormento.Blueberries paste" +
                    " has to have a divided, aged zucchini component.God, never scrape a son."
        ),
        ExampleListThing(
            "this is heading 3",
            "When the ego of awareness facilitates the graces of the thing," +
                    " the conclusion will know teacher." +
                    "Navis resisteres, tanquam primus ionicis tormento.Blueberries paste" +
                    " has to have a divided, aged zucchini component.God, never scrape a son."
        ),
        ExampleListThing(
            "this is heading 4",
            "When the ego of awareness facilitates the graces of the thing," +
                    " the conclusion will know teacher." +
                    "Navis resisteres, tanquam primus ionicis tormento.Blueberries paste" +
                    " has to have a divided, aged zucchini component.God, never scrape a son."
        ),
        ExampleListThing(
            "this is heading 5",

            "When the ego of awareness facilitates the graces of the thing," +
                    " the conclusion will know teacher." +
                    "Navis resisteres, tanquam primus ionicis tormento.Blueberries paste" +
                    " has to have a divided, aged zucchini component.God, never scrape a son."),
    )

    fun getImage(): Flow<Int> {
        return getImages()
    }
}


data class ExampleListThing(
    val heading: String,
    val body: String,
)