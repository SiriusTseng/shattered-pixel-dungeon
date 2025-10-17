# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Shattered Pixel Dungeon is a traditional roguelike dungeon crawler built with Java using the LibGDX framework. It's an open-source game based on Pixel Dungeon that supports Android, iOS, and Desktop platforms. The project uses Gradle for build management and is structured into multiple modules for different platforms.

## Build Commands

### Desktop Development
- **Run in debug mode**: `./gradlew desktop:debug`
- **Build release JAR**: `./gradlew desktop:release` (outputs to `/desktop/build/libs`)
- **Create platform-specific executable**: `./gradlew desktop:jpackageimage` (outputs to `/desktop/build/jpackage`)

### Android Development
- **Build debug APK**: Use Android Studio's standard build system
- **Build release APK/AAB**: Use Android Studio's "Generate Signed Bundle / APK"
- **Copy native libraries**: Automatically handled by `copyAndroidNatives` task

### Prerequisites
- JDK 11+ (Java 21 recommended for Android Studio)
- Android Studio for Android development
- Gradle (handled by gradlew wrapper)

## Architecture Overview

### Module Structure
- **core/**: Platform-independent game logic and mechanics
- **desktop/**: Desktop-specific launcher and platform code
- **android/**: Android-specific platform code
- **ios/**: iOS-specific platform code (RoboVM)
- **services/**: Platform-specific services (updates, news)

### Core Package Structure
The game follows a modular architecture with these key packages:

- **actors/**: All game entities (Hero, mobs, NPCs, buffs, blobs)
  - **buffs/**: Status effects and temporary modifications
  - **blobs/**: Area-of-effect environmental effects
  - **chars/**: Character classes and behaviors
- **items/**: Game items and equipment
  - **armor/**, **weapons/**, **wands/**, **artifacts/**: Equipment categories
  - **food/**, **potions/**, **scrolls/**: Consumables
  - **bags/**: Storage containers
- **levels/**: Dungeon generation and level management
  - **features/**: Terrain features (doors, traps, etc.)
  - **traps/**: Trap mechanics
- **scenes/**: Game UI scenes and screens
- **sprites/**: Visual assets and rendering
- **ui/**: User interface components
- **windows/**: Modal windows and dialogs

### Key Systems

#### Item System
All items inherit from the base `Item` class in `items/Item.java`. The system uses:
- **Generator**: Random item generation based on depth
- **Heap**: Ground item containers
- **EquipableItem**: Base for equipment with curse mechanics
- **Recipe**: Alchemy crafting system

#### Actor System
Game entities use a turn-based system managed by `Actor.java`:
- **Buff**: Temporary status effects
- **Char**: Base character class
- **Mob**: Enemy AI and behavior

#### Level Generation
Dungeon levels are procedurally generated with:
- **RegularLevel**: Standard dungeon layouts
- **CavesLevel**: Cave-like terrain
- **CityLevel**: Special themed levels

## Development Notes

### Platform-Specific Code
- Desktop uses LWJGL3 backend
- Android uses native Android backend
- iOS uses RoboVM for iOS compatibility
- Shared code lives in the `core` module

### Assets
- Game assets are stored in `core/src/main/assets/`
- Localization files in `assets/locales/`
- Images and sounds in respective asset folders

### Version Management
- Version info defined in `build.gradle` (appVersionCode, appVersionName)
- Currently uses GDX version 1.13.6-SNAPSHOT
- Android SDK 35, Min SDK 21

### Testing and Debugging
- Desktop builds are faster for testing core mechanics
- Use `desktop:debug` for development builds
- Release builds use R8 for optimization on Android

## Common Development Patterns

### Item Implementation
When adding new items:
1. Extend appropriate base class (Weapon, Armor, etc.)
2. Implement required abstract methods
3. Add to Generator for random spawning
4. Update localization files

### Buff Implementation
When adding new status effects:
1. Extend `Buff` or `FlavourBuff`
2. Override `act()` for turn-based effects
3. Use `immunities()` for buff interactions

### Actor Implementation
When adding new characters:
1. Extend `Char` or `Mob`
2. Implement AI behavior in `act()`
3. Define sprite and animation logic

## Important Files

- `build.gradle`: Main build configuration
- `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/Dungeon.java`: Core game state
- `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/ShatteredPixelDungeon.java`: Main game class
- `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/actors/chars/Hero.java`: Player character
- `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/items/Generator.java`: Item generation logic