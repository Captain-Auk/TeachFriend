package com.example.trackster.perfTracker.learnerGroup.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.teachfriend.R
import com.example.trackster.navigation.Screens
import com.example.trackster.perfTracker.learnerGroup.domain.LearnerGroupModel
import com.example.trackster.perfTracker.learnerGroup.viewModel.CreateLearnerGroupScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun learnerGroupHomeScreen(
    viewModel: CreateLearnerGroupScreenViewModel,
    navController : NavController
) {
    // Observe the stratumList state flow from the viewModel
    val stratumList by viewModel.stratumList.collectAsStateWithLifecycle()

    MaterialTheme{
        Scaffold(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(id = R.string.app_name)) },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(id = R.string.menu_name)
                            )
                        }
                    }
                )
            }
        ){
            Text(text = "Your Classes")
            //Text(text = "Your Classes", modifier = Modifier.extendBelowTopBar())
            Spacer(modifier = Modifier.height(16.dp))
            StratumList(stratumList)
            Button(
                onClick = {
                    navController.navigate(Screens.Course.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Course")
            }
        }
    }
}


@Composable
fun StratumList(stratumList: List<LearnerGroupModel>) {
    LazyColumn {
        items(stratumList.size) { index ->
            val stratum = stratumList[index]
            Card(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(text = "Class Name: ${stratum.className}")
                Text(text = "Course Name: ${stratum.courseName}")
                Text(text = "Total Tasks: ${stratum.totalTasks}")
                Text(text = "Break Points: ${stratum.breakPoints}")
            }
        }
    }
}
