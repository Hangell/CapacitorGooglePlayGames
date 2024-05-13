package org.hangell.plugins.capacitorgoogleplaygames;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.google.android.gms.games.PlayGamesSdk;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.games.GamesSignInOptions;

@CapacitorPlugin(name = "CapacitorGooglePlayGames")
public class CapacitorGooglePlayGamesPlugin extends Plugin {

    private GamesSignInClient gamesSignInClient;

    @Override
    public void load() {
        super.load();
        // Initialize the Google Play Games SDK
        PlayGamesSdk.initialize(getContext());
        GamesSignInOptions signInOptions = GamesSignInOptions.builder()
            .requestServerAuthCode("your_web_client_id", false)
            .build();
        gamesSignInClient = PlayGamesSdk.getGamesSignInClient(getActivity(), signInOptions);
    }

    @PluginMethod
    public void signIn(PluginCall call) {
        gamesSignInClient.signIn().addOnCompleteListener(task -> {
            JSObject result = new JSObject();
            if (task.isSuccessful()) {
                // Handle successful login
                result.put("success", true);
                call.resolve(result);
            } else {
                // Handle failed login
                result.put("success", false);
                result.put("message", "Login failed");
                call.reject(result.toString());
            }
        });
    }

    @PluginMethod
    public void isAuthenticated(PluginCall call) {
        gamesSignInClient.isAuthenticated().addOnCompleteListener(task -> {
            JSObject result = new JSObject();
            result.put("isAuthenticated", task.getResult().isAuthenticated());
            call.resolve(result);
        });
    }
}
