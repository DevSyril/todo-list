package tg.devsyril.myapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import tg.devsyril.myapplication.R
import tg.devsyril.myapplication.ui.theme.MyApplicationTheme


@Composable
fun DefaultTextField(
    value: String = "",
    onValueChange: ((String) -> Unit) = { },
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String = "",
    placeHolder: String = "",
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    isError: Boolean = false,
    errorText: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },

    ) {
    var isFocused by rememberSaveable {
        mutableStateOf(false)
    }
            
    MyApplicationTheme {
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_1))
        ){
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                softWrap = true,
                maxLines = integerResource(id = R.integer.max_line_1)
            )

            if (isError) {
                Box (
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.size_2)))
                        .background(color = colorResource(id = R.color.danger))
                        .fillMaxWidth()
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.size_2),
                            vertical = dimensionResource(id = R.dimen.size_1)
                        )
                ){
                    Text(
                        text = errorText,
                        color = colorResource(id = R.color.white),
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = true,
                        maxLines = integerResource(id = R.integer.max_line_1)
                        )
                }
            }

            Row (
               verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.size_3)))
                    .fillMaxWidth()
                    .border(
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.size_3)),
                        width = dimensionResource(id = R.dimen.dp_1),
                        color = colorResource(
                            id =
                            if (isFocused)
                                R.color.input_border_focused
                            else
                                R.color.input_background
                        ),
                    )
            ){
                if (leadingIcon != null) {
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.size_3)))
                    Image(
                        painter = leadingIcon, 
                        contentDescription = null,
                        Modifier.size(dimensionResource(id = R.dimen.size_4))
                    )
                }
                
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    enabled = enabled,
                    readOnly = readOnly,
                    visualTransformation = visualTransformation,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    interactionSource = interactionSource,
                    textStyle = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .weight(1f)
                        .onFocusChanged {
                            isFocused = it.isFocused
                        }
                        .background(
                            color = colorResource(
                                id =
                                if (isFocused)
                                    R.color.background_color
                                else
                                    R.color.input_background
                            )
                        )
                        .padding(
                            vertical = dimensionResource(id = R.dimen.size_3),
                            horizontal = dimensionResource(id = R.dimen.size_4)
                        ),
                    decorationBox = { innnerTextfield ->
                        if (value.trim().isEmpty()) {
                            Text(
                                text = placeHolder,
                                style = MaterialTheme.typography.bodyMedium,
                                overflow = TextOverflow.Ellipsis,
                                softWrap = true,
                                maxLines = integerResource(id = R.integer.max_line_1)
                            )
                        }
                        innnerTextfield()
                    },
                )
                if (trailingIcon != null) {
                    Image(
                        painter = trailingIcon, 
                        contentDescription = null,
                        Modifier.size(
                            dimensionResource(id = R.dimen.size_4)
                        )
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.size_3)))
                }
            }
        }
    }
            
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultTextFieldPreview() {
    MyApplicationTheme {
        DefaultTextField(
            label = stringResource(id = R.string.full_name),
            placeHolder = stringResource(id = R.string.full_name_placeholder)
        )
    }
}