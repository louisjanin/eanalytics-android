package com.eulerian.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Francois Rouault on 07/03/2015.
 */
public class Utils {

    static boolean isPermissionGranted(Context context, String permission) {
        int res = context.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    static String getAppPackageName(Context context) {
        EALog.assertCondition(context != null, "Null app context, be sure to pass a not null context.");
        return context.getApplicationInfo().packageName;
    }

}
