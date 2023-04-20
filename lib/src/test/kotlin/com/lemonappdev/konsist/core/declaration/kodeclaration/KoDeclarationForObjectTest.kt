package com.lemonappdev.konsist.core.declaration.kodeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import com.lemonappdev.konsist.core.const.KoModifier.DATA
import com.lemonappdev.konsist.core.const.KoModifier.PRIVATE
import com.lemonappdev.konsist.core.const.KoModifier.PROTECTED
import com.lemonappdev.konsist.core.const.KoModifier.PUBLIC
import com.lemonappdev.konsist.testdata.NonExistingAnnotation
import com.lemonappdev.konsist.testdata.SampleAnnotation
import com.lemonappdev.konsist.testdata.SampleAnnotation1
import com.lemonappdev.konsist.testdata.SampleAnnotation2
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldHaveSize
import org.junit.jupiter.api.Test

class KoDeclarationForObjectTest {
    @Test
    fun `object-is-top-level`() {
        // given
        val sut = getSnippetFile("object-is-top-level")
            .objects(includeNested = true)
            .first()

        // then
        sut.isTopLevel() shouldBeEqualTo true
    }

    @Test
    fun `object-is-not-top-level`() {
        // given
        val sut = getSnippetFile("object-is-not-top-level")
            .objects(includeNested = true)
            .first { it.name == "SampleNestedObject" }

        // then
        sut.isTopLevel() shouldBeEqualTo false
    }

    @Test
    fun `object-has-no-annotation`() {
        // given
        val sut = getSnippetFile("object-has-no-annotation")
            .objects()
            .first()

        // then
        sut.annotations shouldHaveSize 0
    }

    @Test
    fun `object-has-annotation`() {
        // given
        val sut = getSnippetFile("object-has-annotation")
            .objects()
            .first()

        // then
        sut.run {
            annotations shouldHaveSize 1
            hasAnnotation("SampleAnnotation") shouldBeEqualTo true
            hasAnnotation("NonExistingAnnotation") shouldBeEqualTo false
            hasAnnotation("com.lemonappdev.konsist.testdata.SampleAnnotation") shouldBeEqualTo true
            hasAnnotation("com.lemonappdev.konsist.testdata.NonExistingAnnotation") shouldBeEqualTo false
            hasAnnotation<SampleAnnotation>() shouldBeEqualTo true
            hasAnnotation<NonExistingAnnotation>() shouldBeEqualTo false
        }
    }

    @Test
    fun `object-has-two-annotations`() {
        // given
        val sut = getSnippetFile("object-has-two-annotations")
            .objects()
            .first()

        // then
        sut.run {
            annotations shouldHaveSize 2
            hasAnnotation("SampleAnnotation1") shouldBeEqualTo true
            hasAnnotation("SampleAnnotation2") shouldBeEqualTo true
            hasAnnotation("NonExistingAnnotation") shouldBeEqualTo false
            hasAnnotation("com.lemonappdev.konsist.testdata.SampleAnnotation1") shouldBeEqualTo true
            hasAnnotation("com.lemonappdev.konsist.testdata.SampleAnnotation2") shouldBeEqualTo true
            hasAnnotation("com.lemonappdev.konsist.testdata.NonExistingAnnotation") shouldBeEqualTo false
            hasAnnotation<SampleAnnotation1>() shouldBeEqualTo true
            hasAnnotation<SampleAnnotation2>() shouldBeEqualTo true
            hasAnnotation<NonExistingAnnotation>() shouldBeEqualTo false
        }
    }

    @Test
    fun `object-has-no-visibility-modifier`() {
        // given
        val sut = getSnippetFile("object-has-no-visibility-modifier")
            .objects()
            .first()

        // then
        sut.run {
            isPublicOrDefault() shouldBeEqualTo true
            hasPublicModifier() shouldBeEqualTo false
            hasPrivateModifier() shouldBeEqualTo false
            hasProtectedModifier() shouldBeEqualTo false
            hasInternalModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `object-has-public-visibility-modifier`() {
        // given
        val sut = getSnippetFile("object-has-public-visibility-modifier")
            .objects()
            .first()

        // then
        sut.run {
            isPublicOrDefault() shouldBeEqualTo true
            hasPublicModifier() shouldBeEqualTo true
            hasPrivateModifier() shouldBeEqualTo false
            hasProtectedModifier() shouldBeEqualTo false
            hasInternalModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `object-has-private-visibility-modifier`() {
        // given
        val sut = getSnippetFile("object-has-private-visibility-modifier")
            .objects()
            .first()

        // then
        sut.run {
            isPublicOrDefault() shouldBeEqualTo false
            hasPublicModifier() shouldBeEqualTo false
            hasPrivateModifier() shouldBeEqualTo true
            hasProtectedModifier() shouldBeEqualTo false
            hasInternalModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `object-has-protected-visibility-modifier`() {
        // given
        val sut = getSnippetFile("object-has-protected-visibility-modifier")
            .objects()
            .first()

        // then
        sut.run {
            isPublicOrDefault() shouldBeEqualTo false
            hasPublicModifier() shouldBeEqualTo false
            hasPrivateModifier() shouldBeEqualTo false
            hasProtectedModifier() shouldBeEqualTo true
            hasInternalModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `object-has-internal-visibility-modifier`() {
        // given
        val sut = getSnippetFile("object-has-internal-visibility-modifier")
            .objects()
            .first()

        // then
        sut.run {
            isPublicOrDefault() shouldBeEqualTo false
            hasPublicModifier() shouldBeEqualTo false
            hasPrivateModifier() shouldBeEqualTo false
            hasProtectedModifier() shouldBeEqualTo false
            hasInternalModifier() shouldBeEqualTo true
        }
    }

    @Test
    fun `object-has-fully-qualified-name`() {
        // given
        val sut = getSnippetFile("object-has-fully-qualified-name")
            .objects()
            .first()

        // then
        sut.fullyQualifiedName shouldBeEqualTo "com.samplepackage.SampleObject"
    }

    @Test
    fun `object-is-in-package`() {
        // given
        val sut = getSnippetFile("object-is-in-package")
            .objects()
            .first()

        // then
        sut.packageName shouldBeEqualTo "com.samplepackage"
    }

    @Test
    fun `object-is-not-in-package`() {
        // given
        val sut = getSnippetFile("object-is-not-in-package")
            .objects()
            .first()

        // then
        sut.packageName shouldBeEqualTo ""
    }

    @Test
    fun `object-has-protected-modifier`() {
        // given
        val sut = getSnippetFile("object-has-protected-modifier")
            .objects()
            .first()

        // then
        sut.hasModifiers() shouldBeEqualTo true
    }

    @Test
    fun `object-has-public-modifier`() {
        // given
        val sut = getSnippetFile("object-has-public-modifier")
            .objects()
            .first()

        // then
        sut.run {
            hasModifiers(PUBLIC) shouldBeEqualTo true
            hasModifiers(PRIVATE) shouldBeEqualTo false
        }
    }

    @Test
    fun `object-has-two-modifiers`() {
        // given
        val sut = getSnippetFile("object-has-two-modifiers")
            .objects()
            .first()

        // then
        sut.run {
            hasModifiers(PRIVATE) shouldBeEqualTo true
            hasModifiers(DATA) shouldBeEqualTo true
            hasModifiers(PROTECTED) shouldBeEqualTo false
            hasModifiers(PRIVATE, DATA) shouldBeEqualTo true
            hasModifiers(DATA, PRIVATE) shouldBeEqualTo true
            hasModifiers(PROTECTED, DATA) shouldBeEqualTo false
            hasModifiers(PROTECTED, DATA, PRIVATE) shouldBeEqualTo false
            hasModifiers() shouldBeEqualTo true
        }
    }

    @Test
    fun `object-has-no-modifier`() {
        // given
        val sut = getSnippetFile("object-has-no-modifiers")
            .objects()
            .first()

        // then
        sut.run {
            hasModifiers() shouldBeEqualTo true
            hasModifiers(PRIVATE) shouldBeEqualTo false
        }
    }

    private fun
    getSnippetFile(fileName: String) = getSnippetKoScope("core/declaration/kodeclaration/snippet/forobject/", fileName)
}