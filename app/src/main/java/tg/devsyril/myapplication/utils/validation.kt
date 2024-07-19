package tg.devsyril.myapplication.utils

fun fullNameLengthValidation(fullname: String): Boolean {
    return fullname.length >= NumberConstants.MinFullNameLength.value && fullname.length <= NumberConstants.MaxFullNameLength.value
}

fun emailLengthValidation(email: String): Boolean {
    return email.length >= NumberConstants.MinEmailLength.value && email.length <= NumberConstants.MaxEmailLength.value
}

fun passwordLengthValidation(password: String): Boolean {
    return password.length >= NumberConstants.MinPasswordLength.value && password.length <= NumberConstants.MaxPasswordLength.value
}