package me.i38.gesture.ui.settings

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import me.i38.gesture.R
import me.i38.gesture.ui.gesture.GestureEditActivity
import me.i38.gesture.ui.theme.MicroGestureTheme

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {

    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            MicroGestureTheme {
                SettingsScreen(
                    viewModel = viewModel,
                    onNavigateBack = { finish() },
                    onNavigateToGestureEdit = { gestureId ->
                        val intent = Intent(this, GestureEditActivity::class.java)
                        intent.putExtra("gesture_id", gestureId)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToGestureEdit: (Long) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.addNewGesture() }) {
                        Icon(Icons.Default.Add, contentDescription = "Add Gesture")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // General Settings
            item {
                SettingsSection(title = "General") {
                    SettingItem(
                        title = "Vibrate Intensity",
                        subtitle = "Current: ${uiState.vibrateIntensity}",
                        icon = Icons.Default.Vibration,
                        onClick = { viewModel.showVibrateIntensityDialog() }
                    )
                    
                    SettingItem(
                        title = "Toast Feedback",
                        subtitle = "Show action confirmations",
                        icon = Icons.Default.Notifications,
                        trailing = {
                            Switch(
                                checked = uiState.isToastFeedbackEnabled,
                                onCheckedChange = { viewModel.setToastFeedbackEnabled(it) }
                            )
                        }
                    )
                }
            }

            // Gestures Section
            item {
                SettingsSection(title = "Gestures (${uiState.gestures.size})") {
                    // Empty state or gestures list
                }
            }

            items(uiState.gestures) { gesture ->
                GestureSettingItem(
                    gesture = gesture,
                    onClick = { onNavigateToGestureEdit(gesture.id) },
                    onToggle = { viewModel.toggleGesture(gesture.id, it) }
                )
            }

            // Permissions Section
            item {
                SettingsSection(title = "Permissions") {
                    PermissionItem(
                        title = "Accessibility Service",
                        isGranted = uiState.hasAccessibilityPermission,
                        onClick = { viewModel.requestAccessibilityPermission() }
                    )
                    
                    PermissionItem(
                        title = "Overlay Permission",
                        isGranted = uiState.hasOverlayPermission,
                        onClick = { viewModel.requestOverlayPermission() }
                    )
                    
                    PermissionItem(
                        title = "Write Settings",
                        isGranted = uiState.hasWriteSettingsPermission,
                        onClick = { viewModel.requestWriteSettingsPermission() }
                    )
                }
            }
        }
    }
}

@Composable
fun SettingsSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}

@Composable
fun SettingItem(
    title: String,
    subtitle: String? = null,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    trailing: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    val modifier = if (onClick != null) {
        Modifier.fillMaxWidth()
    } else {
        Modifier.fillMaxWidth()
    }

    Card(
        modifier = modifier.padding(vertical = 2.dp),
        onClick = onClick ?: {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            trailing?.invoke()
        }
    }
}

@Composable
fun GestureSettingItem(
    gesture: me.i38.gesture.data.model.GestureConfig,
    onClick: () -> Unit,
    onToggle: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = getGestureIcon(gesture.axis),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${getAxisName(gesture.axis)} → ${getActionName(gesture.action)}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Threshold: ${gesture.threshold}, Direction: ${getDirectionName(gesture.direction)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Switch(
                checked = gesture.isEnabled,
                onCheckedChange = onToggle
            )
        }
    }
}

@Composable
fun PermissionItem(
    title: String,
    isGranted: Boolean,
    onClick: () -> Unit
) {
    SettingItem(
        title = title,
        subtitle = if (isGranted) "Granted" else "Not granted",
        icon = if (isGranted) Icons.Default.CheckCircle else Icons.Default.Warning,
        trailing = {
            if (!isGranted) {
                TextButton(onClick = onClick) {
                    Text("Grant")
                }
            }
        }
    )
}

private fun getGestureIcon(axis: Int): androidx.compose.ui.graphics.vector.ImageVector {
    return when (axis) {
        1 -> Icons.Default.SwapVert
        2 -> Icons.Default.SwapHoriz
        3 -> Icons.Default.RotateRight
        4 -> Icons.Default.VolumeUp
        else -> Icons.Default.Gesture
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

private fun getDirectionName(direction: Int): String {
    return when (direction) {
        0 -> "Any"
        1 -> "Positive"
        -1 -> "Negative"
        else -> "Unknown"
    }
}