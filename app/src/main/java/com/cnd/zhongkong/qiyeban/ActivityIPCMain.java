package com.cnd.zhongkong.qiyeban.ipc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.cnd.zhongkong.qiyeban.R;
import com.tuya.smart.android.camera.sdk.TuyaIPCSdk;
import com.tuya.smart.android.camera.sdk.api.ITuyaIPCCore;
import com.tuya.smart.camera.middleware.p2p.ITuyaSmartCameraP2P;
import com.tuya.smart.camera.middleware.widget.AbsVideoViewCallback;
import com.tuya.smart.camera.middleware.widget.TuyaCameraView;

public class ActivityIPCMain extends AppCompatActivity {
    private static final String TAG="ActivityIPCMain:xwg";
    TuyaCameraView mVideoView;  //ipc预览界面
    private ITuyaSmartCameraP2P mCameraP2P;
    private int p2pType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_p_c_main);
        initData();
    }
//初始化画面
    private void initData() {
        String devId = "6cc27371826cae3b01vju2";
        try {
            Log.i(TAG,"initData");
            ITuyaIPCCore cameraInstance = TuyaIPCSdk.getCameraInstance();
            if (cameraInstance != null) {
                mCameraP2P = cameraInstance.createCameraP2P(devId);
                p2pType = cameraInstance.getP2PType(devId);
            }else
                Log.i(TAG,"cameraInstance is null");
            mVideoView=(TuyaCameraView)findViewById(R.id.camera_video_view);
            mVideoView.setViewCallback(new AbsVideoViewCallback() {
                @Override
                public void onCreated(Object o) {
                    super.onCreated(o);
                    Log.i(TAG,"onCreated");
                }

                @Override
                public void videoViewClick() {
                    super.videoViewClick();
                    Log.i(TAG,"videoViewClick");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG,"error:"+e.toString());
        }
    }//end initData
}