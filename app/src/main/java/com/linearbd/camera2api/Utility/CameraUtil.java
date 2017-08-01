package com.linearbd.camera2api.Utility;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;

/**
 * Created by Genius 03 on 8/1/2017.
 */

public class CameraUtil {
    private static final String FRONT_CAMERA_ID="1";
    private static final String BACK_CAMERA_ID="0";
    private Context context;
    private CameraManager cameraManager;

    public CameraUtil(Context context) {
        this.context = context;
        cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
    }

    public boolean isFrontCameraAvailable(){
        boolean retbool= false;

        try {
            for(String x:cameraManager.getCameraIdList()){
                if(x.equals(FRONT_CAMERA_ID)){
                    retbool=true;
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        return retbool;


    }
    public boolean isBackCameraAvailable(){
        boolean retbool= false;

        try {
            for(String x:cameraManager.getCameraIdList()){
                if(x.equals(BACK_CAMERA_ID)){
                    retbool=true;
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        return retbool;


    }

    public CameraCharacteristics getFrontCameraCharacterstics(){
        CameraCharacteristics cameraCharacteristics = null;
        try{
            if(isFrontCameraAvailable()){
                cameraCharacteristics= cameraManager.getCameraCharacteristics(FRONT_CAMERA_ID);
            }
        }catch (CameraAccessException e){
            e.printStackTrace();
        }

        return cameraCharacteristics;

    }

    public CameraCharacteristics getBackCameraCharacterstics(){
        CameraCharacteristics cameraCharacteristics = null;
        try{
            if(isBackCameraAvailable()){
                cameraCharacteristics= cameraManager.getCameraCharacteristics(BACK_CAMERA_ID);
            }
        }catch (CameraAccessException e){
            e.printStackTrace();
        }

        return cameraCharacteristics;

    }
}
