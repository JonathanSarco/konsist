package com.sample

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAllAnnotationsOf
import com.lemonappdev.konsist.api.verify.assert
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.SpringBootApplication

class SampleKonsistTest {
    @Test
    fun `spring application class name ends with 'SpringBootApplication'`() {
        Konsist
            .scopeFromProject()
            .classes()
            .withAllAnnotationsOf(SpringBootApplication::class)
            .assert { it.name.endsWith("SpringBootApplication") }
    }
}
