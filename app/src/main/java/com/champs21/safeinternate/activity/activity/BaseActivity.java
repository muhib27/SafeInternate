package com.champs21.safeinternate.activity.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Color;

import android.net.Uri;

import android.support.annotation.NonNull;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;

import android.widget.Toast;

import com.champs21.safeinternate.R;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getName();

//    public void updateTitle(String title) {
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle(null);
//        }
//
//        TextView toolbarTitle = findViewById(R.id.toolbarTitle);
//        if (toolbarTitle != null) {
//            toolbarTitle.setSelected(true);
//            toolbarTitle.setText(title);
//        }
//    }

    public PackageInfo packageInfo;

    private ProgressDialog progressDialog;

    public void showProgressDialog() {
        showProgressDialog("", getString(R.string.loading));
    }

    public void showProgressDialog(int resourceId) {
        showProgressDialog("", getString(resourceId));
    }

    public void showProgressDialog(String message) {
        showProgressDialog("", message);
    }

    public void showProgressDialog(String title, String message) {
        showProgressDialog(title, message, false);
    }

    public void showProgressDialog(String title, String message, boolean cancelable) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, title, message);
            progressDialog.setCancelable(cancelable);
        } else {
            progressDialog.show();
        }
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void closeProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public void showLog(@NonNull String message) {
        Log.d(TAG, message);
    }

    public void showLog(int resourceId) {
        showLog(getString(resourceId));
    }

    public void showLog() {
        showLog(R.string.working_progress);
    }

    public void showToast() {
        showToast(R.string.working_progress);
    }

    public void showToast(int resourceId) {
        showToast(getString(resourceId));
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public boolean isEmailValid(String emailAddress) {
        return Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
    }

    public boolean isPasswordValid(String password) {
        return password.length() > 4;
    }



//    protected void startNewAdActivity() {
//        Intent newAdIntent = new Intent(this, PostNewAdActivity.class);
//        newAdIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//        startActivityForResult(newAdIntent, AppConstants.newAdType);
//    }


//    protected void shareAction() {
//        Intent sendIntent = new Intent();
//        sendIntent.setAction(Intent.ACTION_SEND);
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey check out the latest To-Let app:\nhttps://play.google.com/store/apps/details?id=" +
//                getPackageName());
//        sendIntent.setType("text/plain");
//        startActivityForResult(sendIntent, AppConstants.shareApp);
//    }

    public void showSimpleDialog(String message) {
        showSimpleDialog("Alert", message);
    }

    public void showSimpleDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setIcon(R.mipmap.ic_launcher_round);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void showSimpleDialog(int messageResourceId) {
        showSimpleDialog(getString(messageResourceId));
    }

    public void showSimpleDialog(int titleResourceId, int messageResourceId) {
        showSimpleDialog(getString(titleResourceId), getString(messageResourceId));
    }

    private Dialog searchDialog;
    public static String[] childArray;
    public static long fromDateTime = 0;
    public static long toDateTime = 0;
    public static long rentMinLong = 0;
    public static long rentMaxLong = 0;





//    public void showMandatoryUpdateAlert() {
//        AdListActivity2.alreadyShowedAlert = true;
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle(R.string.alert);
//        builder.setMessage(R.string.this_update_is_mandatory_please_update_your_app_for_better_performance);
//        builder.setPositiveButton(R.string.update, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                startPlayStoreActivity();
//            }
//        });
//        builder.setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (BaseActivity.this instanceof AdListActivity2) {
//                    finish();
//                } else {
//                    Intent mainIntent = new Intent(BaseActivity.this, AdListActivity2.class);
//                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(mainIntent);
//                }
//            }
//        });
//        final AlertDialog dialog = builder.create();
//
//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
//    }

    private void startPlayStoreActivity() {
        Intent updateIntent;
        try {
            updateIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + getPackageName()));
        } catch (android.content.ActivityNotFoundException e) {
            updateIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id="
                            + getPackageName()));
        }
        updateIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(updateIntent);
    }
}
