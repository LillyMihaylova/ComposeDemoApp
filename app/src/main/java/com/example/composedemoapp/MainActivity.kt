package com.example.composedemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.composedemoapp.ui.screen.LaunchesScreen
import com.example.composedemoapp.ui.theme.ComposeDemoAppTheme
import com.example.composedemoapp.viewmodel.LaunchesScreenVM
import org.koin.android.ext.android.inject

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    private val viewModel: LaunchesScreenVM by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchesScreen(viewModel)
                }
            }
        }
    }
}