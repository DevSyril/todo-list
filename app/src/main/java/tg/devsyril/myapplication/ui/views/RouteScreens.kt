package tg.devsyril.myapplication.ui.views


sealed class AuthRouteScreens(val path: String) {
    data object RegistrationScreen: AuthRouteScreens("registration")
    data object SignInScreen: AuthRouteScreens("sign-in")
    data object ForgottenPasswordScreen: AuthRouteScreens("forgotten-password")
    data object OTPCodeScreen: AuthRouteScreens("otp-code")
    data object NewPasswordPasswordScreen: AuthRouteScreens("new-password-password")
}

sealed class StartRouteScreens(val path: String) {
    data object StartScreen: StartRouteScreens("start")
}

sealed class MainRouteScreens(val path: String) {
    data object HomeScreen: AuthRouteScreens("home")
}