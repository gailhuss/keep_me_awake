package com.example.keepmeawake

import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService


class KeepMeAwakeTileService : TileService() {

    private var enabled: Boolean = false

    override fun onStartListening() {
        qsTile.icon = Icon.createWithResource(this, R.drawable.ic_keep_on)
        qsTile.label = "Keep Me Awake"
        updateIcon()
    }

    override fun onClick() {
        this.enabled = !this.enabled
        updateIcon()
    }

    private fun updateIcon() {
        qsTile.state = if (this.enabled) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
        qsTile.updateTile()
    }
}