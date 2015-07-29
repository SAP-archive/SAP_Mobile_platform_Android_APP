package com.sap.epm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.sap.epm.R;
import com.sap.maf.tools.logon.core.LogonCore;
import com.sap.maf.tools.logon.core.LogonCoreException;
import com.sap.maf.tools.logon.logonui.api.LogonListener;
import com.sap.maf.tools.logon.logonui.api.LogonUIFacade;
import com.sap.maf.tools.logon.manager.LogonContext;
import com.sap.maf.tools.logon.manager.LogonManager;


public class LoginActivity extends Activity implements LogonListener{
    final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set context reference
        Context mContext = this;



        //Hide MobilePlace popup
        SharedPreferences prefs = getSharedPreferences(LogonCore.PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor pEditor = prefs.edit();
        pEditor.putBoolean(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_MOBILEPLACE.toString(), false);
        pEditor.commit();

        // get an instance of the LogonUIFacade
        LogonUIFacade logonUIFacade = LogonUIFacade.getInstance();
        //Initialize the Logon UI Facade
        logonUIFacade.init(this, mContext, "com.sap.epmsales");


        //Set Defaults
        logonUIFacade.setDefaultValue(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_SUPSERVERURL, "<Your SMP Server>");
        logonUIFacade.setDefaultValue(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_SUPSERVERPORT, "8080");
        logonUIFacade.setDefaultValue(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_HTTPSSTATUS, "false");

        // FURTHER LOGIN DETAILS
        //logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_SUPSERVERURL, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_SUPSERVERPORT, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_SECCONFIG, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_SUPSERVERFARMID, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_URLSUFFIX, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_MOBILEUSER, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_ACTIVATIONCODE, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_HTTPSSTATUS, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_GATEWAYCLIENT, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_SUPSERVERDOMAIN, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_PINGPATH, true);
        logonUIFacade.isFieldHidden(LogonCore.SharedPreferenceKeys.PREFERENCE_ID_GWONLY, true);


        // ask LogonUIFacede to present the logon screen
        // set the resulting view as the content view for this activity
        setContentView(logonUIFacade.logon());

        //Hide splash screen
        logonUIFacade.showSplashScreen(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLogonFinished(String s, boolean b, LogonContext logonContext) {
        Log.d(TAG, "onLogonFinished: was successful?" + b);
        //Check if it finished successfully
        if (b) {
            try {
                //For debugging purposes will log the app connection id and
                // the end point url.
                // In a productive app, remember to remove these logs
                String appConnID = LogonCore.getInstance().getLogonContext().getConnId();
                Log.d(TAG, "onLogonFinished: appcid:"+ appConnID);
                Log.d(TAG, "onLogonFinished: endpointurl:"+ logonContext.getEndPointUrl());

            } catch (LogonManager.LogonManagerException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            } catch (LogonCoreException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }

            // Navigate to the Main menu screen
            Intent goToNextActivity = new Intent(this, CentralActivity.class);
            startActivity(goToNextActivity);
            finish();
        } else {
            Log.d(TAG, "onLogonFinished: failed " + s);

        }

    }

    @Override
    public void onSecureStorePasswordChanged(boolean b, String s) {

    }

    @Override
    public void onBackendPasswordChanged(boolean b) {

    }

    @Override
    public void onUserDeleted() {

    }

    @Override
    public void onApplicationSettingsUpdated() {

    }

    @Override
    public void registrationInfo() {

    }

    @Override
    public void objectFromSecureStoreForKey() {

    }

    @Override
    public void onRefreshCertificate(boolean b, String s) {

    }
}
