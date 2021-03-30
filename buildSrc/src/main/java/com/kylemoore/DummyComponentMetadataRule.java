package com.kylemoore;

import org.gradle.api.artifacts.ComponentMetadataContext;
import org.gradle.api.artifacts.ComponentMetadataRule;
import org.gradle.api.artifacts.ModuleVersionIdentifier;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;

public class DummyComponentMetadataRule implements ComponentMetadataRule {

  private static final Logger LOG = Logging.getLogger(DummyComponentMetadataRule.class);

  @Override
  public void execute(ComponentMetadataContext context) {
    ModuleVersionIdentifier id = context.getDetails().getId();

    context.getDetails().maybeAddVariant("dummyVariant", "runtime", variantMetadata -> {
      variantMetadata.withCapabilities(mutableCapabilitiesMetadata -> {
        LOG.lifecycle("*** Setting capabilities");
      });
      variantMetadata.attributes(attributeContainer -> {
        LOG.lifecycle("*** Setting attributes");
      });
      variantMetadata.withDependencies(directDependencyMetadata -> {
        LOG.lifecycle("*** Setting dependencies");
      });
    });

  }
}
