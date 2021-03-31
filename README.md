# variantMetadata-logging

Toy project to illustrate inconsistent behavior with a static logger and three methods of `org.gradle.api.artifacts.VariantMetadata`.

This is also documented at gradle/gradle#16679

* `VariantMetadata#withCapabilities(Action<? super MutableCapabilitiesMetadata>)` - logs successfully
* `VariantMetadata#attributes(Action<? super AttributeContainer>)` - logs successfully
* `VariantMetadata#withDependencies(Action<? super DirectDependenciesMetadata>)` - black hole! no output

## Key classes
* `buildSrc/src/main/java/com/kylemoore/DummyComponentMetadataRule.java` - simple rule with logging from above methods
* `lib/build.gradle:28` - applies rule

## Steps to reproduce

`$ ./gradlew :lib:assemble`

### Expected output
```
> Task :lib:compileJava
*** Setting capabilities
*** Setting attributes
*** Setting dependencies
```

### Actual output
```
> Task :lib:compileJava
*** Setting capabilities
*** Setting attributes
```