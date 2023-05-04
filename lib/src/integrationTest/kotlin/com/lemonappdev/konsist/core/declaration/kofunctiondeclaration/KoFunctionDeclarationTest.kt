package com.lemonappdev.konsist.core.declaration.kofunctiondeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoFunctionDeclarationTest {
    @Test
    fun `function-has-operator-modifier`() {
        // given
        val sut = getSnippetFile("function-has-operator-modifier")
            .functions()
            .first()

        // then
        sut.hasOperatorModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-inline-modifier`() {
        // given
        val sut = getSnippetFile("function-has-inline-modifier")
            .functions()
            .first()

        // then
        sut.hasInlineModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-tailrec-modifier`() {
        // given
        val sut = getSnippetFile("function-has-tailrec-modifier")
            .functions()
            .first()

        // then
        sut.hasTailrecModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-infix-modifier`() {
        // given
        val sut = getSnippetFile("function-has-infix-modifier")
            .functions()
            .first()

        // then
        sut.hasInfixModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-external-modifier`() {
        // given
        val sut = getSnippetFile("function-has-external-modifier")
            .functions()
            .first()

        // then
        sut.hasExternalModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-suspend-modifier`() {
        // given
        val sut = getSnippetFile("function-has-suspend-modifier")
            .functions()
            .first()

        // then
        sut.hasSuspendModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-open-modifier`() {
        // given
        val sut = getSnippetFile("function-has-open-modifier")
            .functions(includeNested = true)
            .first()

        // then
        sut.hasOpenModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-override-modifier`() {
        // given
        val sut = getSnippetFile("function-has-override-modifier")
            .functions(includeNested = true)
            .first()

        // then
        sut.hasOverrideModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-final-modifier`() {
        // given
        val sut = getSnippetFile("function-has-final-modifier")
            .functions(includeNested = true)
            .first()

        // then
        sut.hasFinalModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-abstract-modifier`() {
        // given
        val sut = getSnippetFile("function-has-abstract-modifier")
            .functions(includeNested = true)
            .first()

        // then
        sut.hasAbstractModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-actual-modifier`() {
        // given
        val sut = getSnippetFile("function-has-actual-modifier")
            .functions(includeNested = true)
            .first()

        // then
        sut.hasActualModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-expect-modifier`() {
        // given
        val sut = getSnippetFile("function-has-expect-modifier")
            .functions()
            .first()

        // then
        sut.hasExpectModifier() shouldBeEqualTo true
    }

    @Test
    fun `function-has-no-modifiers`() {
        // given
        val sut = getSnippetFile("function-has-no-modifiers")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            hasOperatorModifier() shouldBeEqualTo false
            hasInlineModifier() shouldBeEqualTo false
            hasTailrecModifier() shouldBeEqualTo false
            hasInfixModifier() shouldBeEqualTo false
            hasExternalModifier() shouldBeEqualTo false
            hasSuspendModifier() shouldBeEqualTo false
            hasOpenModifier() shouldBeEqualTo false
            hasOverrideModifier() shouldBeEqualTo false
            hasFinalModifier() shouldBeEqualTo false
            hasAbstractModifier() shouldBeEqualTo false
            hasActualModifier() shouldBeEqualTo false
            hasExpectModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `function-is-extension`() {
        // given
        val sut = getSnippetFile("function-is-extension")
            .functions()
            .first()

        // then
        sut.isExtension() shouldBeEqualTo true
    }

    @Test
    fun `function-is-not-extension`() {
        // given
        val sut = getSnippetFile("function-is-not-extension")
            .functions()
            .first()

        // then
        sut.isExtension() shouldBeEqualTo false
    }

    @Test
    fun `function-return-type`() {
        // given
        val sut = getSnippetFile("function-return-type")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            hasReturnType() shouldBeEqualTo true
            returnType?.sourceType shouldBeEqualTo "SampleType"
            returnType?.importAliasName shouldBeEqualTo ""
            returnType?.name shouldBeEqualTo "SampleType"
            returnType?.isImportAlias() shouldBeEqualTo false
            returnType?.fullyQualifiedName shouldBeEqualTo "com.lemonappdev.konsist.testdata.SampleType"
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
            hasReturnType() shouldBeEqualTo true
            returnType?.sourceType shouldBeEqualTo "SampleType"
            returnType?.importAliasName shouldBeEqualTo "ImportAlias"
            returnType?.name shouldBeEqualTo "ImportAlias"
            returnType?.isImportAlias() shouldBeEqualTo true
        }
    }

    @Test
    fun `function-not-return-type`() {
        // given
        val sut = getSnippetFile("function-not-return-type")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            hasReturnType() shouldBeEqualTo false
            returnType?.sourceType shouldBeEqualTo null
            returnType?.importAliasName shouldBeEqualTo null
            returnType?.name shouldBeEqualTo null
            returnType?.isImportAlias() shouldBeEqualTo null
        }
    }

    @Test
    fun `function-contains-local-property`() {
        // given
        val sut = getSnippetFile("function-contains-local-property")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            containsLocalProperty("sampleLocalProperty") shouldBeEqualTo true
            localProperties()
                .toList()
                .map { it.name }
                .shouldBeEqualTo(listOf("sampleLocalProperty"))
        }
    }

    @Test
    fun `function-contains-local-function`() {
        // given
        val sut = getSnippetFile("function-contains-local-function")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            containsLocalFunction("sampleLocalFunction") shouldBeEqualTo true
            localFunctions()
                .toList()
                .map { it.name }
                .shouldBeEqualTo(listOf("sampleLocalFunction"))
        }
    }

    @Test
    fun `function-contains-local-class`() {
        // given
        val sut = getSnippetFile("function-contains-local-class")
            .functions()
            .first()

        // then
        assertSoftly(sut) {
            containsLocalClass("SampleClass") shouldBeEqualTo true
            localClasses()
                .toList()
                .map { it.name }
                .shouldBeEqualTo(listOf("SampleClass"))
        }
    }

    @Test
    fun `function-contains-local-declarations`() {
        // given
        val sut = getSnippetFile("function-contains-local-declarations")
            .functions()
            .first()

        // then
        sut
            .localDeclarations()
            .toList()
            .map { it.name }
            .shouldBeEqualTo(
                listOf(
                    "sampleLocalProperty",
                    "sampleLocalFunction",
                    "SampleNestedClass",
                ),
            )
    }

    private fun getSnippetFile(fileName: String) = getSnippetKoScope("core/declaration/kofunctiondeclaration/snippet/", fileName)
}