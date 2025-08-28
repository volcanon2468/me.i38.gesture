# Micro Gesture - Perfect Android App

A comprehensive gesture control application that allows users to trigger various phone actions through device rotation and physical key gestures.

## Features

### Core Functionality
- **Gesture Detection**: Uses gyroscope and accelerometer sensors to detect device rotation gestures
- **Action Execution**: Performs system actions like back, home, recent tasks, notifications, etc.
- **Accessibility Service**: Integrates with Android accessibility services for system-level actions
- **Custom Gestures**: Create and configure custom gestures for different axes and directions
- **App-Specific Settings**: Configure different gesture sets for different applications

### Advanced Features
- **Automation**: Auto-click and custom automation based on UI elements or notifications
- **Panel System**: Quick access panel with customizable actions and apps
- **Mouse Pad**: Virtual mouse pad for one-handed operation
- **Screen Protection**: Touch protection and screen lock features
- **Quick Settings Tile**: Toggle gestures from notification panel

### Technical Implementation
- **Modern Architecture**: MVVM pattern with Hilt dependency injection
- **Jetpack Compose UI**: Modern declarative UI framework
- **Room Database**: Local data persistence for gestures and configurations
- **Coroutines**: Asynchronous programming for smooth performance
- **Sensor Management**: Efficient sensor data processing and gesture recognition

## Architecture

### Project Structure
```
app/
├── src/main/java/me/i38/gesture/
│   ├── GestureApplication.kt          # Application class with Hilt
│   ├── di/                            # Dependency injection modules
│   ├── data/                          # Data layer
│   │   ├── model/                     # Data models and entities
│   │   ├── database/                  # Room database and DAOs
│   │   └── repository/                # Repository implementations
│   ├── service/                       # Background services
│   ├── ui/                           # UI layer
│   │   ├── main/                     # Main screen
│   │   ├── settings/                 # Settings screen
│   │   ├── gesture/                  # Gesture editing
│   │   └── theme/                    # UI theme and styling
│   └── utils/                        # Utility classes
└── src/main/res/                     # Resources
```

### Key Components

#### 1. Sensor Management (`SensorHelper`)
- Manages gyroscope and accelerometer sensors
- Processes sensor data to detect gesture events
- Provides gesture event flow for reactive programming

#### 2. Action Execution (`ActionExecutor`)
- Executes various system and custom actions
- Handles permissions and error cases
- Provides haptic feedback and toast notifications

#### 3. Gesture Detection (`GestureDetector`)
- Matches sensor events to configured gestures
- Manages gesture debouncing and threshold checking
- Coordinates between sensor input and action execution

#### 4. Accessibility Service (`GestureAccessibilityService`)
- Provides system-level action capabilities
- Handles accessibility events for automation features
- Manages service lifecycle and permissions

## Setup and Installation

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK API 21+ (minimum) / API 34 (target)
- Device with gyroscope sensor (recommended)

### Building the App
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Build and run on device or emulator

### Required Permissions
The app requires several permissions for full functionality:

1. **Accessibility Service**: Enable in Settings > Accessibility > Micro Gesture
2. **Overlay Permission**: For floating panels and mouse pad
3. **Write Settings**: For brightness and rotation control
4. **Notification Access**: For notification-based automation
5. **Usage Stats**: For app-specific gesture configurations

## Usage

### Basic Setup
1. Launch the app and enable the main switch
2. Grant required permissions when prompted
3. Enable accessibility service in Android settings
4. Configure gestures in the settings screen

### Creating Gestures
1. Tap the "+" button to add a new gesture
2. Select the trigger axis (X, Y, Z, or Key)
3. Choose direction and sensitivity
4. Assign an action to execute
5. Save the gesture configuration

### Available Actions
- **System Actions**: Back, Home, Recent Tasks, Notifications, Quick Settings
- **Media Controls**: Play/Pause, Next/Previous track, Volume control
- **Device Controls**: WiFi, Bluetooth, Flashlight, Screen rotation
- **Custom Actions**: Launch apps, execute shortcuts, automation scripts

## Testing

### Unit Tests
Run unit tests with:
```bash
./gradlew test
```

### Instrumented Tests
Run instrumented tests with:
```bash
./gradlew connectedAndroidTest
```

### Manual Testing
1. Test gesture detection with different device orientations
2. Verify action execution for each configured gesture
3. Test permission handling and error cases
4. Validate accessibility service integration

## Known Limitations

1. **Hardware Dependency**: Requires gyroscope sensor for rotation gestures
2. **Permission Requirements**: Needs multiple system permissions for full functionality
3. **Device Compatibility**: Some features may not work on all Android devices
4. **Battery Usage**: Continuous sensor monitoring may impact battery life

## Security and Privacy

- **No Data Collection**: The app does not collect or transmit personal data
- **Local Storage**: All configurations stored locally on device
- **Permission Transparency**: Clear explanation of why each permission is needed
- **Accessibility Compliance**: Follows Android accessibility guidelines

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes with proper testing
4. Submit a pull request with detailed description

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For issues and feature requests, please use the GitHub issue tracker or contact the development team.