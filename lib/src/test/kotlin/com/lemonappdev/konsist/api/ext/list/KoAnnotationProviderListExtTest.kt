package com.lemonappdev.konsist.api.ext.list

import com.lemonappdev.konsist.api.declaration.KoAnnotationDeclaration
import com.lemonappdev.konsist.api.provider.KoAnnotationProvider
import com.lemonappdev.konsist.testdata.SampleAnnotation1
import com.lemonappdev.konsist.testdata.SampleAnnotation2
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoAnnotationProviderListExtTest {
    @Test
    fun `annotations returns annotations from all declarations`() {
        // given
        val annotation1: KoAnnotationDeclaration = mockk()
        val annotation2: KoAnnotationDeclaration = mockk()
        val annotation3: KoAnnotationDeclaration = mockk()
        val declaration1: KoAnnotationProvider = mockk {
            every { annotations } returns listOf(annotation1, annotation2)
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { annotations } returns listOf(annotation3)
        }
        val declaration3: KoAnnotationProvider = mockk {
            every { annotations } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.annotations

        // then
        sut shouldBeEqualTo listOf(annotation1, annotation2, annotation3)
    }

    @Test
    fun `withAnnotations() returns declaration with any annotation`() {
        // given
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotations() } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotations() } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAnnotations()

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAnnotations() returns declaration without any annotation`() {
        // given
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotations() } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotations() } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAnnotations()

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAnnotationNamed(name) returns declaration with given annotation`() {
        // given
        val name = "SampleName"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationWithName(name) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationWithName(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAnnotationNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withAnnotationNamed(String) returns declaration with any of given annotations`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationWithName(name1, name2) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationWithName(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAnnotationNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAnnotationNamed(name) returns declaration without given annotation`() {
        // given
        val name = "SampleName"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationWithName(name) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationWithName(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAnnotationNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutAnnotationNamed(String) returns declaration without any of given annotations`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationWithName(name1, name2) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationWithName(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAnnotationNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllAnnotationsNamed(name) returns declaration with given annotation`() {
        // given
        val name = "SampleName"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationsWithAllNames(name) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationsWithAllNames(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllAnnotationsNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withAllAnnotationsNamed(String) returns declaration with all given annotations`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationsWithAllNames(name1, name2) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationsWithAllNames(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllAnnotationsNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllAnnotationsNamed(name) returns declaration without given annotation`() {
        // given
        val name = "SampleName"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationsWithAllNames(name) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationsWithAllNames(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllAnnotationsNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutAllAnnotationsNamed(String) returns declaration without all of given annotations`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationsWithAllNames(name1, name2) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationsWithAllNames(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllAnnotationsNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAnnotation{} returns declaration with annotation which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoAnnotationDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotation(predicate) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotation(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAnnotation(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAnnotation{} returns declaration without annotation which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoAnnotationDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotation(predicate) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotation(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAnnotation(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllAnnotations{} returns declaration with all annotations satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoAnnotationDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAllAnnotations(predicate) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAllAnnotations(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllAnnotations(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllAnnotations{} returns declaration with all annotations which not satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoAnnotationDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAllAnnotations(predicate) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAllAnnotations(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllAnnotations(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAnnotations{} returns declaration with annotations which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (List<KoAnnotationDeclaration>) -> Boolean =
            { it.all { annotation -> annotation.hasNameEndingWith(suffix) } }
        val annotation1: KoAnnotationDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns true
        }
        val annotation2: KoAnnotationDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns false
        }
        val declaration1: KoAnnotationProvider = mockk {
            every { annotations } returns listOf(annotation1)
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { annotations } returns listOf(annotation2)
        }
        val declaration3: KoAnnotationProvider = mockk {
            every { annotations } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withAnnotations(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1, declaration3)
    }

    @Test
    fun `withoutAnnotations{} returns declaration without annotations which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (List<KoAnnotationDeclaration>) -> Boolean =
            { it.all { annotation -> annotation.hasNameEndingWith(suffix) } }
        val annotation1: KoAnnotationDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns true
        }
        val annotation2: KoAnnotationDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns false
        }
        val declaration1: KoAnnotationProvider = mockk {
            every { annotations } returns listOf(annotation1)
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { annotations } returns listOf(annotation2)
        }
        val declaration3: KoAnnotationProvider = mockk {
            every { annotations } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withoutAnnotations(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAnnotationOf(KClass) returns declaration with any of given annotations`() {
        // given
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationOf(SampleAnnotation1::class, SampleAnnotation2::class) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationOf(SampleAnnotation1::class, SampleAnnotation2::class) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAnnotationOf(SampleAnnotation1::class, SampleAnnotation2::class)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAnnotationOf(KClass) returns declaration without all of given annotations`() {
        // given
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationOf(SampleAnnotation1::class, SampleAnnotation2::class) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationOf(SampleAnnotation1::class, SampleAnnotation2::class) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAnnotationOf(SampleAnnotation1::class, SampleAnnotation2::class)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllAnnotationsOf(KClass) returns declaration with all of given annotations`() {
        // given
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAllAnnotationsOf(SampleAnnotation1::class, SampleAnnotation2::class) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAllAnnotationsOf(SampleAnnotation1::class, SampleAnnotation2::class) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllAnnotationsOf(SampleAnnotation1::class, SampleAnnotation2::class)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllAnnotationsOf(KClass) returns declaration without any of given annotations`() {
        // given
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAllAnnotationsOf(SampleAnnotation1::class, SampleAnnotation2::class) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAllAnnotationsOf(SampleAnnotation1::class, SampleAnnotation2::class) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllAnnotationsOf(SampleAnnotation1::class, SampleAnnotation2::class)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllAnnotations(String) returns declaration with all of given annotations`() {
        // given
        val annotation1 = "SampleAnnotation1"
        val annotation2 = "SampleAnnotation2"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1, annotation2) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1, annotation2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllAnnotations(annotation1, annotation2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllAnnotations(String) returns declaration without any of given annotations`() {
        // given
        val annotation1 = "SampleAnnotation1"
        val annotation2 = "SampleAnnotation2"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1, annotation2) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1, annotation2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllAnnotations(annotation1, annotation2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withSomeAnnotations(String) returns declaration with given annotation`() {
        // given
        val annotation = "SampleAnnotation"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withSomeAnnotations(annotation)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withSomeAnnotations(String) returns declarations with at least one of given annotations`() {
        // given
        val annotation1 = "SampleAnnotation1"
        val annotation2 = "SampleAnnotation2"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1) } returns true
            every { hasAnnotations(annotation2) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1) } returns false
            every { hasAnnotations(annotation2) } returns true
        }
        val declaration3: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1) } returns false
            every { hasAnnotations(annotation2) } returns false
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withSomeAnnotations(annotation1, annotation2)

        // then
        sut shouldBeEqualTo listOf(declaration1, declaration2)
    }

    @Test
    fun `withoutSomeAnnotations(String) returns declaration without given annotation`() {
        // given
        val annotation = "SampleAnnotation"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutSomeAnnotations(annotation)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutSomeAnnotations(String) returns declarations with at least one of given annotations`() {
        // given
        val annotation1 = "SampleAnnotation1"
        val annotation2 = "SampleAnnotation2"
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1) } returns true
            every { hasAnnotations(annotation2) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1) } returns false
            every { hasAnnotations(annotation2) } returns true
        }
        val declaration3: KoAnnotationProvider = mockk {
            every { hasAnnotations(annotation1) } returns false
            every { hasAnnotations(annotation2) } returns false
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withoutSomeAnnotations(annotation1, annotation2)

        // then
        sut shouldBeEqualTo listOf(declaration3)
    }

    @Test
    fun `withSomeAnnotationsOf(KClass) returns declarations with at least one of given annotations`() {
        // given
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationsOf(SampleAnnotation1::class) } returns true
            every { hasAnnotationsOf(SampleAnnotation2::class) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationsOf(SampleAnnotation1::class) } returns true
            every { hasAnnotationsOf(SampleAnnotation2::class) } returns false
        }
        val declaration3: KoAnnotationProvider = mockk {
            every { hasAnnotationsOf(SampleAnnotation1::class) } returns false
            every { hasAnnotationsOf(SampleAnnotation2::class) } returns false
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withSomeAnnotationsOf(SampleAnnotation1::class, SampleAnnotation2::class)

        // then
        sut shouldBeEqualTo listOf(declaration1, declaration2)
    }

    @Test
    fun `withoutSomeAnnotationsOf(KClass) returns declarations without at least one of given annotations`() {
        // given
        val declaration1: KoAnnotationProvider = mockk {
            every { hasAnnotationsOf(SampleAnnotation1::class) } returns true
            every { hasAnnotationsOf(SampleAnnotation2::class) } returns true
        }
        val declaration2: KoAnnotationProvider = mockk {
            every { hasAnnotationsOf(SampleAnnotation1::class) } returns true
            every { hasAnnotationsOf(SampleAnnotation2::class) } returns false
        }
        val declaration3: KoAnnotationProvider = mockk {
            every { hasAnnotationsOf(SampleAnnotation1::class) } returns false
            every { hasAnnotationsOf(SampleAnnotation2::class) } returns false
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withoutSomeAnnotationsOf(SampleAnnotation1::class, SampleAnnotation2::class)

        // then
        sut shouldBeEqualTo listOf(declaration3)
    }
}
