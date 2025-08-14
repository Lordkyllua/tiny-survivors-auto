package com.tinysurvivors

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class TinySurvivorsService : AccessibilityService() {
    override fun onServiceConnected() {
        // Configuración inicial del servicio
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val rootNode = rootInActiveWindow ?: return
        
        // Detectar y clickear "Reclamar"
        val claimButton = rootNode.findAccessibilityNodeInfoByText("Reclamar")
        if (claimButton != null && claimButton.isEnabled) {
            claimButton.performAction(AccessibilityNodeInfo.ACTION_CLICK)
        }

        // Detectar y clickear "Atacar"
        val attackButton = rootNode.findAccessibilityNodeInfoByText("Atacar")
        if (attackButton != null && attackButton.isEnabled) {
            attackButton.performAction(AccessibilityNodeInfo.ACTION_CLICK)
        }
    }

    override fun onInterrupt() {
        // Limpiar recursos al detener el servicio
    }
}