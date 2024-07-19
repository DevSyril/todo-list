package tg.devsyril.myapplication.ui.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tg.devsyril.myapplication.Start
import tg.devsyril.myapplication.ui.views.screens.authentication.ForgottenPassword
import tg.devsyril.myapplication.ui.views.screens.authentication.NewPassword
import tg.devsyril.myapplication.ui.views.screens.authentication.OTPCode
import tg.devsyril.myapplication.ui.views.screens.authentication.Registration
import tg.devsyril.myapplication.ui.views.screens.authentication.SignIn
import tg.devsyril.myapplication.ui.views.screens.user.Home


@Composable
fun Navigation(
    startDestination: String = StartRouteScreens.StartScreen.path
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = StartRouteScreens.StartScreen.path) {
            Start(navController = navController)
        }

        composable(route = AuthRouteScreens.RegistrationScreen.path) {
            Registration(navController = navController)
        }

        composable(route = AuthRouteScreens.SignInScreen.path) {
            SignIn(navController = navController)
        }

        composable(route = AuthRouteScreens.ForgottenPasswordScreen.path) {
            ForgottenPassword(navController = navController)
        }

        composable(route = AuthRouteScreens.OTPCodeScreen.path + "/{email}", arguments = listOf(
            navArgument(name = "email") {
                type = NavType.StringType
            }
        )) {
            OTPCode(navController = navController, email = it.arguments?.getString("email")!!)
        }
        composable(route = AuthRouteScreens.NewPasswordPasswordScreen.path) {
            NewPassword(navController = navController)
        }

        composable(route = MainRouteScreens.HomeScreen.path) {
            Home(navController = navController)
        }
    }
}