package com.lemonappdev.konsist.core.declaration.koinitblockdeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoInitBlockDeclarationForKoPathProviderTest {
    @Test
    fun `init-block-file-path`() {
        // given
        val sut = getSnippetFile("init-block-file-path")
            .classes()
            .first()
            .initBlocks
            ?.first()

        // then
        assertSoftly {
            sut?.path?.startsWith("//") shouldBeEqualTo false
            sut?.path?.endsWith("koinitblockdeclaration/snippet/forkopathprovider/init-block-file-path.kt") shouldBeEqualTo true
        }
    }

    @Test
    fun `init-block-project-file-path`() {
        // given
        val sut = getSnippetFile("init-block-project-file-path")
            .classes()
            .first()
            .initBlocks
            ?.first()

        // then
        sut
            ?.projectPath
            .shouldBeEqualTo(
                "/lib/src/integrationTest/kotlin/com/lemonappdev/konsist/core/declaration/koinitblockdeclaration/snippet/" +
                    "forkopathprovider/init-block-project-file-path.kt",
            )
    }

    @Test
    fun `init-block-reside-in-file-path`() {
        // given
        val sut = getSnippetFile("init-block-reside-in-file-path")
            .classes()
            .first()
            .initBlocks
            ?.first()

        // then
        assertSoftly {
            sut?.resideInPath("..snippet..", true) shouldBeEqualTo true
            sut?.resideInPath("..koinitblockdeclaration/snippet..", true) shouldBeEqualTo true
            sut?.resideInPath("..koinitblockdeclaration..init-block-reside-in-file-path.kt", true) shouldBeEqualTo true
            sut?.resideInPath("koinitblockdeclaration/snippet/", true) shouldBeEqualTo false
        }
    }

    @Test
    fun `init-block-reside-in-project-file-path`() {
        // given
        val sut = getSnippetFile("init-block-reside-in-project-file-path")
            .classes()
            .first()
            .initBlocks
            ?.first()

        // then
        assertSoftly {
            sut?.resideInPath("..snippet..", false) shouldBeEqualTo true
            sut?.resideInPath("..koinitblockdeclaration/snippet..", false) shouldBeEqualTo true
            sut?.resideInPath("..koinitblockdeclaration..init-block-reside-in-project-file-path.kt", false) shouldBeEqualTo true
            sut?.resideInPath("koinitblockdeclaration/snippet/", false) shouldBeEqualTo false
        }
    }

    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/koinitblockdeclaration/snippet/forkopathprovider/", fileName)
}