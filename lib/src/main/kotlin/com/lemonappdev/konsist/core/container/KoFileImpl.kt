package com.lemonappdev.konsist.core.container

import com.intellij.psi.PsiElement
import com.lemonappdev.konsist.api.container.KoFile
import com.lemonappdev.konsist.api.declaration.KoBaseDeclaration
import com.lemonappdev.konsist.api.provider.KoParentProvider
import com.lemonappdev.konsist.core.provider.util.KoDeclarationCoreProviderUtil
import com.lemonappdev.konsist.core.ext.toOsSeparator
import com.lemonappdev.konsist.core.provider.KoAnnotationProviderCore
import com.lemonappdev.konsist.core.provider.KoClassProviderCore
import com.lemonappdev.konsist.core.provider.KoDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoFileExtensionProviderCore
import com.lemonappdev.konsist.core.provider.KoFunctionProviderCore
import com.lemonappdev.konsist.core.provider.KoHasPackageProviderCore
import com.lemonappdev.konsist.core.provider.KoImportProviderCore
import com.lemonappdev.konsist.core.provider.KoInterfaceProviderCore
import com.lemonappdev.konsist.core.provider.KoModuleProviderCore
import com.lemonappdev.konsist.core.provider.KoNameProviderCore
import com.lemonappdev.konsist.core.provider.KoObjectProviderCore
import com.lemonappdev.konsist.core.provider.KoPackageProviderCore
import com.lemonappdev.konsist.core.provider.KoPathProviderCore
import com.lemonappdev.konsist.core.provider.KoPropertyProviderCore
import com.lemonappdev.konsist.core.provider.KoSourceSetProviderCore
import com.lemonappdev.konsist.core.provider.KoTextProviderCore
import com.lemonappdev.konsist.core.provider.KoTypeAliasProviderCore
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtFile

internal class KoFileImpl(override val ktFile: KtFile) :
    KoFile,
    KoDeclarationProviderCore,
    KoClassProviderCore,
    KoInterfaceProviderCore,
    KoObjectProviderCore,
    KoPropertyProviderCore,
    KoFunctionProviderCore,
    KoNameProviderCore,
    KoPathProviderCore,
    KoTextProviderCore,
    KoAnnotationProviderCore,
    KoFileExtensionProviderCore,
    KoModuleProviderCore,
    KoSourceSetProviderCore,
    KoPackageProviderCore,
    KoHasPackageProviderCore,
    KoImportProviderCore,
    KoTypeAliasProviderCore {

    override val ktElement: KtElement
        get() = ktFile

    override val psiElement: PsiElement
        get() = ktFile

    override val ktAnnotated: KtAnnotated
        get() = ktFile

    override val parentDeclaration: KoParentProvider?
        get() = null

    override val name by lazy { nameWithExtension.substringBeforeLast('.') }

    override val path: String by lazy {
        ktFile
            .name
            .toOsSeparator()
    }

    override fun declarations(
        includeNested: Boolean,
        includeLocal: Boolean,
    ): Sequence<KoBaseDeclaration> =
        KoDeclarationCoreProviderUtil.getKoDeclarations(ktFile, includeNested, includeLocal, null)

    override fun equals(other: Any?): Boolean = other is KoFile && path == other.path

    override fun hashCode(): Int = 31 * 7 + path.hashCode()
}
