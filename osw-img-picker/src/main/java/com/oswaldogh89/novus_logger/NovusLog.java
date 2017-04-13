package com.oswaldogh89.novus_logger;

import android.util.Log;

/**
 * Created by oswaldogh89 on 13/04/17.
 */

public class NovusLog {
    public static final String SUPER_NOVUS = "SUPER_NOVUS";

    public static void v(String msg) {
        Log.v(SUPER_NOVUS, msg);
    }
}