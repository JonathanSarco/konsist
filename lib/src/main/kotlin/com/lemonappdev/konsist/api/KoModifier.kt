package com.lemonappdev.konsist.api

enum class KoModifier(val type: String) {
    DATA("data"),
    VALUE("value"),
    INLINE("inline"),
    NOINLINE("noinline"),
    TAILREC("tailrec"),
    EXTERNAL("external"),
    ANNOTATION("annotation"),
    CROSSINLINE("crossinline"),
    OPERATOR("operator"),
    INFIX("infix"),
    ABSTRACT("abstract"),
    ENUM("enum"),
    CONTRACT("contract"),
    OPEN("open"),
    INNER("inner"),
    OVERRIDE("override"),
    PRIVATE("private"),
    PUBLIC("public"),
    DEFAULT_VISIBILITY_KEYWORD("public"),
    INTERNAL("internal"),
    PROTECTED("protected"),
    OUT("out"),
    VARARG("vararg"),
    REIFIED("reified"),
    COMPANION("companion"),
    SEALED("sealed"),
    FINAL("final"),
    LATEINIT("lateinit"),
    CONST("const"),
    SUSPEND("suspend"),
    EXPECT("expect"),
    ACTUAL("actual"),
}