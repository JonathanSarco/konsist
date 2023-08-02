package com.lemonappdev.konsist.core.declaration.kofunctiondeclaration.forkomodifierprovider

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoFunctionDeclarationForKoInfixModifierProviderTest {
    @Test
    fun `function-without-infix-modifier`() {
        // given
        val sut = getSnippetFile("function-without-infix-modifier")
            .functions()
            .first()

        // then
        sut.hasInfixModifier shouldBeEqualTo false
    }

    @Test
    fun `function-with-infix-modifier`() {
        // given
        val sut = getSnippetFile("function-with-infix-modifier")
            .functions()
            .first()

        // then
        sut.hasInfixModifier shouldBeEqualTo true
    }

    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/kofunctiondeclaration/forkomodifierprovider/snippet/forkoinfixmodifierprovider/", fileName)
}
