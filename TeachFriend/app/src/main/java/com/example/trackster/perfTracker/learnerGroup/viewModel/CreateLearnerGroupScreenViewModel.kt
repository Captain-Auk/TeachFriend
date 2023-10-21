package com.example.trackster.perfTracker.learnerGroup.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackster.perfTracker.learnerGroup.domain.ILearnerGroupRepository
import com.example.trackster.perfTracker.learnerGroup.domain.LearnerGroupModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateLearnerGroupScreenViewModel @Inject constructor(
    private val iLearnerGroupRepository: ILearnerGroupRepository

) : ViewModel() {


 //create groups of classes if those classes have same syllabus and tasks
    private val _className= MutableStateFlow(" ")
    val className : MutableStateFlow<String> get() = _className
    // course name for those classes
    private val _courseName = MutableStateFlow(" ")
    val courseName : MutableStateFlow<String> get() = _courseName
    // total number of tasks for that subject
    private val _totalTasks = MutableStateFlow("1")
    val totalTasks : MutableStateFlow<String> get() = _totalTasks
    // total number of breakpoints(no. of terms or semester for that class
    private val _breakpoints = MutableStateFlow("0")
    val breakpoints: MutableStateFlow<String> get() = _breakpoints

    private val _stratumList = MutableStateFlow(emptyList<LearnerGroupModel>())
    val stratumList : StateFlow<List<LearnerGroupModel>> get() = _stratumList

    init {
        viewModelScope.launch {
            _stratumList.update {
                iLearnerGroupRepository.getLearnerGroup()
            }
        }
    }

    fun onClassNameChanged(it: String) {
    _className.value = it
    }

   fun onCourseNameChanged(it: String) {
      _courseName.value = it
   }

   fun onTotalTasksChanged(it: String) {
      _totalTasks.value = it
   }

   fun onBreakpointsChanged(it: String) {
        _breakpoints.value = it
   }


fun insertStratum(learnerGroupModel: LearnerGroupModel){
    viewModelScope.launch {
        iLearnerGroupRepository.createLearnerGroup(learnerGroupModel)
    }
}
//     fun insertStratum(stratum: StratumEntity) {
//         viewModelScope.launch {
//             stratumRepository.createStratum(stratum)
//         }
//
//    }




}