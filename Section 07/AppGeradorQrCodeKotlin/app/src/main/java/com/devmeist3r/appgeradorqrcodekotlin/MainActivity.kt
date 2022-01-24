package com.devmeist3r.appgeradorqrcodekotlin

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class MainActivity : AppCompatActivity() {

  private var editQrCode: EditText? = null
  private var btnGerarQRCode: Button? = null
  private var imgQrCode: ImageView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initComponents()

    btnGerarQRCode!!.setOnClickListener {
      if (TextUtils.isEmpty(editQrCode!!.text.toString())) {
        editQrCode!!.error = "*"
        editQrCode!!.requestFocus()
      } else {
        gerarQRCode(editQrCode!!.text.toString())
      }
    }
  }

  private fun gerarQRCode(conteudoQrCode: String) {
    val qrCode = QRCodeWriter()

    try {
      val bitMatrix = qrCode.encode(conteudoQrCode, BarcodeFormat.QR_CODE, 196, 196)

      val tamanho = bitMatrix.width
      val altura = bitMatrix.height

      val bitmap = Bitmap.createBitmap(tamanho, altura, Bitmap.Config.RGB_565)

      for (x in 0 until tamanho) {
        for (y in 0 until altura) {
          bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
        }
      }

      imgQrCode!!.setImageBitmap(bitmap)

    } catch (e: WriterException) {
      println(e)
    }
  }

  private fun initComponents() {
    editQrCode = findViewById(R.id.editQrCode)
    btnGerarQRCode = findViewById(R.id.btnGerarQRCode)
    imgQrCode = findViewById(R.id.imgQrCode)
  }
}