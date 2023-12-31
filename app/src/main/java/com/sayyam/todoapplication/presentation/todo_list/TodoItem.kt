package com.sayyam.todoapplication.presentation.todo_list

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sayyam.todoapplication.data.model.Todo

@Composable
fun TodoItem(
    todo: Todo,
    onEvent: (TodoListEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            ),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(20.dp),
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = todo.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                todo.description?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = it)
                }
            }
            Column(

            ) {
                IconButton(onClick = {
                    onEvent(TodoListEvent.OnDeleteTodoClick(todo))
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
                Checkbox(
                    checked = todo.isDone,
                    onCheckedChange = { isChecked ->
                        onEvent(TodoListEvent.OnDoneChange(todo, isChecked))
                    }
                )
            }
        }
    }
}