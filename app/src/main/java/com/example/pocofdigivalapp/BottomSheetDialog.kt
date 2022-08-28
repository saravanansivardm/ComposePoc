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
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.pocofdigivalapp.dashboard.home.DashBoardRating
import com.example.pocofdigivalapp.forgotpassword.ForgotPasswordAct
import com.example.pocofdigivalapp.ui.theme.PrimaryColor01
import com.example.pocofdigivalapp.ui.theme.PrimaryColor02
import kotlinx.android.synthetic.main.camera_act_layout.*
import kotlinx.coroutines.launch
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalMaterialApi
class BottomSheetDialog : ComponentActivity() {
    private val permissionCode = 1001
    private var imageRequestCode = 1

    private var photoFile: File? = null
    private var captureImageRequestCode = 1
    private var currentPhotoPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sheetState = rememberBottomSheetState(
                initialValue = BottomSheetValue.Collapsed
            )
            val scaffoldState = rememberBottomSheetScaffoldState(
                bottomSheetState = sheetState
            )
            val scope = rememberCoroutineScope()
            BottomSheetScaffold(
                scaffoldState = scaffoldState,
                sheetContent = {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        backgroundColor = colorResource(R.color.white),
                        shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier,
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.add_new_documents),
                                    modifier = Modifier
                                        .padding(start = 16.dp)
                                        .width(340.dp),
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = colorResource(id = R.color.txt_color),
                                )
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Toggle drawer",
                                        modifier = Modifier.size(20.dp),
                                        tint = colorResource(id = R.color.close_icon_color)
                                    )
                                }
                            }
                            Divider(
                                color = colorResource(R.color.grey_200),
                                thickness = 1.dp,
                                modifier = Modifier.padding(top = 10.dp)
                            )
                            Row(
                                modifier = Modifier.padding(
                                    top = 40.dp,
                                    bottom = 10.dp,
                                    start = 25.dp
                                ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Card(
                                    shape = RoundedCornerShape(4.dp),
                                    modifier = Modifier
                                        .padding(start = 22.dp)
                                        .clickable {
                                            captureImage()
                                            /*startActivity(
                                                Intent(
                                                    this@BottomSheetDialog,
                                                    CameraAct::class.java
                                                )
                                            )*/
                                        }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .width(150.dp)
                                            .height(113.dp)

                                            .background(
                                                Brush.horizontalGradient(
                                                    listOf(
                                                        PrimaryColor01, PrimaryColor02
                                                    )
                                                )
                                            ),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.CameraAlt,
                                            contentDescription = "camera",
                                            modifier = Modifier
                                                .padding(top = 25.dp)
                                                .width(28.dp)
                                                .height(25.dp),
                                        )
                                        Text(
                                            text = stringResource(id = R.string.take_photo),
                                            modifier = Modifier.padding(
                                                top = 20.dp,
                                                bottom = 23.dp
                                            ),
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                            color = colorResource(id = R.color.black),
                                        )
                                    }
                                }


                                Card(
                                    shape = RoundedCornerShape(4.dp),
                                    modifier = Modifier
                                        .padding(start = 16.dp, end = 22.dp)
                                        .clickable {
                                            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                                                val permissions =
                                                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                                                requestPermissions(permissions, permissionCode)
                                            } else {
                                                openGallery()
                                            }
                                        }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .width(150.dp)
                                            .height(113.dp)

                                            .background(
                                                Brush.horizontalGradient(
                                                    listOf(
                                                        PrimaryColor01, PrimaryColor02
                                                    )
                                                )
                                            ),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.ImageSearch,
                                            contentDescription = "camera",
                                            modifier = Modifier
                                                .padding(top = 25.dp)
                                                .width(28.dp)
                                                .height(25.dp),
                                        )
                                        Text(
                                            text = stringResource(id = R.string.browse),
                                            modifier = Modifier.padding(
                                                top = 20.dp,
                                                bottom = 23.dp
                                            ),
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                            color = colorResource(id = R.color.black),
                                        )
                                    }
                                }
                            }
                        }

                    }
                },
                sheetBackgroundColor = Color.White,
                sheetPeekHeight = 0.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        scope.launch {
                            if (sheetState.isCollapsed) {
                                sheetState.expand()
                            } else {
                                sheetState.collapse()
                            }
                        }
                    }) {
                        Text(
                        text = if (sheetState.isCollapsed) "Show Bottom Sheet" else "Hide Bottom Sheet",
                        )
                    }
                }
            }
        }
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
//                imageView.setImageBitmap(myBitmap)
                Log.e("capture_image_log",myBitmap.toString())
            }
        }

    private fun openGallery() {
        imageRequestCode = 2
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        onActivityResultForGallery.launch(gallery)
    }

    private var onActivityResultForGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            Log.e("IMAGE_REQUEST_CODE_log", imageRequestCode.toString())
            val imageUri = result.data?.data
            Log.e("imageUri_log", imageUri.toString())

        }

}