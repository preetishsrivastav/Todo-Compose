package com.example.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.example.todocompose.ui.theme.HighPriorityColor
import com.example.todocompose.ui.theme.LowPriorityColor
import com.example.todocompose.ui.theme.MediumPriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(Color.Transparent)
}