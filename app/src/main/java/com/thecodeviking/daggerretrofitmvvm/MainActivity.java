package com.thecodeviking.daggerretrofitmvvm;

import com.thecodeviking.daggerretrofitmvvm.viewmodels.MainViewModel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ViewModelActivity implements MainViewModel.Listener {
    private static final String TAG = MainActivity.class.toString();
    @Inject
    MainViewModel mMainViewModel;

    @Bind(R.id.resultsView)
    TextView resultsView;

    @Bind(R.id.searchTermEntry)
    EditText searchTermEntry;

    @OnClick(R.id.getUsersButton)
    public void getUsersButton_clicked() {
        mMainViewModel.getUsersCommand(searchTermEntry.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // IMPORTANT! Dagger must inject before the onCreate call or the viewModel won't be there
        // when it is looked for by the super class
        ((MyApplication) getApplication()).getComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        searchTermEntry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    getUsersButton_clicked();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void createViewModel() {
        mViewModel = mMainViewModel;
        mMainViewModel.setListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainViewModel = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainViewModel.setListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMainViewModel.clearListener();
    }

    @Override
    public void onError(String header, String message) {
        // show an alert dialog
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(header);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public void onTextChanged(String text) {
        resultsView.setText(text);
    }
}
