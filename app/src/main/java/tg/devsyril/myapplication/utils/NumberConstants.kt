package tg.devsyril.myapplication.utils


sealed class NumberConstants(val value: Int) {
    data object MinFullNameLength: NumberConstants(2)
    data object MaxFullNameLength: NumberConstants(30)

    data object MinEmailLength: NumberConstants(6)
    data object MaxEmailLength: NumberConstants(60)

    data object MinPasswordLength: NumberConstants(6)
    data object MaxPasswordLength: NumberConstants(30)
}

sealed class StringConstants(val value: String) {
    data object DefaultOTPCode: StringConstants("0000")
}