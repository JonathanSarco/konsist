package com.lemonappdev.konsist.api.provider

import com.lemonappdev.konsist.api.declaration.KoImportDeclaration

/**
 * An interface representing a Kotlin declaration that provides access to import declarations.
 */
interface KoImportProvider : KoBaseProvider {
    /**
     * List of imports.
     */
    val imports: List<KoImportDeclaration>

    /**
     * The number of imports.
     */
    val numImports: Int

    /**
     * Gets the number of imports that satisfies the specified predicate present in the declaration.
     *
     * @param predicate The predicate function to determine if an import satisfies a condition.
     * @return The number of imports in the declaration.
     */
    fun countImports(predicate: (KoImportDeclaration) -> Boolean): Int

    /**
     * Whether the declaration has imports.
     *
     * @param names the names of the imports to check.
     * @return `true` if the declaration has imports with the specified names (or any import if [names] is empty), `false` otherwise.
     */
    @Deprecated(
        """
            Will be removed in v1.0.0. 
            If you passed one argument - replace with `hasImportWithName`, otherwise with `hasImportsWithAllNames`.
            """,
    )
    fun hasImports(vararg names: String): Boolean

    /**
     * Whether the declaration has any import.
     *
     * @return `true` if the declaration has any import, `false` otherwise.
     */
    fun hasImports(): Boolean

    /**
     * Determines whether the declaration has at least one import whose name matches any of the specified names.
     *
     * @param name the name of the import to check.
     * @param names the names of the imports to check.
     * @return `true` if there is a matching declaration, `false` otherwise.
     */
    fun hasImportWithName(name: String, vararg names: String): Boolean

    /**
     * Determines whether the declaration has imports with all the specified names.
     *
     * @param name The name of the import to check.
     * @param names The names of the imports to check.
     * @return `true` if there are declarations with all the specified names, `false` otherwise.
     */
    fun hasImportsWithAllNames(name: String, vararg names: String): Boolean

    /**
     * Whether the declaration has any import with the specified predicate.
     *
     * @param predicate The predicate function to determine if an import satisfies a condition.
     * @return `true` if the declaration has imports with the specified predicate, `false` otherwise.
     */
    fun hasImport(predicate: (KoImportDeclaration) -> Boolean): Boolean

    /**
     * Whether the declaration has all imports with the specified predicate.
     *
     * Note that if the imports contains no elements, the function returns `true` because there are no elements in it
     * that do not match the predicate. See a more detailed explanation of this logic concept in
     * ["Vacuous truth"](https://en.wikipedia.org/wiki/Vacuous_truth) article.
     *
     * @param predicate The predicate function to determine if an import satisfies a condition.
     * @return `true` if the declaration has all imports with the specified predicate, `false` otherwise.
     */
    fun hasAllImports(predicate: (KoImportDeclaration) -> Boolean): Boolean
}
