package com.karimsinouh.national.ui.nationalExams

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.karimsinouh.national.R
import com.karimsinouh.national.data.NationalExam

@Composable
fun ExamItem(
    exam:NationalExam,
    onClick:(normal:Boolean)->Unit,
) {
    
    var expanded by remember{
        mutableStateOf(false)
    }

    val background=if (expanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface

    val contentColor= if (expanded) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSurface

    Card {

        Column(Modifier.background(background)) {

            Row(
                modifier = Modifier
                    .clickable {
                        expanded = !expanded
                    }
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = exam.name,
                    modifier = Modifier.weight(0.9f),
                    color = contentColor,
                    textAlign = TextAlign.Right
                )

                val icon=if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

                IconButton(onClick = { expanded= !expanded }) {
                    Icon(imageVector = icon, contentDescription = null, tint = contentColor)
                }

            }

            AnimatedVisibility(visible = expanded) {
                Column {

                    Divider(color = contentColor.copy(alpha = 0.5f))

                    exam.normal?.let {
                        Text(
                            text = stringResource(id = R.string.normal),
                            modifier = Modifier
                                .clickable { onClick(true) }
                                .padding(12.dp)
                                .fillMaxWidth(),
                            color = contentColor,
                            textAlign = TextAlign.Right
                        )
                    }

                    exam.rattrapage?.let{
                        Divider(color = contentColor.copy(alpha = 0.5f))

                        Text(
                            text = stringResource(id = R.string.rattrapage),
                            modifier = Modifier
                                .clickable { onClick(false) }
                                .padding(12.dp)
                                .fillMaxWidth(),
                            color = contentColor,
                            textAlign = TextAlign.Right
                        )
                    }

                }
            }

        }

    }

}