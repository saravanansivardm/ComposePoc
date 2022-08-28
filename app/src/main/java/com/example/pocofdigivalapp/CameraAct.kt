package com.example.pocofdigivalapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.camera_act_layout.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class CameraAct : AppCompatActivity() {
    private var photoFile: File? = null
    private var captureImageRequestCode = 1
    private var currentPhotoPath: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.camera_act_layout)
        captureImage()
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun captureImage() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                0
            )
        } else {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(packageManager) != null) {
                try {
                    photoFile = createImageFile()
                    if (photoFile != null) {
                        val photoURI = FileProvider.getUriForFile(
                            this,
                            "${getString(R.string.authority_string)}.provider", photoFile!!
                        )
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                        captureImageRequestCode = 1
                        onActivityResult.launch(photoURI)
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,
            ".jpg",
            storageDir
        )
        Log.e("image_path_log", image.absolutePath)
        currentPhotoPath = image.absolutePath
        return image
    }


    private var onActivityResult =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { result ->
            if (captureImageRequestCode == 1) {
                val myBitmap = BitmapFactory.decodeFile(photoFile!!.absolutePath)
                imageView.setImageBitmap(myBitmap)
            }
        }
}