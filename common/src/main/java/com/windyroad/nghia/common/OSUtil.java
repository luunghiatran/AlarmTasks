package com.windyroad.nghia.common;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

/**
 * Created by Imark-N on 12/9/2015.
 * Giúp đỡ về hệ điều hành
 */
public class OSUtil {
    /**
     * Tải file thông qua Downloader
     * todo làm 1 service download file, mở file
     */
    public static void DownloadFile(Context context, String strUrl, String dirType, String subPath, boolean notifyComplete) {
        DownloadManager.Request r = new DownloadManager.Request(Uri.parse(strUrl));

        if (dirType != null) {
            // This put the download in the same Download dir the browser uses
            r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "fileName");
        }

        // When downloading music and videos they will be listed in the player
        // (Seems to be available since Honeycomb only)
        //r.allowScanningByMediaScanner();

        if (notifyComplete) {
            // Notify user when download is completed
            // (Seems to be available since Honeycomb only)
            r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }

        // Start download
        DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        dm.enqueue(r);
    }
}
