package com.lemonappdev.konsist.core.declaration

import com.lemonappdev.konsist.api.declaration.KoPrimaryConstructorDeclaration
import com.lemonappdev.konsist.core.cache.KoDeclarationCache
import org.jetbrains.kotlin.psi.KtPrimaryConstructor

internal class KoPrimaryConstructorDeclarationImpl private constructor(ktPrimaryConstructor: KtPrimaryConstructor) :
    KoConstructorDeclarationImpl(ktPrimaryConstructor), KoPrimaryConstructorDeclaration {
    internal companion object {
        private val cache = KoDeclarationCache<KoPrimaryConstructorDeclarationImpl>()

        internal fun getInstance(ktPrimaryConstructor: KtPrimaryConstructor) =
            cache.getOrCreateInstance(ktPrimaryConstructor) { KoPrimaryConstructorDeclarationImpl(ktPrimaryConstructor) }
    }
}