package com.example.zbarview;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ZXingViewActivity extends AppCompatActivity implements QRCodeView.Delegate {

    private ZXingView zXingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing_view);

        zXingView = (ZXingView) findViewById(R.id.zxingview);

        zXingView.setDelegate(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        zXingView.startCamera();

        zXingView.showScanRect();

        zXingView.startSpot();
    }

    @Override
    protected void onStop() {
        super.onStop();
        zXingView.stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        zXingView.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        vibrate();
        Intent intent=new Intent();
        intent.putExtra("result",result);
        setResult(RESULT_OK,intent);

        finish();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}
