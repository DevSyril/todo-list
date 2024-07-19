package tg.devsyril.myapplication.ui.views.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tg.devsyril.myapplication.R
import tg.devsyril.myapplication.ui.components.DefaultTextField
import tg.devsyril.myapplication.ui.theme.MyApplicationTheme
import tg.devsyril.myapplication.ui.views.AuthRouteScreens
import tg.devsyril.myapplication.ui.views.layout.BackTopAppBar


@Composable
fun SignIn(navController: NavController) {
    var email by rememberSaveable {
        mutableStateOf("")
    }

    MyApplicationTheme {
        Scaffold(
            topBar = {
                BackTopAppBar(navController = navController)
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_4)))

                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        space = dimensionResource(id = R.dimen.size_4)
                    ),
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                        .padding(horizontal = dimensionResource(id = R.dimen.size_8))
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = stringResource(id = R.string.signing_in),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = stringResource(id = R.string.signing_in_text),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodyMedium,
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_3))
                    ) {
                        DefaultTextField(
                            value = email,
                            onValueChange = {email = it},
                            label = stringResource(id = R.string.email),
                            placeHolder = stringResource(id = R.string.email_placeholder)
                        )

                        DefaultTextField(
                            value = email,
                            onValueChange = {email = it},
                            label = stringResource(id = R.string.password),
                            placeHolder = stringResource(id = R.string.password_placeholder)
                        )

                        Text(
                            text = stringResource(id = R.string.forgotten_password),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(AuthRouteScreens.ForgottenPasswordScreen.path)
                                }
                        )
                    }

                    Button(
                        onClick = {

                        },
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.size_3)),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = stringResource(id = R.string.signing_in))
                    }

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_1))
                    ){
                        Text(
                            text = stringResource(id = R.string.not_yet_registred),
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = stringResource(id = R.string.register),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .clickable {
                                    navController.popBackStack()
                                }
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInPreview() {
    MyApplicationTheme {
        SignIn(navController = rememberNavController())
    }
}