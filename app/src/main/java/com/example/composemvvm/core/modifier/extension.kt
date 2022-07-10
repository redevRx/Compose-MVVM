package com.example.composemvvm.core.modifier

import android.os.SystemClock
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role

fun Modifier.onClick(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit
) = composed(
    inspectorInfo = debugInspectorInfo {
        name = "clickable"
        properties["enabled"] = enabled
        properties["onClickLabel"] = onClickLabel
        properties["role"] = role
        properties["onClick"] = onClick
    }
) {
    var mLastClick = (0).toLong()

    if(SystemClock.elapsedRealtime() - mLastClick < 1000){
        Modifier.clickable(
            enabled = enabled,
            onClickLabel = onClickLabel,
            onClick =  {},
            role = role,
            indication = LocalIndication.current,
            interactionSource = remember { MutableInteractionSource() }
        )
    }else {
        mLastClick = SystemClock.elapsedRealtime()
        Modifier.clickable(
            enabled = enabled,
            onClickLabel = onClickLabel,
            onClick = onClick,
            role = role,
            indication = LocalIndication.current,
            interactionSource = remember { MutableInteractionSource() }
        )
    }
}

