package com.example.composedemoapp.ui.screen

import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composedemoapp.network.model.response.Launch
import com.example.composedemoapp.viewmodel.LaunchesScreenVM

@ExperimentalMaterial3Api
@Composable
fun LaunchesScreen(viewModel: LaunchesScreenVM) {
    viewModel.getLaunches()
    val launchesData = viewModel.launches.observeAsState()
    launchesData?.let { launches ->
        LazyColumn {
            items(launches.value!!.size) { index ->
                LaunchCard(launches.value!![index])
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun LaunchCard(launch: Launch) {
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large
    ) {

        AsyncImage(
            model = launch.links?.patch?.small,
            contentDescription = "A patch image of the launch",
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = launch.name ?: "",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = launch.dateLocal ?: "",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

