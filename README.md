# [Minecraft Forge Mod Template](https://github.com/jaymar921/Forge-1.20.2-Modding-Template)
> Version: 1.20.2 | with Parchment | prepared by: Jaymar921

This repository has all the configuration setup.

### Changing Mod Properties
Head to `gradle.properties` and only modify the `## Mod Properties` section

### Changing Main Class Directory
By default, the MainClass is `JaymarMod` and it's in the package `java.net.jaymar.firstmod`.

If you wish to change the directory, make sure to link it in `## Mod Properties` inside `gradle.properties`

### Build on First Run
- Run the `./gradlew genIntellijRuns` command to build the project. As long as `BUILD SUCCESSFUL` is shown, just ignore the warnings and you're good to go.

### Running the Client
- Proceed to `Gradle's` tab -> `Tasks` -> `forgegradle runs` -> and click on `runClient` to open Minecraft client
