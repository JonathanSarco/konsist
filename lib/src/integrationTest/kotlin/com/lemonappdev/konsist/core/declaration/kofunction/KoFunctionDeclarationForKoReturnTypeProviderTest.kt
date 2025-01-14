package com.lemonappdev.konsist.core.declaration.kofunction

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import com.lemonappdev.konsist.testdata.SampleType
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoFunctionDeclarationForKoReturnTypeProviderTest {
    @Test
    fun `function-not-return-type`() {
        // given
        val sut = getSnippetFile("function-not-return-type")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            hasReturnType shouldBeEqualTo false
            returnType shouldBeEqualTo null
            hasReturnType() shouldBeEqualTo false
            hasReturnType { it.name == "String" } shouldBeEqualTo false
            hasReturnTypeOf(String::class) shouldBeEqualTo false
        }
    }

    @Test
    fun `extension-function-not-return-type`() {
        // given
        val sut = getSnippetFile("extension-function-not-return-type")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            hasReturnType shouldBeEqualTo false
            returnType shouldBeEqualTo null
            hasReturnType() shouldBeEqualTo false
            hasReturnType { it.name == "String" } shouldBeEqualTo false
            hasReturnTypeOf(String::class) shouldBeEqualTo false
        }
    }

    @Test
    fun `function-return-type`() {
        // given
        val sut = getSnippetFile("function-return-type")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            hasReturnType shouldBeEqualTo true
            returnType?.name shouldBeEqualTo "SampleType"
            hasReturnType() shouldBeEqualTo true
            hasReturnType { it.name == "SampleType" } shouldBeEqualTo true
            hasReturnType { it.name == "Int" } shouldBeEqualTo false
            hasReturnTypeOf(SampleType::class) shouldBeEqualTo true
            hasReturnTypeOf(Int::class) shouldBeEqualTo false
        }
    }

    @Test
    fun `function-return-import-alias`() {
        // given
        val sut = getSnippetFile("function-return-import-alias")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            hasReturnType shouldBeEqualTo true
            returnType?.name shouldBeEqualTo "ImportAlias"
            hasReturnType() shouldBeEqualTo true
            hasReturnType { it.name == "ImportAlias" } shouldBeEqualTo true
            hasReturnType { it.name == "Int" } shouldBeEqualTo false
            hasReturnTypeOf(SampleType::class) shouldBeEqualTo false
            hasReturnTypeOf(Int::class) shouldBeEqualTo false
        }
    }

    @Test
    fun `extension-function-return-type`() {
        // given
        val sut = getSnippetFile("extension-function-return-type")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            hasReturnType shouldBeEqualTo true
            returnType?.name shouldBeEqualTo "SampleType"
            hasReturnType() shouldBeEqualTo true
            hasReturnType { it.name == "SampleType" } shouldBeEqualTo true
            hasReturnType { it.name == "Int" } shouldBeEqualTo false
            hasReturnTypeOf(SampleType::class) shouldBeEqualTo true
            hasReturnTypeOf(Int::class) shouldBeEqualTo false
        }
    }

    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/kofunction/snippet/forkoreturntypeprovider/", fileName)
}
