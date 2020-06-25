package io.agora.tutorials1v1vcall;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import java.util.List;
import java.util.ArrayList;

public class AppUtil {

        @TargetApi(Build.VERSION_CODES.M)
        public static boolean checkAndRequestAppPermission(@NonNull Activity activity, String[] permissions, int reqCode) {
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
                return true;

            List<String> pList = new ArrayList<>();
            for(String pem : permissions) {
                if (ContextCompat.checkSelfPermission(activity, pem) != PackageManager.PERMISSION_GRANTED)
                    pList.add(pem);
            }

            if (pList.size() == 0)
                return true;

            String[] requestPermissions = pList.toArray(new String[pList.size()]);
            activity.requestPermissions(requestPermissions, reqCode);
            //Async operations.So, return false directly!
            return false;}
}