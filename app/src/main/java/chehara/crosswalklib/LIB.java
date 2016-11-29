package chehara.crosswalklib;

import android.content.Context;
import android.content.Intent;

/**
 * Created by answerz on 29/11/16.
 */
public class LIB {

    public static void callFN(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
