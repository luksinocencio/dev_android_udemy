package com.devmeist3r.appgeradorqrcodejava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class MainActivity extends AppCompatActivity {

  EditText editQrCode;
  Button btnGerarQRCode;
  ImageView imgQRCode;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initComponentes();

    btnGerarQRCode.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (TextUtils.isEmpty(editQrCode.getText().toString())) {
          editQrCode.setError("*");
          editQrCode.requestFocus();
        } else {
          gerarQRCode(editQrCode.getText().toString());
        }
      }
    });
  }

  private void initComponentes() {
    editQrCode = findViewById(R.id.editQrCode);
    btnGerarQRCode = findViewById(R.id.btnGerarQRCode);
    imgQRCode = findViewById(R.id.imgQrCode);
  }

  private void gerarQRCode(String conteudoDoQRCode) {
    QRCodeWriter qrCode = new QRCodeWriter();

    try {
      BitMatrix bitMatrix = qrCode.encode(conteudoDoQRCode,
          BarcodeFormat.QR_CODE, 196, 196);

      int largura = bitMatrix.getWidth();
      int altura = bitMatrix.getHeight();

      Bitmap bitmap = Bitmap.createBitmap(largura, altura,
          Bitmap.Config.RGB_565);

      for (int x = 0; x < largura; x++) {
        for (int y = 0; y < altura; y++) {
          bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
        }
      }

      imgQRCode.setImageBitmap(bitmap);
      editQrCode.setText("");

    } catch (WriterException e) {
      e.printStackTrace();
    }

  }
}