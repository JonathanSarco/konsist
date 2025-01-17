package com.lemonappdev.konsist.core.architecture

import com.lemonappdev.konsist.api.architecture.DependencyRules
import com.lemonappdev.konsist.api.architecture.KoArchitectureAssertion
import com.lemonappdev.konsist.api.container.KoScope
import com.lemonappdev.konsist.core.verify.assert

class KoArchitectureAssertionCore : KoArchitectureAssertion {
    override fun KoScope.assertArchitecture(dependencies: DependencyRules.() -> Unit) {
        val dependencyRules = DependencyRulesCore()
        dependencies(dependencyRules)
        val architectureScope = KoArchitectureScope(dependencyRules, this)
        architectureScope.assert()
    }

    override fun KoScope.assertArchitecture(dependencies: DependencyRules) {
        KoArchitectureScope(dependencies, this).assert()
    }

    override fun architecture(dependencies: DependencyRules.() -> Unit): DependencyRules {
        val dependencyRules = DependencyRulesCore()
        dependencies(dependencyRules)
        return dependencyRules
    }
}
