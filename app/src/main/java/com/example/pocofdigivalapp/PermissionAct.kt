package com.example.pocofdigivalapp

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat

class PermissionAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
    }

    private fun hasWriteExternalStoragePermission() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForeGroundPermission() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationBackGroundPermission() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_BACKGROUND_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermission() {
        var permissioToRequest = mutableListOf<String>()
        if (!hasWriteExternalStoragePermission()) {
            permissioToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
    }
}