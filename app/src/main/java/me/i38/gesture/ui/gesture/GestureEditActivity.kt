package me.i38.gesture.ui.gesture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import me.i38.gesture.R
import me.i38.gesture.data.model.GestureAxis
import me.i38.gesture.data.model.ActionType
import me.i38.gesture.ui.theme.MicroGestureTheme

@AndroidEntryPoint
class GestureEditActivity : ComponentActivity() {

    private val viewModel: GestureEditViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val gestureId = intent.getLongExtra("gesture_id", -1L)
        if (gestureId != -1L) {
            viewModel.loadGesture(gestureId)
        }
        
        setContent {
            MicroGestureTheme {
                GestureEditScreen(
                    viewModel = viewModel,
                    onNavigateBack = { finish() },
                    onSave = { 
                        viewModel.saveGesture()
                        finish()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GestureEditScreen(
    viewModel: GestureEditViewModel,
    onNavigateBack: () -> Unit,
    onSave: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (uiState.isEditing) "Edit Gesture" else "New Gesture") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    TextButton(onClick = onSave) {
                        Text("Save")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Axis Selection
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Trigger Axis",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    GestureAxis.values().forEach { axis ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = uiState.selectedAxis == axis.value,
                                    onClick = { viewModel.setAxis(axis.value) }
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = uiState.selectedAxis == axis.value,
                                onClick = { viewModel.setAxis(axis.value) }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = axis.displayName)
                        }
                    }
                }
            }

            // Direction Selection
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Direction",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    val directions = listOf(
                        0 to "Any Direction",
                        1 to "Positive",
                        -1 to "Negative"
                    )
                    
                    directions.forEach { (value, name) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = uiState.selectedDirection == value,
                                    onClick = { viewModel.setDirection(value) }
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = uiState.selectedDirection == value,
                                onClick = { viewModel.setDirection(value) }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = name)
                        }
                    }
                }
            }

            // Threshold Slider
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Sensitivity: ${uiState.threshold}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Lower values are more sensitive",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Slider(
                        value = uiState.threshold.toFloat(),
                        onValueChange = { viewModel.setThreshold(it.toInt()) },
                        valueRange = 1f..40f,
                        steps = 39
                    )
                }
            }

            // Action Selection
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Action",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    ActionType.values().take(10).forEach { actionType ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = uiState.selectedAction == actionType.id,
                                    onClick = { viewModel.setAction(actionType.id) }
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = uiState.selectedAction == actionType.id,
                                onClick = { viewModel.setAction(actionType.id) }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = actionType.displayName)
                        }
                    }
                }
            }
        }
    }
}