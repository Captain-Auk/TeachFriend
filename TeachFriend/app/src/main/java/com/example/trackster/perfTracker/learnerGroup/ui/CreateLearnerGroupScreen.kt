package com.example.trackster.perfTracker.learnerGroup.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.teachfriend.R
import com.example.trackster.navigation.Screens
import com.example.trackster.perfTracker.learnerGroup.domain.LearnerGroupModel
import com.example.trackster.uiHelpers.GeneralTextField
import com.example.trackster.uiHelpers.NumberTextField
import com.example.trackster.perfTracker.learnerGroup.viewModel.CreateLearnerGroupScreenViewModel

//Creation of stratum, that is, a container for a particular class and course.
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateLearnerGroupScreen(viewModel: CreateLearnerGroupScreenViewModel, navController : NavController)  {

    val className = viewModel.className.collectAsStateWithLifecycle()
    val courseName = viewModel.courseName.collectAsStateWithLifecycle()
    val totalTasks = viewModel.totalTasks.collectAsStateWithLifecycle()
    val breakPoints = viewModel.breakpoints.collectAsStateWithLifecycle()
    MaterialTheme {
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
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Create your class")
                Log.d("HomeScreen", "I am in homeScreen")
                Spacer(modifier = Modifier.height(16.dp))
                GeneralTextField(
                    value = className.value,
                    onValueChange = { viewModel.onClassNameChanged(it) },
                    label = stringResource(id = R.string.class_name)
                )
                GeneralTextField(
                    value = courseName.value,
                    onValueChange = { viewModel.onCourseNameChanged(it) },
                    label = stringResource(id = R.string.course_name)
                )

                NumberTextField(
                    value = totalTasks.value,
                    onValueChange = { viewModel.onTotalTasksChanged(it) },
                    label = stringResource(id = R.string.total_tasks)
                )
                NumberTextField(
                    value = breakPoints.value.toString(),
                    onValueChange = { viewModel.onBreakpointsChanged(it) },
                    label = stringResource(id = R.string.total_breakpoints)
                )
                Button(
                    //text = stringResource(id = R.string.submit),
                    onClick = { viewModel.insertStratum(
                        LearnerGroupModel(
                        null,
                        className = className.value,
                        courseName = courseName.value,
                        totalTasks = totalTasks.value.toInt(),
                        breakPoints = breakPoints.value.toInt())
                        )
                    }
                ){
                    Text(text = "Add Stratum")
                }

                Button(
                    onClick = {
                        navController.navigate(Screens.Course.route)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Course")
                }
                Log.d("HomeScreen", "I am pass the Course button in homeScreen")
            }
        }
    }
}

/*@Preview
@Composable
fun HomeScreenPreview() {
    var navController: NavHostController = rememberNavController()
    // Create a fake view model with some sample data
    val fakeViewModel = CreateStratumScreenViewModel().apply {
        onClassNameChanged("7I")
        onCourseNameChanged("Computer")
        onTotalTasksChanged(4)
        onBreakpointsChanged(1)
    }
    // Call the LoginScreen function with the fake view model
    CreateStratumScreen(fakeViewModel, navController  = navController)
}*/