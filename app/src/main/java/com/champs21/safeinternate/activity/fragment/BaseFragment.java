package com.champs21.safeinternate.activity.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.champs21.safeinternate.R;
import com.champs21.safeinternate.activity.activity.BaseActivity;


public class BaseFragment extends Fragment {
    private final String TAG = BaseFragment.class.getName();

    protected void showLog() {
        showLog(R.string.app_name);
    }

    protected void showLog(int resourceId) {
        showLog(getString(resourceId));
    }

    protected void showLog(String message) {
        Log.v(TAG, message);
    }

//    public void showToast() {
//        showToast(R.string.working_progress);
//    }

//    public void showToast(int resourceId) {
//        showToast(getString(resourceId));
//    }

//    public void showToast(String message) {
//        if (getActivity() instanceof BaseActivity)
//            ((BaseActivity) getActivity()).showToast(message);
//    }

    public void showProgressDialog() {
        showProgressDialog("", getString(R.string.loading));
    }

    public void showProgressDialog(String message) {
        showProgressDialog("", message);
    }

    public void showProgressDialog(String title, String message) {
        showProgressDialog(title, message, false);
    }

    public void showProgressDialog(String title, String message, boolean cancelable) {
        if (getActivity() instanceof BaseActivity)
            ((BaseActivity) getActivity()).showProgressDialog(title, message, cancelable);
    }

    public void closeProgressDialog() {
        if (getActivity() instanceof BaseActivity)
            ((BaseActivity) getActivity()).closeProgressDialog();
    }

    public void showSimpleDialog(String message) {
        if (getActivity() instanceof BaseActivity)
            ((BaseActivity) getActivity()).showSimpleDialog(message);
    }

    public void showSimpleDialog(int messageResourceId) {
        if (getActivity() instanceof BaseActivity)
            ((BaseActivity) getActivity()).showSimpleDialog(messageResourceId);
    }
}
