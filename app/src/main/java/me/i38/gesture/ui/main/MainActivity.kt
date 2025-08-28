package me.i38.gesture.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import me.i38.gesture.R
import me.i38.gesture.ui.settings.SettingsActivity
import me.i38.gesture.ui.theme.MicroGestureTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            MicroGestureTheme {
                MainScreen(
                    viewModel = viewModel,
                    onNavigateToSettings = {
                        startActivity(Intent(this, SettingsActivity::class.java))
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onNavigateToSettings: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Main Switch Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = stringResource(R.string.main_switch),
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = stringResource(R.string.main_switch_tip),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Switch(
                            checked = uiState.isMainSwitchEnabled,
                            onCheckedChange = { viewModel.toggleMainSwitch(it) }
                        )
                    }
                }
            }

            // Status Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Status",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    StatusItem(
                        label = "Gesture Detection",
                        isEnabled = uiState.isGestureDetectionActive,
                        icon = if (uiState.isGestureDetectionActive) Icons.Default.CheckCircle else Icons.Default.Cancel
                    )
                    
                    StatusItem(
                        label = "Accessibility Service",
                        isEnabled = uiState.hasAccessibilityPermission,
                        icon = if (uiState.hasAccessibilityPermission) Icons.Default.CheckCircle else Icons.Default.Warning
                    )
                    
                    StatusItem(
                        label = "Gyroscope Available",
                        isEnabled = uiState.hasGyroscope,
                        icon = if (uiState.hasGyroscope) Icons.Default.CheckCircle else Icons.Default.Error
                    )
                }
            }

            // Gestures List
            if (uiState.gestures.isNotEmpty()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Active Gestures (${uiState.gestures.size})",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        LazyColumn(
                            modifier = Modifier.heightIn(max = 200.dp)
                        ) {
                            items(uiState.gestures) { gesture ->
                                GestureItem(gesture = gesture)
                            }
                        }
                    }
                }
            }

            // Quick Actions
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Quick Actions",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        QuickActionButton(
                            icon = Icons.Default.Settings,
                            label = "Settings",
                            onClick = onNavigateToSettings
                        )
                        
                        QuickActionButton(
                            icon = Icons.Default.Add,
                            label = "Add Gesture",
                            onClick = { viewModel.addNewGesture() }
                        )
                        
                        QuickActionButton(
                            icon = Icons.Default.Info,
                            label = "Help",
                            onClick = { viewModel.showHelp() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatusItem(
    label: String,
    isEnabled: Boolean,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isEnabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun GestureItem(gesture: me.i38.gesture.data.model.GestureConfig) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = getAxisName(gesture.axis),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = getActionName(gesture.action),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun QuickActionButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(32.dp)
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

private fun getAxisName(axis: Int): String {
    return when (axis) {
        1 -> "X-Axis"
        2 -> "Y-Axis"
        3 -> "Z-Axis"
        4 -> "Key"
        else -> "Unknown"
    }
}

private fun getActionName(action: String): String {
    return when (action) {
        "0" -> "None"
        "1" -> "Back"
        "2" -> "Home"
        "3" -> "Recent"
        "4" -> "Notification"
        "5" -> "Quick Settings"
        else -> "Custom"
    }
}