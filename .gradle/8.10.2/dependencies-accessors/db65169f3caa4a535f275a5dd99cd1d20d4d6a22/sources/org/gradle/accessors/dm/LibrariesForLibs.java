package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final QfapiLibraryAccessors laccForQfapiLibraryAccessors = new QfapiLibraryAccessors(owner);
    private final QuiltLibraryAccessors laccForQuiltLibraryAccessors = new QuiltLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>minecraft</b> with <b>com.mojang:minecraft</b> coordinates and
     * with version reference <b>minecraft</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMinecraft() {
        return create("minecraft");
    }

    /**
     * Dependency provider for <b>qkl</b> with <b>org.quiltmc.quilt-kotlin-libraries:quilt-kotlin-libraries</b> coordinates and
     * with version reference <b>qkl</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getQkl() {
        return create("qkl");
    }

    /**
     * Group of libraries at <b>qfapi</b>
     */
    public QfapiLibraryAccessors getQfapi() {
        return laccForQfapiLibraryAccessors;
    }

    /**
     * Group of libraries at <b>quilt</b>
     */
    public QuiltLibraryAccessors getQuilt() {
        return laccForQuiltLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class QfapiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public QfapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>qfapi</b> with <b>org.quiltmc.quilted-fabric-api:quilted-fabric-api</b> coordinates and
         * with version reference <b>qfapi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("qfapi");
        }

        /**
         * Dependency provider for <b>deprecated</b> with <b>org.quiltmc.quilted-fabric-api:quilted-fabric-api-deprecated</b> coordinates and
         * with version reference <b>qfapi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDeprecated() {
            return create("qfapi.deprecated");
        }

    }

    public static class QuiltLibraryAccessors extends SubDependencyFactory {

        public QuiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>loader</b> with <b>org.quiltmc:quilt-loader</b> coordinates and
         * with version reference <b>loader</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLoader() {
            return create("quilt.loader");
        }

        /**
         * Dependency provider for <b>mappings</b> with <b>org.quiltmc:quilt-mappings</b> coordinates and
         * with version reference <b>mappings</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMappings() {
            return create("quilt.mappings");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlin</b> with value <b>1.8.22</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("kotlin"); }

        /**
         * Version alias <b>loader</b> with value <b>0.27.1-beta.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLoader() { return getVersion("loader"); }

        /**
         * Version alias <b>loom</b> with value <b>1.8.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLoom() { return getVersion("loom"); }

        /**
         * Version alias <b>mappings</b> with value <b>1.21+build.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMappings() { return getVersion("mappings"); }

        /**
         * Version alias <b>minecraft</b> with value <b>1.21</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMinecraft() { return getVersion("minecraft"); }

        /**
         * Version alias <b>qfapi</b> with value <b>11.0.0-alpha.3+0.102.0-1.21</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getQfapi() { return getVersion("qfapi"); }

        /**
         * Version alias <b>qkl</b> with value <b>5.0.0+kt.2.0.21+flk.1.12.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getQkl() { return getVersion("qkl"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final QuiltedBundleAccessors baccForQuiltedBundleAccessors = new QuiltedBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.quilted</b>
         */
        public QuiltedBundleAccessors getQuilted() {
            return baccForQuiltedBundleAccessors;
        }

    }

    public static class QuiltedBundleAccessors extends BundleFactory {
        private final QuiltedFabricBundleAccessors baccForQuiltedFabricBundleAccessors = new QuiltedFabricBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public QuiltedBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.quilted.fabric</b>
         */
        public QuiltedFabricBundleAccessors getFabric() {
            return baccForQuiltedFabricBundleAccessors;
        }

    }

    public static class QuiltedFabricBundleAccessors extends BundleFactory {

        public QuiltedFabricBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>quilted.fabric.api</b> which contains the following dependencies:
         * <ul>
         *    <li>org.quiltmc.quilted-fabric-api:quilted-fabric-api</li>
         *    <li>org.quiltmc.quilted-fabric-api:quilted-fabric-api-deprecated</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getApi() {
            return createBundle("quilted.fabric.api");
        }

    }

    public static class PluginAccessors extends PluginFactory {
        private final QuiltPluginAccessors paccForQuiltPluginAccessors = new QuiltPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>kotlin</b> with plugin id <b>org.jetbrains.kotlin.jvm</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKotlin() { return createPlugin("kotlin"); }

        /**
         * Group of plugins at <b>plugins.quilt</b>
         */
        public QuiltPluginAccessors getQuilt() {
            return paccForQuiltPluginAccessors;
        }

    }

    public static class QuiltPluginAccessors extends PluginFactory {

        public QuiltPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>quilt.loom</b> with plugin id <b>org.quiltmc.loom</b> and
         * with version reference <b>loom</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getLoom() { return createPlugin("quilt.loom"); }

    }

}
